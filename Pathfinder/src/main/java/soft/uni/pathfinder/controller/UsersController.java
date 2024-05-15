package soft.uni.pathfinder.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import soft.uni.pathfinder.model.dto.UserLoginDTO;
import soft.uni.pathfinder.model.dto.UserRegistrationDTO;
import soft.uni.pathfinder.service.UserService;
import soft.uni.pathfinder.util.LoggedUser;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;
    private final LoggedUser loggedUser;

    @Autowired
    public UsersController(UserService userService, LoggedUser loggedUser) {
        this.userService = userService;
        this.loggedUser = loggedUser;
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

    @PostMapping("/register")
    public ModelAndView register(@Valid UserRegistrationDTO userRegistrationDTO) {
        this.userService.userRegistration(userRegistrationDTO);
        return new ModelAndView("redirect:login");
    }

    @GetMapping("/logout")
    public String logout() {
        loggedUser.logOut();
        return "redirect:/";
    }
}



