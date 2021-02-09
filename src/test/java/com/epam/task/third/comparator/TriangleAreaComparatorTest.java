package com.epam.task.third.comparator;

import com.epam.task.third.figures.entities.Point;
import com.epam.task.third.figures.entities.Triangle;
import com.epam.task.third.figures.logics.TriangleCalculator;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class TriangleAreaComparatorTest {
    private final Point FIRST = new Point(2, 2);
    private final Point SECOND = new Point(1, 5);
    private final Point THIRD = new Point(6, 7);
    private final Point FOURTH = new Point(8, 9);
    private final Triangle FIRST_TRIANGLE = new Triangle(FIRST, SECOND, THIRD); //8.5
    private final Triangle SECOND_TRIANGLE = new Triangle(FIRST, SECOND, FOURTH); //12.5
    private final double FIRST_AREA = 8.5;
    private final double SECOND_AREA = 12.5;
    private final int RESULT_ACTUAL = 1;

    @Test
    public void testAreaComparison() {
        //given
        TriangleCalculator calculator = Mockito.mock(TriangleCalculator.class);
        when(calculator.getArea(FIRST_TRIANGLE)).thenReturn(FIRST_AREA);
        when(calculator.getArea(SECOND_TRIANGLE)).thenReturn(SECOND_AREA);
        TriangleAreaComparator triangleAreaComparator = new TriangleAreaComparator(calculator);
        //when
        int result = triangleAreaComparator.compare(SECOND_TRIANGLE, FIRST_TRIANGLE);
        //then
        assertEquals(result, RESULT_ACTUAL);
    }
}
