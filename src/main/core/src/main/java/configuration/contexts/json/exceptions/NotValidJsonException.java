package configuration.contexts.json.exceptions;

public class NotValidJsonException extends Exception {
    public NotValidJsonException() {
        super("It's not a valid json file");
    }
}
