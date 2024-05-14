package soft.uni.pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import soft.uni.pathfinder.model.dto.UserLoginDTO;
import soft.uni.pathfinder.model.dto.UserRegistrationDTO;
import soft.uni.pathfinder.model.entity.User;
import soft.uni.pathfinder.repository.UserRepository;
import soft.uni.pathfinder.service.UserService;
import soft.uni.pathfinder.util.LoggedUser;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    @Override
    public void userRegistration(UserRegistrationDTO userRegistrationDTO) {
        User user = mapper.map(userRegistrationDTO, User.class);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
    }

    @Override
    public void userLogin(UserLoginDTO userLoginDTO) {
        boolean userIsPresent = this.userRepository.findByUsername(userLoginDTO.getUsername()).isPresent();

        if (userIsPresent) {
            User currentUser = this.userRepository.findByUsername(userLoginDTO.getUsername()).get();
            if (passwordEncoder.matches(userLoginDTO.getPassword(), currentUser.getPassword())) {
                loggedUser.setUsername(currentUser.getUsername());
                loggedUser.setPassword(currentUser.getPassword());
                loggedUser.setLogged(true);
            }else {
                throw new IllegalArgumentException("Invalid password!");
            }
        } else {
            throw new IllegalArgumentException("Invalid username!");
        }

    }
}
