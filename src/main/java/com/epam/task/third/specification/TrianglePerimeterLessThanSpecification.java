package com.epam.task.third.specification;

import com.epam.task.third.figures.logics.TriangleCalculator;
import com.epam.task.third.observer.TriangleObservable;

public class TrianglePerimeterLessThanSpecification implements TriangleSpecification {
    private TriangleCalculator calculator;
    private double perimeterBorderline;

    public TrianglePerimeterLessThanSpecification(TriangleCalculator calculator, double perimeterBorderline) {
        this.calculator = calculator;
        this.perimeterBorderline = perimeterBorderline;
    }

    @Override
    public boolean isSpecified(TriangleObservable triangle) {
        return calculator.getPerimeter(triangle) < perimeterBorderline;
    }
}
