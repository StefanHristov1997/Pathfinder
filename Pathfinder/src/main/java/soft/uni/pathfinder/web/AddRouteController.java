package soft.uni.pathfinder.web;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import soft.uni.pathfinder.model.dto.binding.AddRouteBindingModel;
import soft.uni.pathfinder.model.entity.enums.CategoryEnum;
import soft.uni.pathfinder.model.entity.enums.LevelEnum;
import soft.uni.pathfinder.service.RouteService;

@Controller
@RequestMapping("/routes")
public class AddRouteController {

    private final RouteService routeService;

    @Autowired
    public AddRouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/add")
    public ModelAndView add(Model model) {
        if (!model.containsAttribute("addRouteBindingModel")) {
            model.addAttribute("addRouteBindingModel", new AddRouteBindingModel());
        }

        return new ModelAndView("add-route");
    }

    @PostMapping("/add")
    public ModelAndView add(
            @Valid AddRouteBindingModel addRouteBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        ModelAndView modelAndView = new ModelAndView("add-route");

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addRouteBindingModel", addRouteBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addRouteBindingModel", bindingResult);
            return modelAndView;
        }
        this.routeService.addRoute(addRouteBindingModel);
        modelAndView.setViewName("redirect:/routes");

        return modelAndView;
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
