package ee.datanor.weatherApi.model;

import java.util.Date;

public class WeatherStateBuilder {
    private Long id;
    private String cityName;
    private Long cityId;
    private String country;
    private String temperature;
    private String humidity;
    private String windSpeed;
    private Date datetime;

    public WeatherStateBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public WeatherStateBuilder setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public WeatherStateBuilder setCityId(Long cityId) {
        this.cityId = cityId;
        return this;
    }

    public WeatherStateBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public WeatherStateBuilder setTemperature(String temperature) {
        this.temperature = temperature;
        return this;
    }

    public WeatherStateBuilder setHumidity(String humidity) {
        this.humidity = humidity;
        return this;
    }

    public WeatherStateBuilder setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
        return this;
    }

    public WeatherStateBuilder setDatetime(Date datetime) {
        this.datetime = datetime;
        return this;
    }

    public WeatherState createWeatherState() {
        return new WeatherState(cityName, cityId, country, temperature, humidity, windSpeed, datetime);
    }
}