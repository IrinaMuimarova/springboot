package springBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springBoot.repository.UserRepository;
import springBoot.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
