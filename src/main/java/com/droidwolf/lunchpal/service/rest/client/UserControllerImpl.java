package com.droidwolf.lunchpal.service.rest.client;

import com.droidwolf.lunchpal.service.protocol.UserDto;
import com.droidwolf.lunchpal.service.domain.User;
import com.droidwolf.lunchpal.service.rest.api.UserController;
import com.droidwolf.lunchpal.service.rest.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/users", produces = APPLICATION_JSON_VALUE)
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @GetMapping(path = "/groups/{groupId}")
    public List<User> allUsers(@PathVariable("groupId") String groupId) {
        return userService.getAllUsersInGroup(groupId);
    }

    @Override
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public User create(@RequestBody UserDto user) {
        return userService.createNewUser(user.getName());
    }

    @Override
    @PutMapping(path = "/{userId}", consumes = APPLICATION_JSON_VALUE)
    public User update(@PathVariable("userId") String userId, @RequestBody UserDto userDto){
        User user = userService.updateUser(userId, userDto);
        if (user == null) {
            System.out.println("Could not update user: " + userId);
        }
        return user;
    }

    @Override
    @DeleteMapping(path = "/{userId}")
    public void delete(@PathVariable("userId") String userId) {
        User deletedUser = userService.deleteUser(userId);
        if (deletedUser == null) {
            System.out.println("Could not delete user: " + userId);
        }
    }

}
