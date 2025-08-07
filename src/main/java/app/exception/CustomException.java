package app.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomException extends Exception {

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String userMessage, String systemMessage) {
        super(userMessage);
        Logger.getLogger("web").log(Level.SEVERE, systemMessage);
    }
}