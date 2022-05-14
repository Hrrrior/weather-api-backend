package ee.datanor.weatherApi.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ee.datanor.weatherApi.exception.ApiNotFoundException;
import ee.datanor.weatherApi.exception.ApiSomethingWentWrongException;
import ee.datanor.weatherApi.model.City;
import ee.datanor.weatherApi.model.WeatherApiResponse;
import ee.datanor.weatherApi.model.WeatherState;
import ee.datanor.weatherApi.model.WeatherStateBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.MessageFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

@Service
@Configuration
@EnableScheduling
public class WeatherApiService {
    private final WeatherStateService weatherStateService;
    private final CityService cityService;
    private Gson gson;

    @Value("${apiKey: default null}")
    private String apiKey;

    @Autowired
    public WeatherApiService(WeatherStateService weatherStateService, CityService cityService) {
        this.weatherStateService = weatherStateService;
        this.cityService = cityService;
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Scheduled(fixedDelayString = "PT15M")
    public void scheduledWeatherFetcher() {
        List<City> cities = cityService.getAllCities();
        cities.forEach(city -> getCurrentWeather(city.getName()));
    }

    public WeatherState getCurrentWeather(String city) {
        String apiKey = this.apiKey;
        String apiUrl = MessageFormat
                .format("https://api.openweathermap.org/data/2.5/weather?q={0}&appid={1}&units=metric", city.replace(" ", "+"), apiKey);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .timeout(Duration.ofSeconds(20))
                .header("Content-Type", "application/json")
                .build();
        try {
            String responseBody = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body).join();

            WeatherApiResponse weatherApiResponse = gson.fromJson(responseBody, WeatherApiResponse.class);

            if (weatherApiResponse.getId() != null && weatherApiResponse.getName() != null && weatherApiResponse.getSys() != null) {
                WeatherState weatherState = new WeatherStateBuilder()
                        .setCityId(weatherApiResponse.getId())
                        .setCountry(weatherApiResponse.getSys().getCountry())
                        .setDatetime(weatherApiResponse.getDt() != null ? new Date(weatherApiResponse.getDt() * 1000L) : null)
                        .setCityName(weatherApiResponse.getName())
                        .setHumidity(weatherApiResponse.getMain() != null ? weatherApiResponse.getMain().getHumidity() : "Not measured")
                        .setTemperature(weatherApiResponse.getMain() != null ? weatherApiResponse.getMain().getTemp() : "Not measured")
                        .setWindSpeed(weatherApiResponse.getWind() != null ? weatherApiResponse.getWind().getSpeed() : "Not measured").createWeatherState();

                return weatherStateService.saveWeatherState(weatherState);
            } else {
                throw new ApiNotFoundException("City not found by the open weather api!");
            }

        } catch (ApiNotFoundException e) {
            throw e;
        }
        catch (Exception e) {
            throw new ApiSomethingWentWrongException("Something went wrong. Try again later.");
        }

    }

}