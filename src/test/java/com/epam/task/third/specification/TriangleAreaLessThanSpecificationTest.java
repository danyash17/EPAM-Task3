package com.epam.task.third.specification;

import com.epam.task.third.figures.entities.Point;
import com.epam.task.third.figures.logics.TriangleCalculator;
import com.epam.task.third.observer.TriangleObservable;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class TriangleAreaLessThanSpecificationTest {
    private final Point FIRST = new Point(2, 2);
    private final Point SECOND = new Point(1, 5);
    private final Point THIRD = new Point(6, 7);
    private final TriangleObservable triangle = new TriangleObservable(FIRST, SECOND, THIRD);
    private final double TRIANGLE_AREA = 8.5;
    private final double BORDER_AREA = 9;

    @Test
    public void testAreaSpecification() {
        //given
        TriangleCalculator calculator = Mockito.mock(TriangleCalculator.class);
        when(calculator.getArea(triangle)).thenReturn(TRIANGLE_AREA);
        TriangleAreaLessThanSpecification specification = new TriangleAreaLessThanSpecification(calculator, BORDER_AREA);
        //when
        boolean specified = specification.isSpecified(triangle);
        //then
        assertTrue(specified);
    }
}
