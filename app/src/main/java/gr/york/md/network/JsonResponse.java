package gr.york.md.network;

public class JsonResponse {
    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String messsage) {
        this.message = messsage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "JsonResponse{" +
                "messsage='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
