package com.epam.task.third.validaror;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {
    public boolean validate(String line) {
        //пример валидного ввода точек "(2,3) (4,5) (1,0)"
        Pattern stencil = Pattern.compile("^\\(\\d,\\d\\)\\s\\(\\d,\\d\\)\\s\\(\\d,\\d\\)");
        Matcher matcher = stencil.matcher(line);
        if(matcher.matches()) return true;
        else return false;
    }
}
