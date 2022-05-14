package ee.datanor.weatherApi.service;

import ee.datanor.weatherApi.model.WeatherState;
import ee.datanor.weatherApi.repository.WeatherStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class WeatherStateService {
    private final WeatherStateRepository weatherStateRepository;

    @Autowired
    public WeatherStateService(WeatherStateRepository weatherStateRepository) {
        this.weatherStateRepository = weatherStateRepository;
    }

    public List<WeatherState> getAllWeatherStates() {
        return weatherStateRepository.findAll((Sort.by(Sort.Direction.DESC, "id")));
    }

    public WeatherState saveWeatherState(@RequestBody WeatherState weatherState) {
        return weatherStateRepository.save(weatherState);
    }

    public void deleteWeatherState(Long id) {
        weatherStateRepository.deleteById(id);
    }

}
