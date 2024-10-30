package ru.practicum.shareit.comment.dto;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CommentDTOTest {
    private final JacksonTester<CommentDTO> json;

    @Test
    public void testBookingDTO() throws Exception {
        CommentDTO commentDTO = CommentDTO
                .builder()
                .id(1L)
                .text("comment text")
                .authorName("user name")
                .created(LocalDateTime.now().plusMinutes(1).withNano(0))
                .itemId(3L)
                .build();

        JsonContent<CommentDTO> result = json.write(commentDTO);

        assertThat(result).extractingJsonPathNumberValue("$.id").isEqualTo(1);
        assertThat(result).extractingJsonPathStringValue("$.text").isEqualTo(commentDTO.getText());
        assertThat(result).extractingJsonPathStringValue("$.authorName").isEqualTo(commentDTO.getAuthorName());
        assertThat(result).extractingJsonPathStringValue("$.created").isEqualTo(commentDTO.getCreated().toString());
        assertThat(result).extractingJsonPathNumberValue("$.itemId").isEqualTo(3);
    }
}