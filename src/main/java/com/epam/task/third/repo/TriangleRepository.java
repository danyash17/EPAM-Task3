package com.epam.task.third.repo;

import com.epam.task.third.specification.TriangleSpecification;
import com.epam.task.third.observer.TriangleObservable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TriangleRepository {
    private final Map<Integer, TriangleObservable> triangleMap = new HashMap<>();

    public TriangleRepository() {
    }

    public void addTriangle(TriangleObservable triangle) {
        int triangleId = triangle.getId();
        triangleMap.put(triangleId, triangle);
    }

    public void removeTriangle(TriangleObservable triangle) {
        int triangleId = triangle.getId();
        triangleMap.remove(triangleId);
    }

    public void updateTriangle(TriangleObservable triangle) {
        int triangleId = triangle.getId();
        triangleMap.replace(triangleId, triangle);
    }

    public Map<Integer, TriangleObservable> getTriangleMap() {
        return triangleMap;
    }

    public ArrayList<TriangleObservable> query(TriangleSpecification specification) {
        ArrayList<TriangleObservable> suitableTriangles = new ArrayList<>();
        for (TriangleObservable triangle : triangleMap.values()) {
            if (specification.isSpecified(triangle)) {
                suitableTriangles.add(triangle);
            }
        }
        return suitableTriangles;
    }
}
