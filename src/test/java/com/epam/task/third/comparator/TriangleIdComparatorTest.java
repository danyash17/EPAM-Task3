package com.epam.task.third.comparator;

import com.epam.task.third.figures.entities.Point;
import com.epam.task.third.observer.TriangleObservable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriangleIdComparatorTest {
    private final Point FIRST = new Point(2, 2);
    private final Point SECOND = new Point(1, 5);
    private final Point THIRD = new Point(6, 7);
    private final Point FOURTH = new Point(8, 9);
    private final TriangleObservable FIRST_TRIANGLE = new TriangleObservable(FIRST, SECOND, THIRD);
    private final TriangleObservable SECOND_TRIANGLE = new TriangleObservable(FIRST, SECOND, FOURTH);
    private final int RESULT_ACTUAL = 1;

    @Test
    public void testAreaComparison() {
        //given
        TriangleIdComparator triangleIdComparator = new TriangleIdComparator();
        //when
        int result = triangleIdComparator.compare(SECOND_TRIANGLE, FIRST_TRIANGLE);
        //then
        assertEquals(result, RESULT_ACTUAL);
    }
}
