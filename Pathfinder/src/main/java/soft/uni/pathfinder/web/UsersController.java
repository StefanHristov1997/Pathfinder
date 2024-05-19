package soft.uni.pathfinder.web;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import soft.uni.pathfinder.model.dto.view.ProfileViewModel;
import soft.uni.pathfinder.model.dto.binding.UserLoginBindingModel;
import soft.uni.pathfinder.model.dto.binding.UserRegistrationBindingModel;
import soft.uni.pathfinder.model.entity.enums.LevelEnum;
import soft.uni.pathfinder.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid UserLoginBindingModel userLoginDTO) {
        ModelAndView modelAndView = new ModelAndView("login");
        boolean isUserLogged = this.userService.userLogin(userLoginDTO);

        if (isUserLogged) {
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid UserRegistrationBindingModel userRegistrationBindingModel) {
        ModelAndView modelAndView = new ModelAndView("register");

        if (this.userService.isConfirmPasswordValid(userRegistrationBindingModel)) {
            this.userService.userRegistration(userRegistrationBindingModel);
            modelAndView.setViewName("redirect:login");
        }

        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        this.userService.userLogout();
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/profile")
    public ModelAndView profile() {
        ModelAndView modelAndView = new ModelAndView("profile");

        ProfileViewModel profileViewModel = userService.getProfile();
        modelAndView.addObject("profile", profileViewModel);

        return modelAndView;
    }

    @GetMapping("/profile/back")
    public ModelAndView homeMenu() {
        return new ModelAndView("redirect:/");
    }

    @ModelAttribute("levels")
    public LevelEnum[] levels() {
        return LevelEnum.values();
    }
}



