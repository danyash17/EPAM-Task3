package com.epam.task.third.repo;

import com.epam.task.third.creator.TriangleCreator;
import com.epam.task.third.specification.TriangleSpecification;
import com.epam.task.third.observer.TriangleObservable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TriangleRepository {
    private static Logger LOGGER = LogManager.getLogger(TriangleRepository.class);
    private final Map<Integer, TriangleObservable> triangleMap = new HashMap<>();

    public TriangleRepository() {
    }

    public void addTriangle(TriangleObservable triangle) {
        int triangleId = triangle.getId();
        triangleMap.put(triangleId, triangle);
        LOGGER.info("Triangle"+triangle.toString()+"added in a repository");
    }

    public void removeTriangle(TriangleObservable triangle) {
        int triangleId = triangle.getId();
        triangleMap.remove(triangleId);
        LOGGER.info("Triangle"+triangle.toString()+"removed from a repository");
    }

    public void updateTriangle(TriangleObservable triangle) {
        int triangleId = triangle.getId();
        triangleMap.replace(triangleId, triangle);
        LOGGER.info("Triangle"+triangle.toString()+"updated in a repository");
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
