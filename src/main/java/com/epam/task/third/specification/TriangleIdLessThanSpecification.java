package com.epam.task.third.specification;

import com.epam.task.third.observer.TriangleObservable;

public class TriangleIdLessThanSpecification implements TriangleSpecification {
    private int idBorderline;

    public TriangleIdLessThanSpecification(int idBorderline) {
        this.idBorderline = idBorderline;
    }

    @Override
    public boolean isSpecified(TriangleObservable triangle) {
        return triangle.getId() < idBorderline;
    }
}
