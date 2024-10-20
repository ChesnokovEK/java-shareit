package ru.practicum.shareit.booking.repository;

import ru.practicum.shareit.booking.model.Booking;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.shareit.booking.BookingStatus;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.user.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByItemOwner(User owner);

    List<Booking> findByBooker(User user);

    List<Booking> findAllByItemAndStatusOrderByStartAsc(Item item, BookingStatus status);

    List<Booking> findAllByItemInAndStatusOrderByStartAsc(List<Item> items, BookingStatus status);

    boolean existsBookingByItemAndBookerAndStatusNotAndStartBefore(Item item, User booker,
                                                                   BookingStatus status, LocalDateTime time);
}