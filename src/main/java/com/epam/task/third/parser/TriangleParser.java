package com.epam.task.third.parser;

import com.epam.task.third.figures.entities.Point;
import com.epam.task.third.figures.entities.Triangle;

public class TriangleParser {
    public Triangle create(String properties) {
        String[] onlyNumbers = properties.split(",", 6);
        Point first = new Point(Double.parseDouble(onlyNumbers[0]), Double.parseDouble(onlyNumbers[1]));
        Point second = new Point(Double.parseDouble(onlyNumbers[2]), Double.parseDouble(onlyNumbers[3]));
        Point third = new Point(Double.parseDouble(onlyNumbers[4]), Double.parseDouble(onlyNumbers[5]));
        Triangle triangle = new Triangle(first, second, third);
        return triangle;
    }
}
