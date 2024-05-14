package soft.uni.pathfinder.service;

import soft.uni.pathfinder.model.dto.UserLoginDTO;
import soft.uni.pathfinder.model.dto.UserRegistrationDTO;

public interface UserService {
    void userRegistration(UserRegistrationDTO userRegistrationDTO);
    void userLogin(UserLoginDTO userLoginDTO);
}


