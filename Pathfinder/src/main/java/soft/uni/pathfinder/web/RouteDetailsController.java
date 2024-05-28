package soft.uni.pathfinder.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import soft.uni.pathfinder.service.RouteService;

@Controller
@RequestMapping("/routes")
public class RouteDetailsController {

    private final RouteService routeService;

    @Autowired
    public RouteDetailsController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("route-details");
        modelAndView.addObject("routeDetails", routeService.getDetails(id));
        return modelAndView;
    }
}
