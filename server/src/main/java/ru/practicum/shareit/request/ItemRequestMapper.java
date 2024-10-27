package ru.practicum.shareit.request;

import lombok.experimental.UtilityClass;
import ru.practicum.shareit.request.dto.ItemRequestDTO;

import java.util.ArrayList;

@UtilityClass
public class ItemRequestMapper {
    public ItemRequest toItemRequest(ItemRequestDTO itemRequestDTO) {
        return ItemRequest.builder()
                .id(itemRequestDTO.getId())
                .description(itemRequestDTO.getDescription())
                .created(itemRequestDTO.getCreated())
                .requestorId(itemRequestDTO.getRequestorId())
                .build();
    }

    public ItemRequestDTO toItemRequestDTO(ItemRequest itemRequest) {
        return ItemRequestDTO.builder()
                .id(itemRequest.getId())
                .description(itemRequest.getDescription())
                .items(new ArrayList<>())
                .created(itemRequest.getCreated())
                .requestorId(itemRequest.getRequestorId())
                .build();
    }
}
