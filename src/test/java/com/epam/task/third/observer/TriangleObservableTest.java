package com.epam.task.third.observer;

import org.junit.Test;
import com.epam.task.third.figures.entities.Point;

public class TriangleObservableTest {
    private final TriangleObserver EXAMPLE_OBSERVER = TriangleObserver.getInstance();
    private final Point FIRST = new Point(0, 0);
    private final Point SECOND = new Point(1, 1);
    private final Point THIRD = new Point(2, 2);

    @Test
    public void testObserverAttaching() {
        //given
        TriangleObservable triangleObservable = new TriangleObservable(FIRST, SECOND, THIRD);
        //when
        triangleObservable.addObserver(EXAMPLE_OBSERVER);
    }

    @Test
    public void testObserverDetaching() {
        //given
        TriangleObservable triangleObservable = new TriangleObservable(FIRST, SECOND, THIRD);
        //when
        triangleObservable.addObserver(EXAMPLE_OBSERVER);
        triangleObservable.removeObserver(EXAMPLE_OBSERVER);
    }

}
