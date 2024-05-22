package soft.uni.pathfinder.model.validation.anotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import soft.uni.pathfinder.model.validation.validator.UniqueEmailValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {

    String message() default "Email already exists!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
