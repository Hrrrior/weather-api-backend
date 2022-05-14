package ee.datanor.weatherApi.exception;

public class ApiSomethingWentWrongException extends RuntimeException {
    public ApiSomethingWentWrongException(String message) {
        super(message);
    }

}
