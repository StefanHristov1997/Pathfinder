package soft.uni.pathfinder.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import soft.uni.pathfinder.exseption.RouteNotFoundException;
import soft.uni.pathfinder.model.dto.binding.AddRouteBindingModel;
import soft.uni.pathfinder.model.dto.view.RouteViewModel;
import soft.uni.pathfinder.model.dto.view.RoutesViewModel;
import soft.uni.pathfinder.model.entity.CategoryEntity;
import soft.uni.pathfinder.model.entity.RouteEntity;
import soft.uni.pathfinder.repository.RouteRepository;
import soft.uni.pathfinder.service.CategoryService;
import soft.uni.pathfinder.service.RouteService;
import soft.uni.pathfinder.service.UserService;
import soft.uni.pathfinder.service.helpers.LoggedUserHelperService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final LoggedUserHelperService loggedUserHelperService;


    //    TODO: BETTER IMPLEMENTATION
    @Override
    public void addRoute(AddRouteBindingModel addRouteBindingModel) {
        RouteEntity routeEntity = this.modelMapper.map(addRouteBindingModel, RouteEntity.class);
        routeEntity.setAuthor(loggedUserHelperService.get());

        Set<CategoryEntity> categoriesToSet = new HashSet<>();

        addRouteBindingModel.getCategories().forEach(categoryEnum -> {
            CategoryEntity categoryEntity = categoryService.getCategory(categoryEnum);
            categoriesToSet.add(categoryEntity);
        });

        routeEntity.setCategories(categoriesToSet);
        this.routeRepository.save(routeEntity);
    }

    @Override
    public List<RoutesViewModel> getAllRoutes() {
        List<RouteEntity> routeEntities = this.routeRepository.findAll();

        return routeEntities
                .stream()
                .map(routeEntity ->
                        modelMapper.map(routeEntity, RoutesViewModel.class)).toList();
    }

    @Override
    public RouteViewModel getDetails(Long id) {
        RouteEntity routeEntity = this.routeRepository
                .findById(id)
                .orElseThrow(() -> new RouteNotFoundException("Route with: " + id + " was not found!"));

        RouteViewModel routeViewModel = modelMapper.map(routeEntity, RouteViewModel.class);
        routeViewModel.setAuthorName(routeEntity.getAuthor().getUsername());

        return routeViewModel;
    }
}
