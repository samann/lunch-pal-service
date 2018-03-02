package com.droidwolf.lunchpal.service.rest.client;

import com.droidwolf.lunchpal.service.rest.api.UserController;
import domain.User;
import io.netty.util.internal.ConcurrentSet;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class UserControllerImpl implements UserController {

    private static final String USER_NAME_PATH = "/users/{name}";

    private final Set<User> users = new ConcurrentSet<User>();

    @Override
    @GetMapping(path = "/users", produces = APPLICATION_JSON_VALUE)
    public List<User> allUsers() {
        return new ArrayList<>(users);
    }

    @Override
    @GetMapping(path = USER_NAME_PATH) //TODO: add serializers to handle input for a POST
    public User create(@PathVariable("name") String name) {
        User user = new User(name);
        synchronized (users) {
            users.add(user);
        }
        return user;
    }

    @Override
    @DeleteMapping(path = USER_NAME_PATH)
    public void delete(@PathVariable("name") String name) {
        if (name == null || name.isEmpty()){
            System.out.println("Missing name! Cannot delete");
            return;
        }
        Optional<User> user = users.stream().filter(u -> u.getName().equalsIgnoreCase(name)).findFirst();
        if (user.isPresent()) {
            synchronized (users) {
                System.out.println("Deleting : " + name);
                users.remove(user.get());
            }
            return;
        }
        System.out.println("No user :" + name + " to delete");
    }
}
