package co.istad.mongodb.dto;

public record UserRequest(
        String username,
        String email
) {
}
