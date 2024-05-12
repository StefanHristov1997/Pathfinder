package soft.uni.pathfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soft.uni.pathfinder.model.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}
