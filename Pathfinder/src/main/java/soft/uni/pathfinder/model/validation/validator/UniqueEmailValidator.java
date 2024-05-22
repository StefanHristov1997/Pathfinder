package soft.uni.pathfinder.model.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import soft.uni.pathfinder.model.validation.anotation.UniqueEmail;
import soft.uni.pathfinder.service.UserService;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private String message;
    private final UserService userService;

    public UniqueEmailValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        } else {
            boolean isEmailUnique = this.userService.isEmailTaken(value);

            if (!isEmailUnique) {
                replaceDefaultConstraintViolation(context, message);
            }

            return isEmailUnique;
        }
    }

    public void replaceDefaultConstraintViolation(ConstraintValidatorContext context, String message) {
        context.
                unwrap(HibernateConstraintValidatorContext.class).
                buildConstraintViolationWithTemplate(message).
                addConstraintViolation().disableDefaultConstraintViolation();
    }
}
