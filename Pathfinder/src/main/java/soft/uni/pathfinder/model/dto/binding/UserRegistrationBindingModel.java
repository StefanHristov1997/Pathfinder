package soft.uni.pathfinder.model.dto.binding;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import soft.uni.pathfinder.model.entity.enums.LevelEnum;

import java.io.Serializable;

@Getter
@Setter
public class UserRegistrationBindingModel implements Serializable {

    @Length(min = 3, max = 255, message = "Username length must be more than 3 characters")
    @NotEmpty
    private String username;

    @Length(min = 3, max = 255, message = "Username length must be more than 3 characters")
    @NotEmpty
    private String fullName;

    @NotEmpty
    @Email(message = "Must be valid email")
    private String email;

    @Positive(message = "Must be valid age")
    @Min(10)
    @Max(90)
    private Integer age;

    @NotEmpty
    @Length(min = 5, max = 20, message = "Password length must be between 5 and 20 characters and passwords should match.")
    private String password;

    @NotEmpty
    @Length(min = 5, max = 20, message = "Password length must be between 5 and 20 characters and passwords should match.")
    private String confirmPassword;

    @NotNull(message = "The field is required.")
    private LevelEnum level;
}
