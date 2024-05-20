package soft.uni.pathfinder.web;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import soft.uni.pathfinder.model.dto.binding.AddRouteBindingModel;
import soft.uni.pathfinder.model.entity.enums.CategoryEnum;
import soft.uni.pathfinder.model.entity.enums.LevelEnum;
import soft.uni.pathfinder.service.RouteService;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public ModelAndView routes() {
        ModelAndView modelAndView = new ModelAndView("routes");
        modelAndView.addObject("routes", this.routeService.getAllRoutes());

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        return new ModelAndView("add-route");
    }

    @PostMapping("/add")
    public ModelAndView add(@Valid AddRouteBindingModel addRouteBindingModel) {
        this.routeService.addRoute(addRouteBindingModel);
        return new ModelAndView("redirect:index");
    }

    @ModelAttribute("categories")
    public CategoryEnum[] categoryEnums() {
        return CategoryEnum.values();
    }

    @ModelAttribute("levels")
    public LevelEnum[] levelEnums() {
        return LevelEnum.values();
    }
}