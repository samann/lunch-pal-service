package com.droidwolf.lunchpal.service.rest.client;

import com.droidwolf.lunchpal.service.dao.UserDao;
import com.droidwolf.lunchpal.service.domain.User;
import com.droidwolf.lunchpal.service.rest.api.UserController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class UserControllerImpl implements UserController {

    private static final String USER_NAME_PATH = "/users/{name}";

    private final UserDao userDao;

    public UserControllerImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @GetMapping(path = "/users", produces = APPLICATION_JSON_VALUE)
    public List<User> allUsers() {
        return userDao.getAll();
    }

    @Override
    @GetMapping(path = USER_NAME_PATH) //TODO: add serializers to handle input for a POST
    public User create(@PathVariable("name") String name) {
        User user = new User(name);
        userDao.save(user.getId(), user);
        return user;
    }

    @Override
    @DeleteMapping(path = "/users/{userId}")
    public void delete(@PathVariable("userId") String userId) {

        if (!validateParameter(userId, "Missing name! Cannot delete")) return;

        doDelete(userId);
    }

    private boolean validateParameter(String userId, String message) {
        if (userId == null || userId.isEmpty()) {
            System.out.println(message);
            return false;
        }
        return true;
    }

    private void doDelete(String userId) {
        try {
            UUID id = UUID.fromString(userId);

            userDao.lock(id);
            User deletedUser = userDao.remove(id);
            String s = deletedUser != null ? "Deleted: " + deletedUser.getName() : "No user found";
            System.out.println(s);
            userDao.unlock(id);
        } catch (IllegalArgumentException e){
            System.out.println("Not a valid userId");
        }
    }
}
