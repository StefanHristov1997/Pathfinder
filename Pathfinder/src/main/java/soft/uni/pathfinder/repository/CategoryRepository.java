package soft.uni.pathfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soft.uni.pathfinder.model.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
