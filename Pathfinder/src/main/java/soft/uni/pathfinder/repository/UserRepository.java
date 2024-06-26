package soft.uni.pathfinder.repository;

import soft.uni.pathfinder.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

   Optional<UserEntity> findUserByUsername(String username);

   Optional<UserEntity> findUserByEmail(String email);
}
