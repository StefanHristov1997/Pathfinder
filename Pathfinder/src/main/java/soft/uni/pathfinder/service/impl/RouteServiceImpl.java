package soft.uni.pathfinder.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import soft.uni.pathfinder.exseption.RouteNotFoundException;
import soft.uni.pathfinder.model.dto.binding.AddRouteBindingModel;
import soft.uni.pathfinder.model.dto.view.RouteViewModel;
import soft.uni.pathfinder.model.dto.view.RoutesViewModel;
import soft.uni.pathfinder.model.entity.RouteEntity;
import soft.uni.pathfinder.repository.RouteRepository;
import soft.uni.pathfinder.service.RouteService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;


    @Override
    public void addRoute(AddRouteBindingModel addRouteBindingModel) {
        RouteEntity routeEntity = this.modelMapper.map(addRouteBindingModel, RouteEntity.class);

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
