package com.epam.task.third.specification;

import com.epam.task.third.figures.entities.Point;
import com.epam.task.third.figures.logics.TriangleCalculator;
import com.epam.task.third.observer.TriangleObservable;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class TriangleIdLessThanSpecificationTest {
    private final Point FIRST = new Point(2, 2);
    private final Point SECOND = new Point(1, 5);
    private final Point THIRD = new Point(6, 7);
    private final TriangleObservable triangle = new TriangleObservable(FIRST, SECOND, THIRD);
    private final int TRIANGLE_ID = 0;
    private final int BORDER_ID = 1;

    @Test
    public void testAreaSpecification() {
        //given
        TriangleIdLessThanSpecification specification = new TriangleIdLessThanSpecification(BORDER_ID);
        //when
        boolean specified = specification.isSpecified(triangle);
        //then
        assertTrue(specified);
    }

}
