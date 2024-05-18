package soft.uni.pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft.uni.pathfinder.model.dto.AddRouteDTO;
import soft.uni.pathfinder.model.dto.RouteViewDTO;
import soft.uni.pathfinder.model.entity.Category;
import soft.uni.pathfinder.model.entity.Route;
import soft.uni.pathfinder.repository.RouteRepository;
import soft.uni.pathfinder.service.CategoryService;
import soft.uni.pathfinder.service.RouteService;
import soft.uni.pathfinder.service.UserService;
import soft.uni.pathfinder.util.LoggedUser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, UserService userService, CategoryService categoryService, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.routeRepository = routeRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    //TODO: BETTER IMPLEMENTATION
    @Override
    public void addRoute(AddRouteDTO routeDTO) {
        Route route = this.modelMapper.map(routeDTO, Route.class);
        route.setAuthor(userService.findUserByUsername(loggedUser.getUsername()).get());
        Set<Category> categoriesToSet = new HashSet<>();

        routeDTO.getCategories().forEach(categoryEnum -> {
            Category category = categoryService.getCategory(categoryEnum);
            categoriesToSet.add(category);
        });

        route.setCategories(categoriesToSet);
        this.routeRepository.save(route);
    }

    @Override
    public List<RouteViewDTO> getAllRoutes() {
        List<Route> routes = this.routeRepository.findAll();
        return routes.stream().map(route -> modelMapper.map(route, RouteViewDTO.class)).toList();
    }

}
