package soft.uni.pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import soft.uni.pathfinder.model.dto.binding.UserLoginBindingModel;
import soft.uni.pathfinder.model.dto.binding.UserRegistrationBindingModel;
import soft.uni.pathfinder.model.dto.view.ProfileViewModel;
import soft.uni.pathfinder.model.entity.UserEntity;
import soft.uni.pathfinder.model.entity.enums.UserRoleEnum;
import soft.uni.pathfinder.repository.UserRepository;
import soft.uni.pathfinder.service.RoleService;
import soft.uni.pathfinder.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleService roleService;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;



    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService, ModelMapper mapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public void userRegistration(UserRegistrationBindingModel userRegistrationBindingModel) {
        UserEntity userEntity = mapper.map(userRegistrationBindingModel, UserEntity.class);
        userEntity.setPassword(this.passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRoleEntities(roleService.findByRoleName(UserRoleEnum.USER));
        this.userRepository.save(userEntity);
    }



//    @Override
//    public ProfileViewModel getProfile() {
//        UserEntity userEntity = this.userRepository.findUserByUsername(loggedUser.getUsername()).get();
//        return mapper.map(userEntity, ProfileViewModel.class);
//    }


    @Override
    public Optional<UserEntity> findUserByUsername(String username) {
        return this.userRepository.findUserByUsername(username);
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
