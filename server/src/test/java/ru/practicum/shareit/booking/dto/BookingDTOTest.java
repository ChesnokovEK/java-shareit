package ru.practicum.shareit.booking.dto;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import ru.practicum.shareit.booking.BookingStatus;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BookingDTOTest {
    private final JacksonTester<BookingDTO> json;

    @Test
    public void testBookingDTO() throws Exception {
        BookingDTO bookingDTO = BookingDTO
                .builder()
                .id(1L)
                .start(LocalDateTime.now().plusMinutes(1).withNano(0))
                .end(LocalDateTime.now().plusDays(10).withNano(0))
                .bookerId(5L)
                .itemId(3L)
                .status(BookingStatus.WAITING)
                .build();

        JsonContent<BookingDTO> result = json.write(bookingDTO);

        assertThat(result).extractingJsonPathNumberValue("$.id").isEqualTo(1);
        assertThat(result).extractingJsonPathNumberValue("$.itemId").isEqualTo(3);
        assertThat(result).extractingJsonPathNumberValue("$.bookerId").isEqualTo(5);
        assertThat(result).extractingJsonPathStringValue("$.status").isEqualTo(bookingDTO.getStatus().toString());
        assertThat(result).extractingJsonPathValue("$.start").isEqualTo(bookingDTO.getStart().toString());
        assertThat(result).extractingJsonPathValue("$.end").isEqualTo(bookingDTO.getEnd().toString());
    }
}
