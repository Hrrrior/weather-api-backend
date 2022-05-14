package ee.datanor.weatherApi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class WeatherState {
    @Id
    @SequenceGenerator(name = "weatherstate_sequence", sequenceName = "weatherstate_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "weatherstate_sequence")
    private Long id;
    private String cityName;
    private Long cityId;
    private String country;
    private String temperature;
    private String humidity;
    private String windSpeed;
    private Date datetime;

    public WeatherState(Long id, String cityName, Long cityId, String country, String temperature, String humidity, String windSpeed, Date datetime) {
        this.id = id;
        this.cityName = cityName;
        this.cityId = cityId;
        this.country = country;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.datetime = datetime;
    }

    public WeatherState(String cityName, Long cityId, String country, String temperature, String humidity, String windSpeed, Date datetime) {
        this.cityName = cityName;
        this.cityId = cityId;
        this.country = country;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.datetime = datetime;
    }

    public WeatherState() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "WeatherState{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", cityId=" + cityId +
                ", country='" + country + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", datetime=" + datetime +
                '}';
    }

}
