package soft.uni.pathfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import soft.uni.pathfinder.service.RouteService;

@Controller
public class RouteController {

    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public ModelAndView route() {
       return new ModelAndView("/routes");
//        view.addObject("routes", routeService.getAllRoutes());
//        return view;
    }
}
