package soft.uni.pathfinder.service;

import soft.uni.pathfinder.model.dto.AddRouteDTO;
import soft.uni.pathfinder.model.dto.RouteViewDTO;
import soft.uni.pathfinder.model.entity.Route;

import java.util.List;

public interface RouteService {

    void addRoute(AddRouteDTO routeDTO);


    List<RouteViewDTO> getAllRoutes();
}
