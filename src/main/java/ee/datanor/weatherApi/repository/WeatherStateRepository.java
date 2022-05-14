package ee.datanor.weatherApi.repository;

import ee.datanor.weatherApi.model.WeatherState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherStateRepository extends JpaRepository<WeatherState, Long> {
}
