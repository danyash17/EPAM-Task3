package com.epam.task.third.sorter;

import com.epam.task.third.comparator.TriangleAreaComparator;
import com.epam.task.third.comparator.TriangleIdComparator;
import com.epam.task.third.comparator.TrianglePerimeterComparator;
import com.epam.task.third.figures.entities.Triangle;

import java.util.ArrayList;
import java.util.List;

import com.epam.task.third.observer.TriangleObservable;

import java.util.Collections;

public class TriangleSorter {
    public List<TriangleObservable> sortById(List<TriangleObservable> triangles, TriangleIdComparator comparator) {
        List<TriangleObservable> triangleObservables = new ArrayList<>(triangles);
        Collections.sort(triangleObservables, comparator);
        return triangleObservables;
    }

    public List<Triangle> sortByArea(List<Triangle> triangles, TriangleAreaComparator comparator) {
        List<Triangle> triangleObservables = new ArrayList<>(triangles);
        Collections.sort(triangleObservables, comparator);
        return triangleObservables;
    }

    public List<Triangle> sortByPerimeter(List<Triangle> triangles, TrianglePerimeterComparator comparator) {
        List<Triangle> triangleObservables = new ArrayList<>(triangles);
        Collections.sort(triangleObservables, comparator);
        return triangleObservables;
    }
}
