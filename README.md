# Getting Started

## About
Spring Boot REST based API with a PostgreSQL database that uses the OPEN WEATHER API to track weather in given cities.

Developed with JDK 17 and PostgreSQL 14 on Windows 11.

## How to run
 * #### With Docker (probably works)
   * Create a ```.env``` file in the root folder. Into the ```.env``` file insert an environmental variable ```apiKey=*key*```, where ```*key*``` is replaced with your api key that you got from [here](https://openweathermap.org/api). 
   * Assuming that you have docker installed and running. Run ```docker-compose -f .\src\main\docker\docker-compose.yml up```

 * #### Without docker
   * Go to ```src/main/resources/application.properties``` and set ```apiKey=``` to equal your api that you got from [here](https://openweathermap.org/api). 
   * In the same file configure a database, username, password for PostgreSQL. Default database name is ```weather```.
   * Start the application in the ```src/main/java/ee/datanor/weatherApi/WeatherApiApplication```. Probably needs java 17.

## good luck/ have fun
