package soft.uni.pathfinder.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import soft.uni.pathfinder.service.UserService;

@Controller
@RequestMapping("/users")
public class UserLogoutController {

    private final UserService userService;

    @Autowired
    public UserLogoutController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        this.userService.userLogout();
        return new ModelAndView("redirect:/");
    }
}
