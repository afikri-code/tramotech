package de.tramotech.demo.opencsv;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class DtoValidator {
    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static Validator validator = factory.getValidator();

    public static <T> Set<ConstraintViolation<T>> validate(T entity) {
        return validator.validate(entity);
    }


}
