package com.epam.task.third.parser;

import static org.junit.Assert.*;

import com.epam.task.third.figures.entities.Point;
import com.epam.task.third.figures.entities.Triangle;
import org.junit.Test;

public class TriangleParserTest {
    private Point FIRST = new Point(0, 0);
    private Point SECOND = new Point(1, 1);
    private Point THIRD = new Point(2, 2);
    private Triangle TRIANGLE_ACTUAL = new Triangle(FIRST, SECOND, THIRD);
    private String LINE = "0,0,1,1,2,2";

    @Test
    public void testParsing() {
        //given
        TriangleParser triangleParser = new TriangleParser();
        //when
        Triangle triangle_expected = triangleParser.create(LINE);
        //then
        assertEquals(triangle_expected, TRIANGLE_ACTUAL);
    }
}
