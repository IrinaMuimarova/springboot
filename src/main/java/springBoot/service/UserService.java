package springBoot.service;

import springBoot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    void saveUser(User user);

    void deleteUser(Integer id);

    User getUserById(Integer id);

    User getUserByLogin(String login);

}
