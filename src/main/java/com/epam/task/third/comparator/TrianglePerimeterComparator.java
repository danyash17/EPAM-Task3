package com.epam.task.third.comparator;

import com.epam.task.third.figures.entities.Triangle;
import com.epam.task.third.figures.logics.TriangleCalculator;

import java.util.Comparator;

public class TrianglePerimeterComparator implements Comparator<Triangle> {
    private TriangleCalculator calculator;

    public TrianglePerimeterComparator(TriangleCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int compare(Triangle triangleFirst, Triangle triangleSecond) {
        Double perimeterFirst=calculator.getPerimeter(triangleFirst);
        Double perimeterSecond=calculator.getPerimeter(triangleSecond);
        return perimeterFirst.compareTo(perimeterSecond);
    }
}
