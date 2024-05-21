package soft.uni.pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import soft.uni.pathfinder.model.dto.binding.UserLoginBindingModel;
import soft.uni.pathfinder.model.dto.binding.UserRegistrationBindingModel;
import soft.uni.pathfinder.model.dto.view.ProfileViewModel;
import soft.uni.pathfinder.model.entity.User;
import soft.uni.pathfinder.model.entity.enums.UserRoleEnum;
import soft.uni.pathfinder.repository.UserRepository;
import soft.uni.pathfinder.service.RoleService;
import soft.uni.pathfinder.service.UserService;
import soft.uni.pathfinder.util.LoggedUser;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleService roleService;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService, ModelMapper mapper, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    @Override
    public void userRegistration(UserRegistrationBindingModel userRegistrationBindingModel) {
        User user = mapper.map(userRegistrationBindingModel, User.class);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user.setRoles(roleService.findByRoleName(UserRoleEnum.USER));
        this.userRepository.save(user);
    }


    @Override
    public boolean userLogin(UserLoginBindingModel userLoginBindingModel) {
        User currentUser = this.userRepository.findUserByUsername(userLoginBindingModel.getUsername());
        boolean isUserLogged = false;

        if (currentUser != null) {
            if (passwordEncoder.matches(userLoginBindingModel.getPassword(), currentUser.getPassword())) {
                loggedUser.setUsername(currentUser.getUsername());
                loggedUser.setPassword(currentUser.getPassword());
                loggedUser.setRole(UserRoleEnum.USER);
                loggedUser.setLogged(true);

                isUserLogged = true;
            }
        }

        return isUserLogged;
    }

    @Override
    public void userLogout() {
        this.loggedUser.reset();
    }

    @Override
    public ProfileViewModel getProfile() {
        User user = this.userRepository.findUserByUsername(loggedUser.getUsername());
        return mapper.map(user, ProfileViewModel.class);
    }

    @Override
    public boolean isConfirmPasswordValid(UserRegistrationBindingModel userRegistrationBindingModel) {
        return userRegistrationBindingModel.getPassword().equals(userRegistrationBindingModel.getConfirmPassword());
    }

    @Override
    public User findUserByUsername(String username) {
        return this.userRepository.findUserByUsername(username);
    }


}
