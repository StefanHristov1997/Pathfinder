package soft.uni.pathfinder.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import soft.uni.pathfinder.service.RouteService;

@Controller
@RequestMapping("/routes")
public class RoutesController {

//    private final RouteService routeService;
//
//    @Autowired
//    public RoutesController(RouteService routeService) {
//        this.routeService = routeService;
//    }
//
//    @GetMapping
//    public ModelAndView routes() {
//        ModelAndView modelAndView = new ModelAndView("routes");
//
//        modelAndView.addObject("routes", this.routeService.getAllRoutes());
//
//        return modelAndView;
//    }
}
