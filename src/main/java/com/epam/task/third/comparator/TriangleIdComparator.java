package com.epam.task.third.comparator;

import com.epam.task.third.observer.TriangleObservable;

import java.util.Comparator;

public class TriangleIdComparator implements Comparator<TriangleObservable> {

    @Override
    public int compare(TriangleObservable triangleFirst, TriangleObservable triangleSecond) {
        Integer idFirst = triangleFirst.getId();
        Integer idSecond = triangleSecond.getId();
        return idFirst.compareTo(idSecond);
    }
}
