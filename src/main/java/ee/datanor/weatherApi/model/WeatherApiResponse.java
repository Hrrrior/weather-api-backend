package ee.datanor.weatherApi.model;

public class WeatherApiResponse {
    private Long id;
    private String name;
    private Main main;
    private Wind wind;
    private Long dt;
    private Sys sys;

    public Sys getSys() {
        return sys;
    }

    public Long getDt() {
        return dt;
    }

    public WeatherApiResponse(Long id, String name, Main main, Wind wind, Long dt, Sys sys) {
        this.id = id;
        this.name = name;
        this.main = main;
        this.wind = wind;
        this.dt = dt;
        this.sys = sys;
    }

    @Override
    public String toString() {
        return "WeatherApiResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", main=" + main +
                ", wind=" + wind +
                ", dt=" + dt +
                ", sys=" + sys +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }


    public static class Main {
        private String temp;
        private String humidity;

        public Main(String temp, String humidity) {
            this.temp = temp;
            this.humidity = humidity;
        }

        public String getTemp() {
            return temp;
        }

        public String getHumidity() {
            return humidity;
        }

        @Override
        public String toString() {
            return "Main{" +
                    "temp='" + temp + '\'' +
                    ", humidity='" + humidity + '\'' +
                    '}';
        }
    }

    public static class Wind {
        private String speed;

        public Wind(String speed) {
            this.speed = speed;
        }

        public String getSpeed() {
            return speed;
        }

        @Override
        public String toString() {
            return "Wind{" +
                    "speed='" + speed + '\'' +
                    '}';
        }
    }

    public static class Sys {
        private String country;

        public Sys(String country) {
            this.country = country;
        }

        public String getCountry() {
            return country;
        }

        @Override
        public String toString() {
            return "Sys{" +
                    "country='" + country + '\'' +
                    '}';
        }
    }
}
