package springBoot.repository;

import org.springframework.data.repository.CrudRepository;
import springBoot.model.Role;

public interface RoleRepository  extends CrudRepository<Role, Long> {
}
