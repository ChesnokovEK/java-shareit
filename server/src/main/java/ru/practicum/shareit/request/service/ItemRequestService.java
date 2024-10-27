package ru.practicum.shareit.request.service;

import ru.practicum.shareit.request.dto.ItemRequestDTO;

import java.util.List;

public interface ItemRequestService {

    ItemRequestDTO createRequest(Long userId, ItemRequestDTO itemRequestDTO);

    ItemRequestDTO findById(Long requestId, Long userId);

    List<ItemRequestDTO> findAllByUser(Long userId);

    List<ItemRequestDTO> findAll(Long userId, int from, int size);

}
