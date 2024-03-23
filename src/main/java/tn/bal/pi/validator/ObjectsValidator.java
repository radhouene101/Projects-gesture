package tn.bal.pi.validator;

import jakarta.validation.*;
import org.springframework.stereotype.Component;
import tn.bal.pi.exceptions.ObjectValidationException;

import java.util.Set;
import java.util.stream.Collectors;
@Component
public class ObjectsValidator<T> {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();
    public void validate(T objectToValidate){
        Set<ConstraintViolation<T>> violations = validator.validate(objectToValidate);
        if (!violations.isEmpty()){
            Set<String> violationMessages =violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());
        throw new ObjectValidationException(violationMessages,objectToValidate.getClass().getName());
        }
    }
}
