package co.istad.mongodb.dto;

import java.util.List;

public record FilterDto(
        List<String> filter
) {
}
