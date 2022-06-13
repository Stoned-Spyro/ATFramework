package API.StatusCodes;


public enum StatusCode {

    OK(200),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    public final int value;

    StatusCode(int value) {
        this.value = value;
    }
}