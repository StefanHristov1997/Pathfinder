package soft.uni.pathfinder.model.dto.binding;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import soft.uni.pathfinder.model.entity.enums.LevelEnum;

import java.io.Serializable;

@Getter
@Setter
public class UserRegistrationBindingModel implements Serializable {

    @Length(min = 3, max = 255)
    @NotNull
    private String username;

    @Length(min = 3, max = 255)
    private String fullName;

    @NotNull
    private String email;

    @Positive
    @Min(6)
    @Max(100)
    private int age;

    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;

    @NotNull
    private LevelEnum level;
}
