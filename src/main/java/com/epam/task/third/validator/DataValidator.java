package com.epam.task.third.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {
    private final String regEx = ",";

    public boolean validate(String line) {
        Pattern stencil = Pattern.compile(regEx);
        Matcher matcher = stencil.matcher(line);
        return matcher.matches();
    }
}
