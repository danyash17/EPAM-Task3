package com.epam.task.third.comparator;

import com.epam.task.third.figures.entities.Triangle;
import com.epam.task.third.figures.logics.TriangleCalculator;

import java.util.Comparator;

public class TriangleAreaComparator implements Comparator<Triangle> {
private TriangleCalculator calculator;

    public TriangleAreaComparator(TriangleCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int compare(Triangle triangleFirst, Triangle triangleSecond) {
        Double areaFirst=calculator.getArea(triangleFirst);
        Double areaSecond=calculator.getArea(triangleSecond);
        return areaFirst.compareTo(areaSecond);
    }
}
