package com.epam.task.third.sorter;

import com.epam.task.third.comparator.TriangleAreaComparator;
import com.epam.task.third.comparator.TriangleIdComparator;
import com.epam.task.third.comparator.TrianglePerimeterComparator;
import com.epam.task.third.figures.entities.Point;
import com.epam.task.third.figures.entities.Triangle;
import com.epam.task.third.figures.logics.TriangleCalculator;
import com.epam.task.third.observer.TriangleObservable;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

public class TriangleSorterTest {
    private final Point FIRST = new Point(2, 2);
    private final Point SECOND = new Point(1, 5);
    private final Point THIRD = new Point(6, 7);
    private final Point FOURTH = new Point(8, 9);
    private final Point FIFTH = new Point(10, 11);
    private final TriangleObservable FIRST_OBS_TRIANGLE = new TriangleObservable(FIRST, SECOND, THIRD);
    private final TriangleObservable SECOND_OBS_TRIANGLE = new TriangleObservable(FIRST, SECOND, FOURTH);
    private final TriangleObservable THIRD_OBS_TRIANGLE = new TriangleObservable(FIRST, SECOND, FIFTH);
    private final Triangle FIRST_TRIANGLE = new Triangle(FIRST, SECOND, THIRD);
    private final Triangle SECOND_TRIANGLE = new Triangle(FIRST, SECOND, FOURTH);
    private final Triangle THIRD_TRIANGLE = new Triangle(FIRST, SECOND, FIFTH);
    private final double FIRST_AREA = 8.5;
    private final double SECOND_AREA = 12.5;
    private final double THIRD_AREA = 16.5;
    private final double FIRST_PERIMETER = 14.951;
    private final double SECOND_PERIMETER = 20.444;
    private final double THIRD_PERIMETER = 26.021;
    private final List<TriangleObservable> TRIANGLES_OBS_LIST = Arrays.asList(SECOND_OBS_TRIANGLE, FIRST_OBS_TRIANGLE, THIRD_OBS_TRIANGLE);
    private final List<TriangleObservable> TRIANGLES_OBS_SORTED_LIST = Arrays.asList(FIRST_OBS_TRIANGLE, SECOND_OBS_TRIANGLE, THIRD_OBS_TRIANGLE);
    private final List<Triangle> TRIANGLES_LIST = Arrays.asList(SECOND_OBS_TRIANGLE, FIRST_OBS_TRIANGLE, THIRD_OBS_TRIANGLE);
    private final List<Triangle> TRIANGLES_SORTED_LIST = Arrays.asList(FIRST_OBS_TRIANGLE, SECOND_OBS_TRIANGLE, THIRD_OBS_TRIANGLE);

    @Test
    public void testAreaSort() {
        //given
        TriangleCalculator calculator = Mockito.mock(TriangleCalculator.class);
        when(calculator.getArea(FIRST_TRIANGLE)).thenReturn(FIRST_AREA);
        when(calculator.getArea(SECOND_TRIANGLE)).thenReturn(SECOND_AREA);
        when(calculator.getArea(THIRD_TRIANGLE)).thenReturn(THIRD_AREA);
        TriangleAreaComparator areaComparator = new TriangleAreaComparator(calculator);
        TriangleSorter sorter = new TriangleSorter();
        //when
        List<Triangle> trianglesList = sorter.sortByArea(TRIANGLES_LIST, areaComparator);
        //then
        Object[] expectedArray = trianglesList.toArray();
        Object[] actualArray = TRIANGLES_SORTED_LIST.toArray();
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testPerimeterSort() {
        //given
        TriangleCalculator calculator = Mockito.mock(TriangleCalculator.class);
        when(calculator.getPerimeter(FIRST_TRIANGLE)).thenReturn(FIRST_PERIMETER);
        when(calculator.getPerimeter(SECOND_TRIANGLE)).thenReturn(SECOND_PERIMETER);
        when(calculator.getPerimeter(THIRD_TRIANGLE)).thenReturn(THIRD_PERIMETER);
        TrianglePerimeterComparator perimeterComparator = new TrianglePerimeterComparator(calculator);
        TriangleSorter sorter = new TriangleSorter();
        //when
        List<Triangle> trianglesList = sorter.sortByPerimeter(TRIANGLES_LIST, perimeterComparator);
        //then
        Object[] expectedArray = trianglesList.toArray();
        Object[] actualArray = TRIANGLES_SORTED_LIST.toArray();
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testIdSort() {
        //given
        TriangleIdComparator idComparator = new TriangleIdComparator();
        TriangleSorter sorter = new TriangleSorter();
        //when
        List<TriangleObservable> trianglesObsList = sorter.sortById(TRIANGLES_OBS_LIST, idComparator);
        //then
        Object[] expectedArray = trianglesObsList.toArray();
        Object[] actualArray = TRIANGLES_OBS_SORTED_LIST.toArray();
        assertArrayEquals(expectedArray, actualArray);
    }
}
