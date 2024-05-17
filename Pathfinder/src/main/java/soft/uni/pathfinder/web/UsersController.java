package soft.uni.pathfinder.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import soft.uni.pathfinder.model.dto.UserLoginDTO;
import soft.uni.pathfinder.model.dto.UserRegistrationDTO;
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
    public ModelAndView login(UserLoginDTO userLoginDTO) {
        boolean isUserLogged = this.userService.userLogin(userLoginDTO);

        if (isUserLogged) {
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @ModelAttribute("levels")
    public LevelEnum[] levels() {
        return LevelEnum.values();
    }

    @PostMapping("/register")
    public ModelAndView register(UserRegistrationDTO userRegistrationDTO) {
        if (this.userService.isConfirmPasswordValid(userRegistrationDTO)) {
            this.userService.userRegistration(userRegistrationDTO);
            return new ModelAndView("redirect:login");
        }
        return new ModelAndView("/register");
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        this.userService.userLogout();
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/profile")
    public ModelAndView profile() {
        return new ModelAndView("profile");
    }

    @GetMapping("/profile/back")
    public ModelAndView homeMenu() {
        return new ModelAndView("redirect:/");
    }
}



