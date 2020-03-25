package springBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springBoot.model.User;
import springBoot.repository.UserRepository;
import springBoot.rest.UserNotFoundException;

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
    public void existUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User id not found - " + id);
        }
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        existUser(id);
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User id not found - " + id));
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
