package exception;

public class SoldOutException extends Exception{
    public SoldOutException(String message) {
        super(message);
    }

    @Override
    public void printStackTrace() {
        System.err.println("[ERROR] "+super.getMessage()+" has been sold out.");
    }
}
