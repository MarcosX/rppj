package strategy;

public class RespostaLogin {

    private String message;

    private boolean status;

    public RespostaLogin(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public boolean getStatus() {
        return status;
    }
}
