package sheridan.tetervak.cardata.errors;

public record ApiError(
        int status,
        String error,
        String message
){}
