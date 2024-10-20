package ru.practicum.shareit.item;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.exception.markers.Create;
import ru.practicum.shareit.exception.markers.Update;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.service.ItemService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/items")
public class ItemController {

    public static final String USER_ID_HEADER = "X-Sharer-User-Id";

    private final ItemService itemService;

    @PostMapping
    public ItemDto add(@Validated({Create.class})
                       @RequestBody ItemDto itemDto,
                       @RequestHeader(USER_ID_HEADER) Long userId) {
        log.info("POST Запрос на добавление пользователем с id-{} предмета {}", userId, itemDto);
        return itemService.add(itemDto, userId);
    }

    @PatchMapping("/{itemId}")
    public ItemDto update(@Validated({Update.class})
                          @RequestBody ItemDto itemDto,
                          @PathVariable Long itemId,
                          @RequestHeader(USER_ID_HEADER) Long userId) {
        log.info("PATCH Запрос на обновление предмета по id-{} пользователем c id-{}", itemId, userId);
        return itemService.update(itemDto, itemId, userId);
    }

    @GetMapping("/{itemId}")
    public ItemDto findById(@PathVariable Long itemId) {
        log.info("GET Запрос поиска предмета по id-{}", itemId);
        return itemService.findById(itemId);
    }

    @GetMapping
    public List<ItemDto> findAllByUserId(@RequestHeader(USER_ID_HEADER) Long userId) {
        log.info("GET Запрос на поиск предметов пользователя c id-{}", userId);
        return itemService.findAllByUserId(userId);
    }

    @GetMapping("/search")
    public List<ItemDto> findByRequest(@RequestParam String text) {
        log.info("GET Запрос на поиск предметов по запросам от пользователя: {}", text);
        return itemService.findItemsByUserRequest(text);
    }
}