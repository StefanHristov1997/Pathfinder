package soft.uni.pathfinder.model.dto.binding;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginBindingModel {

    @NotNull
    private String username;

    @NotNull
    private String password;
}
