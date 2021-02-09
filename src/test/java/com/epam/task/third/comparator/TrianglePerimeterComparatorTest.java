package com.epam.task.third.comparator;

import com.epam.task.third.figures.entities.Point;
import com.epam.task.third.figures.entities.Triangle;
import com.epam.task.third.figures.logics.TriangleCalculator;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TrianglePerimeterComparatorTest {
    private final Point FIRST = new Point(2, 2);
    private final Point SECOND = new Point(1, 5);
    private final Point THIRD = new Point(6, 7);
    private final Point FOURTH = new Point(8, 9);
    private final Triangle FIRST_TRIANGLE = new Triangle(FIRST, SECOND, THIRD); //14.951
    private final Triangle SECOND_TRIANGLE = new Triangle(FIRST, SECOND, FOURTH); //20.444
    private final double FIRST_PERIMETER = 14.951;
    private final double SECOND_PERIMETER = 20.444;
    private final int RESULT_ACTUAL = 1;

    @Test
    public void testAreaComparison() {
        //given
        TriangleCalculator calculator = Mockito.mock(TriangleCalculator.class);
        when(calculator.getPerimeter(FIRST_TRIANGLE)).thenReturn(FIRST_PERIMETER);
        when(calculator.getPerimeter(SECOND_TRIANGLE)).thenReturn(SECOND_PERIMETER);
        TrianglePerimeterComparator trianglePerimeterComparator = new TrianglePerimeterComparator(calculator);
        //when
        int result = trianglePerimeterComparator.compare(SECOND_TRIANGLE, FIRST_TRIANGLE);
        //then
        assertEquals(result, RESULT_ACTUAL);
    }
}
