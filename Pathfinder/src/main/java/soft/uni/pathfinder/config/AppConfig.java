package soft.uni.pathfinder.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import soft.uni.pathfinder.model.dto.binding.UserRegistrationBindingModel;
import soft.uni.pathfinder.model.entity.UserEntity;
import soft.uni.pathfinder.service.RoleService;

import java.util.Set;

@Configuration
public class AppConfig {

    private final RoleService roleService;

    @Autowired
    public AppConfig(RoleService roleService) {
        this.roleService = roleService;
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        //UserRegisterBindingModel -> UserEntity
        Provider<UserEntity> newUserProvider = req -> {
            UserEntity userEntity = new UserEntity();

            userEntity.setRoleEntities(Set.of(roleService.findRoleNyName("USER")));

            return userEntity;
        };


        Converter<String, String> passwordConverter
                = ctx -> (ctx.getSource() == null)
                ? null
                : passwordEncoder().encode(ctx.getSource());

        modelMapper
                .createTypeMap(UserRegistrationBindingModel.class, UserEntity.class)
                .setProvider(newUserProvider)
                .addMappings(mapper -> mapper
                        .using(passwordConverter)
                        .map(UserRegistrationBindingModel::getPassword, UserEntity::setPassword));
        return modelMapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
