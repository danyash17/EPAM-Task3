package com.epam.task.third.specification;

import com.epam.task.third.figures.entities.Point;
import com.epam.task.third.figures.logics.TriangleCalculator;
import com.epam.task.third.observer.TriangleObservable;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class TrianglePerimeterLessThanSpecificationTest {
    private final Point FIRST = new Point(2, 2);
    private final Point SECOND = new Point(1, 5);
    private final Point THIRD = new Point(6, 7);
    private final TriangleObservable triangle = new TriangleObservable(FIRST, SECOND, THIRD);
    private final double TRIANGLE_PERIMETER = 14.951;
    private final double BORDER_PERIMETER = 15;

    @Test
    public void testPerimeterSpecification() {
        //given
        TriangleCalculator calculator = Mockito.mock(TriangleCalculator.class);
        when(calculator.getPerimeter(triangle)).thenReturn(TRIANGLE_PERIMETER);
        TrianglePerimeterLessThanSpecification specification = new TrianglePerimeterLessThanSpecification(calculator, BORDER_PERIMETER);
        //when
        boolean specified = specification.isSpecified(triangle);
        //then
        assertTrue(specified);
    }
}
