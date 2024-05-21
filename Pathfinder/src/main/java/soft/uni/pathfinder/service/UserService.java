package soft.uni.pathfinder.service;

import soft.uni.pathfinder.model.dto.binding.UserLoginBindingModel;
import soft.uni.pathfinder.model.dto.binding.UserRegistrationBindingModel;
import soft.uni.pathfinder.model.dto.view.ProfileViewModel;
import soft.uni.pathfinder.model.entity.User;

public interface UserService {

    void userRegistration(UserRegistrationBindingModel userRegistrationBindingModel);

    boolean userLogin(UserLoginBindingModel userLoginDTO);

    boolean isConfirmPasswordValid(UserRegistrationBindingModel userLoginDTO);

    void userLogout();

    User findUserByUsername(String username);

    ProfileViewModel getProfile();
}


