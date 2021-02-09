package com.epam.task.third.repo;

import com.epam.task.third.figures.entities.Point;
import com.epam.task.third.observer.TriangleObservable;
import com.epam.task.third.specification.TriangleSpecification;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.*;

public class TriangleRepositoryTest {
    private final Point FIRST = new Point(2, 2);
    private final Point SECOND = new Point(1, 5);
    private final Point THIRD = new Point(6, 7);
    private final Point FOURTH = new Point(8, 9);
    private final Point FIFTH = new Point(10, 11);
    private final TriangleObservable FIRST_TRIANGLE = new TriangleObservable(FIRST, SECOND, THIRD);
    private final TriangleObservable SECOND_TRIANGLE = new TriangleObservable(FIRST, SECOND, FOURTH);
    private final TriangleObservable THIRD_TRIANGLE = new TriangleObservable(FIRST, SECOND, FIFTH);
    private final List<TriangleObservable> TRIANGLES_LIST = Arrays.asList(FIRST_TRIANGLE);

    @Test
    public void testQuery() {
        //given
        TriangleRepository repository = new TriangleRepository();
        repository.addTriangle(FIRST_TRIANGLE);
        repository.addTriangle(SECOND_TRIANGLE);
        repository.addTriangle(THIRD_TRIANGLE);
        TriangleSpecification specification = Mockito.mock(TriangleSpecification.class);
        when(specification.isSpecified(FIRST_TRIANGLE)).thenReturn(true);
        when(specification.isSpecified(SECOND_TRIANGLE)).thenReturn(false);
        when(specification.isSpecified(THIRD_TRIANGLE)).thenReturn(false);
        //when
        ArrayList<TriangleObservable> suitableTriangles = repository.query(specification);
        //then
        Object[] expected = suitableTriangles.toArray();
        Object[] actual = TRIANGLES_LIST.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAdding() {
        //given
        TriangleRepository repository = new TriangleRepository();
        //when
        repository.addTriangle(FIRST_TRIANGLE);
        //then
        Map<Integer, TriangleObservable> mapAfter = repository.getTriangleMap();
        boolean emptiness = mapAfter.isEmpty();
        assertFalse(emptiness);
    }

    @Test
    public void testRemoving() {
        //given
        TriangleRepository repository = new TriangleRepository();
        repository.addTriangle(FIRST_TRIANGLE);
        //when
        repository.removeTriangle(FIRST_TRIANGLE);
        //then
        Map<Integer, TriangleObservable> mapAfter = repository.getTriangleMap();
        boolean emptiness = mapAfter.isEmpty();
        assertTrue(emptiness);
    }

    @Test
    public void testUpdating() {
        //given
        TriangleRepository repository = new TriangleRepository();
        TriangleObservable triangle = new TriangleObservable(FIRST, SECOND, THIRD);
        int triangleId = triangle.getId();
        repository.addTriangle(triangle);
        triangle.setFirst(FOURTH);
        //when
        repository.updateTriangle(triangle);
        //then
        Map<Integer, TriangleObservable> mapAfter = repository.getTriangleMap();
        TriangleObservable triangleChanged = mapAfter.get(triangleId);
        boolean equivalent = FIRST_TRIANGLE.equals(triangleChanged);
        assertFalse(equivalent);
    }
}
