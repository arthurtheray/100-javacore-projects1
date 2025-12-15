package prg51;

public class WrongSettingsException extends Exception {
    public WrongSettingsException(String message) {
        super(message);
    }

    public WrongSettingsException() {
        super();
    }
}
