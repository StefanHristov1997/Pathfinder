package soft.uni.pathfinder.config;

import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import soft.uni.pathfinder.model.dto.binding.AddRouteBindingModel;
import soft.uni.pathfinder.model.dto.binding.UserRegistrationBindingModel;
import soft.uni.pathfinder.model.entity.CategoryEntity;
import soft.uni.pathfinder.model.entity.RouteEntity;
import soft.uni.pathfinder.model.entity.UserEntity;
import soft.uni.pathfinder.model.entity.enums.CategoryEnum;
import soft.uni.pathfinder.service.CategoryService;
import soft.uni.pathfinder.service.RoleService;
import soft.uni.pathfinder.service.helpers.LoggedUserHelperService;

import java.util.Set;

@Configuration
public class AppConfig {

    private final RoleService roleService;
    private final CategoryService categoryService;
    private final LoggedUserHelperService loggedUserHelperService;

    @Autowired
    public AppConfig(RoleService roleService, CategoryService categoryService, LoggedUserHelperService loggedUserHelperService) {
        this.roleService = roleService;
        this.categoryService = categoryService;
        this.loggedUserHelperService = loggedUserHelperService;
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


        // AddRouteBindingModel -> RouteEntity
        Provider<UserEntity> loggedUserProvider = req -> loggedUserHelperService.get();

        Converter<Set<CategoryEnum>, Set<CategoryEntity>> toEntitySet
                = ctx -> (ctx.getSource() == null)
                ? null
                : categoryService.getAllByNameIn(ctx.getSource());

        modelMapper
                .createTypeMap(AddRouteBindingModel.class, RouteEntity.class)
                .addMappings(mapper -> mapper
                        .using(toEntitySet)
                        .map(AddRouteBindingModel::getCategories, RouteEntity::setCategories))
                .addMappings(mapper -> mapper
                        .when(Conditions.isNull())
                        .with(loggedUserProvider)
                        .map(AddRouteBindingModel::getAuthor, RouteEntity::setAuthor));

        return modelMapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
