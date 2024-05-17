package soft.uni.pathfinder.service;

import soft.uni.pathfinder.model.dto.UserLoginDTO;
import soft.uni.pathfinder.model.dto.UserRegistrationDTO;
import soft.uni.pathfinder.model.entity.User;

import java.util.Optional;

public interface UserService {
    void userRegistration(UserRegistrationDTO userRegistrationDTO);
    boolean userLogin(UserLoginDTO userLoginDTO);
    boolean isConfirmPasswordValid(UserRegistrationDTO userLoginDTO);
    void userLogout();
    Optional<User> findUserByUsername(String username);
}


