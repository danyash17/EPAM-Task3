package com.epam.task.third.figures.logics;

import org.junit.Test;
import com.epam.task.third.figures.entities.Point;
import com.epam.task.third.figures.entities.Triangle;

import static org.junit.Assert.*;

public class TriangleCalculatorTest {
    private final double EPS = 10e-10;
    private final double ACTUAL_AREA = 25;
    private final double ACTUAL_PERIMETER = 24.1422;
    private final Point FIRST = new Point(0, 0);
    private final Point FIRST_RIGHT = new Point(5, 0);
    private final Point SECOND = new Point(10, 0);
    private final Point THIRD = new Point(5, 5);

    @Test
    public void testAreaCalculationTriangleArea25() {
        //given
        TriangleCalculator triangleCalculator = new TriangleCalculator();
        Triangle triangle = new Triangle(FIRST, SECOND, THIRD);
        //when
        double result = triangleCalculator.getArea(triangle);
        assertEquals(result, ACTUAL_AREA, EPS);
    }

    @Test
    public void testPerimeterCountingTrianglePerimeterNear24() {
        //given
        TriangleCalculator triangleCalculator = new TriangleCalculator();
        Triangle triangle = new Triangle(FIRST, SECOND, THIRD);
        //when
        double result = triangleCalculator.getPerimeter(triangle);
        //then
        assertEquals(result, ACTUAL_PERIMETER, EPS);
    }

    @Test
    public void testIsIsoscelesTriangle() {
        //given
        TriangleCalculator triangleCalculator = new TriangleCalculator();
        Triangle triangle = new Triangle(FIRST, SECOND, THIRD);
        //when,then
        assertTrue(triangleCalculator.isIsoscelesTriangle(triangle));
    }

    @Test
    public void testIsRightTriangle() {
        //given
        TriangleCalculator triangleCalculator = new TriangleCalculator();
        Triangle triangle = new Triangle(FIRST_RIGHT, SECOND, THIRD);
        //when,then
        assertTrue(triangleCalculator.isRightTriangle(triangle));
    }

    @Test
    public void testIsObtuseTriangle() {
        //given
        TriangleCalculator triangleCalculator = new TriangleCalculator();
        Triangle triangle = new Triangle(FIRST, SECOND, THIRD);
        //when,then
        assertFalse(triangleCalculator.isObtuseTriangle(triangle));
    }

    @Test
    public void testIsAcuteTriangle() {
        //given
        TriangleCalculator triangleCalculator = new TriangleCalculator();
        Triangle triangle = new Triangle(FIRST, SECOND, THIRD);
        //when,then
        assertTrue(triangleCalculator.isAcuteTriangle(triangle));
    }

    @Test
    public void testIsEquilateralTriangle() {
        //given
        TriangleCalculator triangleCalculator = new TriangleCalculator();
        Triangle triangle = new Triangle(FIRST, SECOND, THIRD);
        //when,then
        assertFalse(triangleCalculator.isEquilateralTriangle(triangle));
    }
}
