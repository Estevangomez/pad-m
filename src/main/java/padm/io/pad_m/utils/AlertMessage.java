package padm.io.pad_m.utils;

public class AlertMessage {

    private String type; // success, danger, warning, info
    private String message;

    // Construtor, getters e setters
    public AlertMessage(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
