package de.tramotech.demo.prametrizedtest;

import java.util.regex.Pattern;

import static java.util.Objects.nonNull;
import static java.util.regex.Pattern.compile;

public class UuidChecker {

    private static final Pattern PATTERN = compile("^[\\da-fA-F]{8}-[\\da-fA-F]{4}-[\\da-fA-F]{4}-[\\da-fA-F]{4}-[\\da-fA-F]{12}$");

    public static boolean isValid(String value) {
        return nonNull(value) && PATTERN.matcher(value).matches();
    }
}
