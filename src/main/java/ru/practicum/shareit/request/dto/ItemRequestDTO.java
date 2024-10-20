package ru.practicum.shareit.request.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ItemRequestDTO {
    private Long id;
    private String description;
    private Long requester;
    private LocalDateTime created;
}