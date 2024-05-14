package soft.uni.pathfinder.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class LoggedUser {

    private String username;
    private String password;
    private boolean isLogged;

    public void logOut() {
        setPassword(null);
        setUsername(null);
        setLogged(false);
    }
}
