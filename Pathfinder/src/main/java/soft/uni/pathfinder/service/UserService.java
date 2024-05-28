package soft.uni.pathfinder.service;

import soft.uni.pathfinder.model.dto.binding.UserRegistrationBindingModel;
import soft.uni.pathfinder.model.dto.view.ProfileViewModel;
import soft.uni.pathfinder.model.entity.UserEntity;

import java.util.Optional;

public interface UserService {

    void userRegistration(UserRegistrationBindingModel userRegistrationBindingModel);

    ProfileViewModel getProfile();

    Boolean isUsernameTaken(String username);

    Boolean isEmailTaken(String email);

}


