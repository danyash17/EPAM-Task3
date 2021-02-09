package com.epam.task.third.specification;

import com.epam.task.third.figures.logics.TriangleCalculator;
import com.epam.task.third.observer.TriangleObservable;

public class TriangleAreaLessThanSpecification implements TriangleSpecification {
    private TriangleCalculator calculator;
    private double areaBorderline;

    public TriangleAreaLessThanSpecification(TriangleCalculator calculator, double areaBorderline) {
        this.calculator = calculator;
        this.areaBorderline = areaBorderline;
    }

    @Override
    public boolean isSpecified(TriangleObservable triangle) {
        return calculator.getArea(triangle) < areaBorderline;
    }
}
