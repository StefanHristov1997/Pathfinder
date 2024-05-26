package soft.uni.pathfinder.web;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import soft.uni.pathfinder.model.dto.binding.UserLoginBindingModel;
import soft.uni.pathfinder.service.UserService;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private final UserService userService;

    @Autowired
    public UserLoginController(UserService userService) {
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
}
