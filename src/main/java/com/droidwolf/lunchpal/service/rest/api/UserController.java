package com.droidwolf.lunchpal.service.rest.api;

import com.droidwolf.lunchpal.service.domain.User;

import java.util.List;

public interface UserController {

    List<User> allUsers(String groupId);

    User create(String user);

    User update(String userId, String groupId, String groupDesc);

    void delete(String name);
}
