package soft.uni.pathfinder.model.validation.anotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import soft.uni.pathfinder.model.validation.validator.PasswordMathValidator;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target( { TYPE })
@Documented
@Constraint(validatedBy = PasswordMathValidator.class)
public @interface PasswordMatch {

    String message() default "Confirm Password did not match!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
