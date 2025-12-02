package co.istad.mongodb.dto;

public record UserResponse(
        String id,
        String username,
        String email,
        Integer age,
        String location
) {
}
