package ee.datanor.weatherApi.controller;

import ee.datanor.weatherApi.model.WeatherState;
import ee.datanor.weatherApi.service.WeatherStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("weather")
@RestController
public class WeatherStateController {

    private final WeatherStateService weatherStateService;

    @Autowired
    public WeatherStateController(WeatherStateService weatherStateService) {
        this.weatherStateService = weatherStateService;
    }

    @GetMapping
    public List<WeatherState> getAllWeatherStates() {

        System.out.println(weatherStateService.getAllWeatherStates());
        return weatherStateService.getAllWeatherStates();
    }

    @DeleteMapping("{id}")
    public void deleteWeather(@PathVariable Long id) {
        weatherStateService.deleteWeatherState(id);
    }
}
