package com.droidwolf.lunchpal.service.rest.api;

import com.droidwolf.lunchpal.service.protocol.UserDto;
import com.droidwolf.lunchpal.service.domain.User;

import java.util.List;

public interface UserController {

    List<User> allUsers(String groupId);

    User create(UserDto user);

    User update(String userId, UserDto userDto);

    void delete(String name);
}
