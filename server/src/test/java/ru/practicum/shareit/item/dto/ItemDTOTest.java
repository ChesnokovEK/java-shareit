package ru.practicum.shareit.item.dto;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ItemDTOTest {
    private final JacksonTester<ItemDTO> json;

    @Test
    public void testItemDTO() throws Exception {
        ItemDTO itemDTO = ItemDTO
                .builder()
                .id(1L)
                .name("user name")
                .description("description")
                .available(true)
                .lastBooking(null)
                .nextBooking(null)
                .comments(null)
                .requestId(null)
                .build();

        JsonContent<ItemDTO> result = json.write(itemDTO);

        assertThat(result).extractingJsonPathNumberValue("$.id").isEqualTo(1);
        assertThat(result).extractingJsonPathStringValue("$.name").isEqualTo(itemDTO.getName());
        assertThat(result).extractingJsonPathStringValue("$.description").isEqualTo(itemDTO.getDescription());
        assertThat(result).extractingJsonPathBooleanValue("$.available").isEqualTo(itemDTO.getAvailable());
        assertThat(result).extractingJsonPathValue("$.lastBooking").isEqualTo(null);
        assertThat(result).extractingJsonPathValue("$.nextBooking").isEqualTo(null);
        assertThat(result).extractingJsonPathValue("$.comments").isEqualTo(null);
        assertThat(result).extractingJsonPathNumberValue("$.comments").isEqualTo(null);
    }

}
