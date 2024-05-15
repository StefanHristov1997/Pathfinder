package soft.uni.pathfinder.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDTO {

    @NotNull
    private String username;
    @NotNull
    private String password;
}
