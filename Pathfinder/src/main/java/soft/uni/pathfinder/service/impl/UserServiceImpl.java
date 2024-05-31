package soft.uni.pathfinder.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import soft.uni.pathfinder.model.dto.binding.UserRegistrationBindingModel;
import soft.uni.pathfinder.model.dto.view.ProfileViewModel;
import soft.uni.pathfinder.model.entity.UserEntity;
import soft.uni.pathfinder.model.entity.enums.UserRoleEnum;
import soft.uni.pathfinder.repository.UserRepository;
import soft.uni.pathfinder.service.RoleService;
import soft.uni.pathfinder.service.UserService;
import soft.uni.pathfinder.service.helpers.LoggedUserHelperService;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final LoggedUserHelperService loggedUserHelperService;
    private final RoleService roleService;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void userRegistration(UserRegistrationBindingModel userRegistrationBindingModel) {
        UserEntity userEntity = mapper.map(userRegistrationBindingModel, UserEntity.class);

        this.userRepository.save(userEntity);
    }


    @Override
    public ProfileViewModel getProfile() {
        UserEntity userEntity = this.userRepository.findUserByUsername(loggedUserHelperService.getUsername()).get();
        return mapper.map(userEntity, ProfileViewModel.class);
    }


    @Override
    public Boolean isUsernameTaken(String username) {
        return this.userRepository.findUserByUsername(username).isEmpty();
    }

    @Override
    public Boolean isEmailTaken(String email) {
        return this.userRepository.findUserByEmail(email).isEmpty();
    }


}
