package soft.uni.pathfinder.service;

import soft.uni.pathfinder.model.dto.binding.AddRouteBindingModel;
import soft.uni.pathfinder.model.dto.view.RouteViewModel;

import java.util.List;

public interface RouteService {

    void addRoute(AddRouteBindingModel routeDTO);

    List<RouteViewModel> getAllRoutes();
}
