package ee.datanor.weatherApi.repository;

import ee.datanor.weatherApi.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    boolean existsByCityId(Long cityId);
}
