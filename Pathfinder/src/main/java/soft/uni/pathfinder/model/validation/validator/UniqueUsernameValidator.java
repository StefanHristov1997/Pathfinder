package soft.uni.pathfinder.model.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import soft.uni.pathfinder.model.validation.anotation.UniqueUsername;
import soft.uni.pathfinder.service.UserService;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private String message;
    private final UserService userService;

    @Autowired
    public UniqueUsernameValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        } else {
            final boolean isUnique = this.userService.isUsernameTaken(value);

            if (!isUnique) {
                replaceDefConstraintViolation(context, message);
            }
            return isUnique;
        }
    }

    public void replaceDefConstraintViolation(ConstraintValidatorContext context, String message) {
        context.
                unwrap(HibernateConstraintValidatorContext.class).
                buildConstraintViolationWithTemplate(message).
                addConstraintViolation().
                disableDefaultConstraintViolation();
    }
}
