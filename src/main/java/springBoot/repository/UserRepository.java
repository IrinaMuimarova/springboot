package springBoot.repository;

import org.springframework.data.repository.CrudRepository;

import springBoot.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByLogin(String login);
}
