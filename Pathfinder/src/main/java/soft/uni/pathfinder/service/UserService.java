package soft.uni.pathfinder.service;

import soft.uni.pathfinder.model.dto.binding.UserLoginBindingModel;
import soft.uni.pathfinder.model.dto.binding.UserRegistrationBindingModel;
import soft.uni.pathfinder.model.entity.User;

import java.util.Optional;

public interface UserService {

    void userRegistration(UserRegistrationBindingModel userRegistrationBindingModel);

    boolean userLogin(UserLoginBindingModel userLoginDTO);

    boolean isConfirmPasswordValid(UserRegistrationBindingModel userLoginDTO);

    void userLogout();

    Optional<User> findUserByUsername(String username);
}


