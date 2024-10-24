package fligtht.Booking.exception;

public class VuelosNotFoundException extends RuntimeException {

    public VuelosNotFoundException() {
    }

    public VuelosNotFoundException(String message) {
        super(message);
    }

    public VuelosNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public VuelosNotFoundException(Throwable cause) {
        super(cause);
    }

    public VuelosNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
