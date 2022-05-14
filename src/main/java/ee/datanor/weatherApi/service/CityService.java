package ee.datanor.weatherApi.service;

import ee.datanor.weatherApi.exception.ApiSomethingWentWrongException;
import ee.datanor.weatherApi.model.City;
import ee.datanor.weatherApi.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;

    }

    public List<City> getAllCities() {
        return cityRepository.findAll((Sort.by(Sort.Direction.DESC, "id")));
    }

    public City saveCity(@RequestBody City city) {
            if (cityRepository.existsByCityId(city.getCityId())) {
                throw new ApiSomethingWentWrongException("City already exists but the latest weather state has been fetched.");
            }
            return cityRepository.save(city);

    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
