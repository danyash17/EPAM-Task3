package com.epam.task.third.validator;

import static org.junit.Assert.*;

import com.epam.task.third.figures.entities.Point;
import com.epam.task.third.figures.entities.Triangle;
import org.junit.Test;

public class TriangleValidatorTest {
    //точки расположены на одной прямой,такого треугольника не существует
    private final Point FIRST = new Point(0, 0);
    private final Point SECOND = new Point(1, 0);
    private final Point THIRD = new Point(2, 0);

    @Test
    public void testValidationOfThreePoints() {
        //given
        TriangleValidator triangleValidator = new TriangleValidator();
        Triangle triangle = new Triangle(FIRST, SECOND, THIRD);
        //when
        boolean result=triangleValidator.isExistingTriangle(triangle);
        //then
        assertFalse(result);
    }

}
