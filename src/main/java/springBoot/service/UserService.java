package springBoot.service;

import springBoot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    void saveUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    User getUserByLogin(String login);

    void existUser(Long id);

}
