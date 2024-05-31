package soft.uni.pathfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soft.uni.pathfinder.model.entity.CategoryEntity;
import soft.uni.pathfinder.model.entity.enums.CategoryEnum;

import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    Set<CategoryEntity> findAllByNameIn(Set<CategoryEnum> category);
}
