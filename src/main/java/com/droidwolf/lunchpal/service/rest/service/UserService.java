package com.droidwolf.lunchpal.service.rest.service;

import com.droidwolf.lunchpal.service.dao.GetUpdateDeleteDao;
import com.droidwolf.lunchpal.service.domain.User;
import com.droidwolf.lunchpal.service.protocol.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final GetUpdateDeleteDao<UUID, User> userGetUpdateDeleteDao;

    public UserService(GetUpdateDeleteDao<UUID, User> userGetUpdateDeleteDao) {
        this.userGetUpdateDeleteDao = userGetUpdateDeleteDao;
    }

    public List<User> getAllUsersInGroup(final UUID groupId) {
        return userGetUpdateDeleteDao.getAll()
                .stream()
                .filter(user -> user.getGroupId().equals(groupId))
                .collect(Collectors.toList());
    }

    public User getUserById(UUID userId) {
        return userGetUpdateDeleteDao.get(userId);
    }

    public User createNewUser(UserDto userDto) {
        User user = new User(userDto.getName());
        user.setGroupDesc(userDto.getGroupDesc());
        user.setGroupId(userDto.getGroupId());
        System.out.println("Created user: " + user.toString());
        userGetUpdateDeleteDao.save(user.getId(), user);
        return user;
    }

    public User updateUser(UUID userId, UserDto userDto) {
        User user = userGetUpdateDeleteDao.get(userId);

        if (user == null) {
            return null;
        }

        user.setGroupDesc(userDto.getGroupDesc());
        user.setName(userDto.getName());

        userGetUpdateDeleteDao.save(user.getId(), user);
        return user;
    }

    public User deleteUser(final UUID userId) {

        userGetUpdateDeleteDao.lock(userId);

        User deletedUser = userGetUpdateDeleteDao.remove(userId);
        String s = deletedUser != null ? "Deleted: " + deletedUser.getName() : "No user found";
        System.out.println(s);

        userGetUpdateDeleteDao.unlock(userId);

        return deletedUser;
    }

}
