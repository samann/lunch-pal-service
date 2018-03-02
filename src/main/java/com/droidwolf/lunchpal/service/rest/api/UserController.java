package com.droidwolf.lunchpal.service.rest.api;

import com.droidwolf.lunchpal.service.domain.User;

import java.util.List;

public interface UserController {

    List<User> allUsers();

    User create(String user);

    void delete(String name);
}
