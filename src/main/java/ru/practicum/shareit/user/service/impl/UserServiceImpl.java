package ru.practicum.shareit.user.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.exception.NotFoundException;
import ru.practicum.shareit.user.UserMapper;
import ru.practicum.shareit.user.dao.UserDao;
import ru.practicum.shareit.user.User;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public UserDto add(UserDto userDto) {
        User user = UserMapper.toUser(userDto, userDto.getId());
        return UserMapper.toUserDto(userDao.add(user));
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        User user = UserMapper.toUser(userDto, id);
        return UserMapper.toUserDto(userDao.update(id, user));
    }

    @Override
    public UserDto findById(Long id) {
        User user = userDao.findById(id)
                .orElseThrow(() -> {
                            log.warn("Не найден пользователь с id: {}", id);
                            return new NotFoundException(String.format("не найден пользователь с id: %d", id));
                        }
                );
        return UserMapper.toUserDto(user);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public List<UserDto> findAll() {
        return userDao.findAll()
                .stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

}