package com.epam.task.third.observer;

import com.epam.task.third.figures.entities.Point;
import com.epam.task.third.parameters.Parameters;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TriangleObserverTest {
    private final TriangleObserver EXAMPLE_OBSERVER = TriangleObserver.getInstance();
    private final Point FIRST = new Point(0, 0);
    private final Point SECOND = new Point(1, 1);
    private final Point THIRD = new Point(2, 2);
    private final Point FOURTH = new Point(6, 3);

    @Test
    public void testUpdating() {
        //given
        TriangleObservable triangleObservable = new TriangleObservable(FIRST, SECOND, THIRD);
        triangleObservable.addObserver(EXAMPLE_OBSERVER);
        Map<Integer, Parameters> parametersMapBefore = new HashMap<Integer, Parameters>(EXAMPLE_OBSERVER.getParametersMap());
        //when
        triangleObservable.setFirst(FOURTH);
        //then
        Map<Integer, Parameters> parametersMapAfter = EXAMPLE_OBSERVER.getParametersMap();
        assertFalse(parametersMapBefore.equals(parametersMapAfter));
    }
}
