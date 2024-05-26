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
import soft.uni.pathfinder.model.dto.binding.UserRegistrationBindingModel;
import soft.uni.pathfinder.model.entity.enums.LevelEnum;
import soft.uni.pathfinder.service.UserService;

@Controller
@RequestMapping("/users")
public class UserRegistrationController {

    private final UserService userService;

    @Autowired
    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView register(Model model) {

        if (!model.containsAttribute("userRegistrationBindingModel")) {
            model.addAttribute("userRegistrationBindingModel", new UserRegistrationBindingModel());
        }

        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(
            @Valid UserRegistrationBindingModel userRegistrationBindingModel,
            BindingResult bindingResult,
            RedirectAttributes rAtt) {

        ModelAndView modelAndView = new ModelAndView("register");

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("userRegistrationBindingModel", userRegistrationBindingModel);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationBindingModel", bindingResult);
            return modelAndView;
        }

        this.userService.userRegistration(userRegistrationBindingModel);
        modelAndView.setViewName("redirect:login");

        return modelAndView;
    }

    @ModelAttribute("levels")
    public LevelEnum[] levels() {
        return LevelEnum.values();
    }
}
