package de.tramotech.demo.opencsv;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

import static java.util.Objects.nonNull;
import static java.util.regex.Pattern.compile;

public class UUIDValidator implements ConstraintValidator<UUID, String> {
    private static final Pattern PATTERN = compile("^[\\da-fA-F]{8}-[\\da-fA-F]{4}-[\\da-fA-F]{4}-[\\da-fA-F]{4}-[\\da-fA-F]{12}$");

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return nonNull(s) && PATTERN.matcher(s).matches();
    }
}
