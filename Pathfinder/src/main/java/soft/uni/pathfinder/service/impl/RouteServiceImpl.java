package soft.uni.pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft.uni.pathfinder.model.dto.binding.AddRouteBindingModel;
import soft.uni.pathfinder.model.dto.view.RoutesViewModel;
import soft.uni.pathfinder.model.entity.Category;
import soft.uni.pathfinder.model.entity.Picture;
import soft.uni.pathfinder.model.entity.Route;
import soft.uni.pathfinder.repository.PictureRepository;
import soft.uni.pathfinder.repository.RouteRepository;
import soft.uni.pathfinder.service.CategoryService;
import soft.uni.pathfinder.service.PictureService;
import soft.uni.pathfinder.service.RouteService;
import soft.uni.pathfinder.service.UserService;
import soft.uni.pathfinder.util.LoggedUser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final PictureService pictureService;

    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, PictureService pictureService, UserService userService, CategoryService categoryService, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.routeRepository = routeRepository;
        this.pictureService = pictureService;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    //TODO: BETTER IMPLEMENTATION
    @Override
    public void addRoute(AddRouteBindingModel addRouteBindingModel) {
        Route route = this.modelMapper.map(addRouteBindingModel, Route.class);
        route.setAuthor(userService.findUserByUsername(loggedUser.getUsername()));
        Set<Category> categoriesToSet = new HashSet<>();

        addRouteBindingModel.getCategories().forEach(categoryEnum -> {
            Category category = categoryService.getCategory(categoryEnum);
            categoriesToSet.add(category);
        });

        route.setCategories(categoriesToSet);
        this.routeRepository.save(route);
    }

    @Override
    public List<RoutesViewModel> getAllRoutes() {
        List<Route> routes = this.routeRepository.findAll();
        return routes.stream().map(route -> {
            RoutesViewModel routesViewModel = modelMapper.map(route, RoutesViewModel.class);
            routesViewModel.setImageUrl(pictureService.findPictureByRouteId(route.getId()).get(0).getUrl());

            return routesViewModel;
        }).toList();
    }
}
