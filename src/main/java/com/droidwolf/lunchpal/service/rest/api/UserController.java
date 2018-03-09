package com.droidwolf.lunchpal.service.rest.api;

import com.droidwolf.lunchpal.service.protocol.UserDto;
import com.droidwolf.lunchpal.service.domain.User;

import java.util.List;
import java.util.UUID;

public interface UserController {

    List<User> allUsers(UUID groupId);

    User create(UserDto user);

    User update(UUID userId, UserDto userDto);

    void delete(UUID userId);
}
