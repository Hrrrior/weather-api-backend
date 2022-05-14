package ee.datanor.weatherApi.controller;


import ee.datanor.weatherApi.model.City;
import ee.datanor.weatherApi.model.WeatherState;
import ee.datanor.weatherApi.service.CityService;
import ee.datanor.weatherApi.service.WeatherApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("cities")
@RestController
public class CityController {

    private final CityService cityService;
    private final WeatherApiService weatherApiService;


    @Autowired
    public CityController(CityService cityService, WeatherApiService weatherApiService) {
        this.cityService = cityService;
        this.weatherApiService = weatherApiService;

    }

    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @PostMapping
    public City saveCity(@RequestBody City city) {
        WeatherState weatherState = weatherApiService.getCurrentWeather(city.getName());
        City newCity = new City(weatherState.getCityName(), weatherState.getCityId());
        return cityService.saveCity(newCity);
    }

    @DeleteMapping("{id}")
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
    }
}
