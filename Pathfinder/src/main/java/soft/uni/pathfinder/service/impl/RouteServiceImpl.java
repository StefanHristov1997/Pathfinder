package soft.uni.pathfinder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft.uni.pathfinder.model.entity.Route;
import soft.uni.pathfinder.repository.RouteRepository;
import soft.uni.pathfinder.service.RouteService;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

//    @Override
//    public List<Route> getAllRoutes() {
//        return routeRepository.findAllRoutes();
//    }
}
