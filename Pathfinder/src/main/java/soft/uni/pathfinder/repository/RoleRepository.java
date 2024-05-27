package soft.uni.pathfinder.repository;

import soft.uni.pathfinder.model.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soft.uni.pathfinder.model.entity.enums.UserRoleEnum;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Set<RoleEntity> findByName(UserRoleEnum name);
}
