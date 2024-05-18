package soft.uni.pathfinder.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import soft.uni.pathfinder.model.entity.enums.UserRoleEnum;

@Getter
@Setter
@Component
@SessionScope
public class LoggedUser {

    private String username;
    private String password;
    private boolean isLogged;
    private UserRoleEnum role;

    public void reset() {
        setPassword(null);
        setUsername(null);
        setLogged(false);
    }

    public boolean isAdmin() {
        return role.equals(UserRoleEnum.ADMIN);
    }
}

