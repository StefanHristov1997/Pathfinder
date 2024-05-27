package soft.uni.pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft.uni.pathfinder.model.dto.view.RouteViewModel;
import soft.uni.pathfinder.model.dto.view.RoutesViewModel;
import soft.uni.pathfinder.model.entity.RouteEntity;
import soft.uni.pathfinder.repository.RouteRepository;
import soft.uni.pathfinder.service.CategoryService;
import soft.uni.pathfinder.service.PictureService;
import soft.uni.pathfinder.service.RouteService;
import soft.uni.pathfinder.service.UserService;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

//    private final RouteRepository routeRepository;
//    private final PictureService pictureService;
//
//    private final UserService userService;
//    private final CategoryService categoryService;
//    private final ModelMapper modelMapper;
//
//    @Autowired
//    public RouteServiceImpl(RouteRepository routeRepository, PictureService pictureService, UserService userService, CategoryService categoryService, ModelMapper modelMapper) {
//        this.routeRepository = routeRepository;
//        this.pictureService = pictureService;
//        this.userService = userService;
//        this.categoryService = categoryService;
//        this.modelMapper = modelMapper;
//
//    }
//
//    //TODO: BETTER IMPLEMENTATION
////    @Override
////    public void addRoute(AddRouteBindingModel addRouteBindingModel) {
////        RouteEntity routeEntity = this.modelMapper.map(addRouteBindingModel, RouteEntity.class);
////        routeEntity.setAuthor(userService.findUserByUsername(loggedUser.getUsername()).get());
////        Set<CategoryEntity> categoriesToSet = new HashSet<>();
////
////        addRouteBindingModel.getCategories().forEach(categoryEnum -> {
////            CategoryEntity categoryEntity = categoryService.getCategory(categoryEnum);
////            categoriesToSet.add(categoryEntity);
////        });
////
////        routeEntity.setCategories(categoriesToSet);
////        this.routeRepository.save(routeEntity);
////    }
//
//    @Override
//    public List<RoutesViewModel> getAllRoutes() {
//        List<RouteEntity> routeEntities = this.routeRepository.findAll();
//        return routeEntities.stream().map(routeEntity -> {
//            RoutesViewModel routesViewModel = modelMapper.map(routeEntity, RoutesViewModel.class);
////            Optional<List<Picture>> pictureByRouteId = pictureService.findPictureByRouteId(route.getId());
////
////            if (pictureByRouteId.isPresent()) {
////                routesViewModel.setImageUrl(pictureService.findPictureByRouteId(route.getId()).get().get(0).getUrl());
////            }
//
//            return routesViewModel;
//        }).toList();
//    }
//
//    @Override
//    public RouteViewModel getDetails(Long id) {
//        RouteEntity routeEntity = this.routeRepository.findRouteById(id);
//
//        RouteViewModel routeViewModel =  modelMapper.map(routeEntity, RouteViewModel.class);
//        routeViewModel.setAuthorName(routeEntity.getAuthor().getUsername());
//
//        return routeViewModel;
//    }
}
