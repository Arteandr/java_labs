package lab6;

public class CustomException extends Exception {
    private final String description;
    public CustomException(String description) {
        this.description = description;
    }

    public String toString() {
        return "[ОШИБКА]: " + description;
    }
}
