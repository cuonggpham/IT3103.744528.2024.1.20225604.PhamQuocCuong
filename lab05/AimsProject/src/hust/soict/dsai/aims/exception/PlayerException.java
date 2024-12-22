// Pham Quoc Cuong - 20225604
package hust.soict.dsai.aims.exception;

public class PlayerException extends Exception {
    public PlayerException(String message) {
        super(message);
    }

    @Override
    public void printStackTrace() {
        System.out.println("PlayerException: " + this.getMessage());
    }
}
