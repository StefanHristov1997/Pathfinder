package soft.uni.pathfinder.service.impl;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft.uni.pathfinder.model.dto.RegisterUserDTO;
import soft.uni.pathfinder.model.entity.User;
import soft.uni.pathfinder.repository.UserRepository;
import soft.uni.pathfinder.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public void registerUser(@Valid RegisterUserDTO registerUserDTO) {
        User user = mapper.map(registerUserDTO, User.class);
        this.userRepository.save(user);
    }
}
