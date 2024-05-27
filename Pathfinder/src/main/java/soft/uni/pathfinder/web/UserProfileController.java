package soft.uni.pathfinder.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import soft.uni.pathfinder.model.dto.view.ProfileViewModel;
import soft.uni.pathfinder.service.UserService;

@Controller
@RequestMapping("/users")
public class UserProfileController {

    private final UserService userService;

    @Autowired
    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/profile")
//    public ModelAndView profile() {
//        ModelAndView modelAndView = new ModelAndView("profile");
//        ProfileViewModel profileViewModel = userService.getProfile();
//
//        modelAndView.addObject("profile", profileViewModel);
//
//        return modelAndView;
//    }

    @GetMapping("/profile/back")
    public ModelAndView homeMenu() {
        return new ModelAndView("redirect:/");
    }
}
