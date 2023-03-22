package de.tramotech.demo.opencsv;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UUIDValidator.class)
@Documented
public @interface UUID {
    String message() default "not a valid uuid: ${validatedValue}";

    Class<?> [] groups() default {};

    Class<? extends Payload> [] payload() default {};
}
