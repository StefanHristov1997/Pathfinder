package soft.uni.pathfinder.model.validation.anotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import soft.uni.pathfinder.model.validation.validator.UniqueUsernameValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueUsernameValidator.class)
public @interface UniqueUsername {

    String message() default "Username is taken";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
