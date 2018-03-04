package com.droidwolf.lunchpal.service.rest.service;

import com.droidwolf.lunchpal.service.dao.GetUpdateDeleteDao;
import com.droidwolf.lunchpal.service.domain.User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
public class UserService {

    private final GetUpdateDeleteDao<UUID, User> userDao;

    public UserService(GetUpdateDeleteDao<UUID, User> userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsersInGroup(final String groupId) {
        return ofNullable(getValidId(groupId)).map(id -> userDao.getAll()
                .stream()
                .filter(user -> user.getGroupId().equals(id))
                .collect(Collectors.toList())).orElse(Collections.emptyList());
    }

    public User getUserById(String userId) {
        return ofNullable(getValidId(userId)).map(userDao::get).orElse(null);
    }

    public User createNewUser(String name) {
        User user = new User(name);
        System.out.println("Created user: " + user.toString());
        userDao.save(user.getId(), user);
        return user;
    }

    public User updateUserForGroup(String userId, String groupId, String groupDesc) {
        User user = ofNullable(getValidId(userId)).map(userDao::get).orElse(null);
        if (user == null) {
            return null;
        }
        UUID validIdGroupId = getValidId(groupId);
        if (validIdGroupId == null) {
            return null;
        }
        user.setGroupId(validIdGroupId);
        user.setGroupDesc(groupDesc);
        userDao.save(user.getId(), user);
        return user;
    }

    public User deleteUser(String userId) {
        UUID validUserId = getValidId(userId);
        if (validUserId == null) {
            return null;
        }

        userDao.lock(validUserId);

        User deletedUser = userDao.remove(validUserId);
        String s = deletedUser != null ? "Deleted: " + deletedUser.getName() : "No user found";
        System.out.println(s);

        userDao.unlock(validUserId);

        return deletedUser;
    }

    private UUID getValidId(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }

        try {
            return UUID.fromString(id);
        } catch (IllegalArgumentException e) {

            return null;
        }
    }
}
