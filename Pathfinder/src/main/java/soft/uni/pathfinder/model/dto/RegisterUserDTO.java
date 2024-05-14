package soft.uni.pathfinder.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Getter
@Setter
public class RegisterUserDTO implements Serializable {

    @Length(min = 3, max = 255)
    @NonNull
    private String username;

    @Length(min = 3, max = 255)
    private String fullName;


    @NonNull
    private String email;

    @Positive
    @Max(100)
    private int age;

    @NonNull
    private String password;

    @NonNull
    private String confirmPassword;
}
