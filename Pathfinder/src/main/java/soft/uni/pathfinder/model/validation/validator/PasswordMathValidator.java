package soft.uni.pathfinder.model.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import soft.uni.pathfinder.model.dto.binding.UserRegistrationBindingModel;
import soft.uni.pathfinder.model.validation.anotation.PasswordMatch;

public class PasswordMathValidator implements ConstraintValidator<PasswordMatch, UserRegistrationBindingModel> {

    private String message;


    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(UserRegistrationBindingModel bindingModel, ConstraintValidatorContext context) {
        String password = bindingModel.getPassword();
        String confirmPassword = bindingModel.getConfirmPassword();

        if (password == null && confirmPassword == null) {
            return true;
        } else {
            boolean isPasswordMatch = password != null && password.equals(confirmPassword);

            if (!isPasswordMatch) {
                HibernateConstraintValidatorContext hibernateContext =
                        context.unwrap(HibernateConstraintValidatorContext.class);

                hibernateContext
                        .buildConstraintViolationWithTemplate(message)
                        .addPropertyNode("confirmPassword")
                        .addConstraintViolation()
                        .disableDefaultConstraintViolation();
            }

            return isPasswordMatch;
        }
    }

}
