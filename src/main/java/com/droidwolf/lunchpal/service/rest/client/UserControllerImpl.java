package com.droidwolf.lunchpal.service.rest.client;

import com.droidwolf.lunchpal.service.domain.User;
import com.droidwolf.lunchpal.service.rest.api.UserController;
import com.droidwolf.lunchpal.service.rest.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class UserControllerImpl implements UserController {

    private static final String USER_NAME_PATH = "/users/{name}";

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @GetMapping(path = "/users/groups/{groupId}", produces = APPLICATION_JSON_VALUE)
    public List<User> allUsers(@PathVariable("groupId") String groupId) {
        return userService.getAllUsersInGroup(groupId);
    }

    @Override
    @GetMapping(path = USER_NAME_PATH) //TODO: add serializers to handle input for a POST
    public User create(@PathVariable("name") String name) {
        return userService.createNewUser(name);
    }

    @Override
    @GetMapping(path = "/users/{userId}/{groupId}/{groupDesc}")
    public User update(@PathVariable("userId") String userId, @PathVariable("groupId") String groupId, @PathVariable("groupDesc") String groupDesc) {
        User user = userService.updateUserForGroup(userId, groupId, groupDesc);
        if (user == null) {
            System.out.println("Could not update user: " + userId);
        }
        return user;
    }

    @Override
    @DeleteMapping(path = "/users/{userId}")
    public void delete(@PathVariable("userId") String userId) {
        User deletedUser = userService.deleteUser(userId);
        if (deletedUser == null) {
            System.out.println("Could not delete user: " + userId);
        }
    }

}
