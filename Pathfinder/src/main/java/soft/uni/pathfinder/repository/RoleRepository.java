package soft.uni.pathfinder.repository;

import soft.uni.pathfinder.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soft.uni.pathfinder.model.entity.enums.UserRoleEnum;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Set<Role> findByName(UserRoleEnum name);
}
