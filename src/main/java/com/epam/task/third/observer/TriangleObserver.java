package com.epam.task.third.observer;


import com.epam.task.third.figures.logics.TriangleCalculator;
import com.epam.task.third.parameters.Parameters;

import java.util.HashMap;
import java.util.Map;

public class TriangleObserver implements Observer {
    private static TriangleObserver instance;
    private TriangleCalculator calculator = new TriangleCalculator();
    private Map<Integer, Parameters> parametersMap = new HashMap<Integer, Parameters>();

    private TriangleObserver() {
    }

    public static TriangleObserver getInstance() {
        if (instance == null) {
            instance = new TriangleObserver();
        }
        return instance;
    }

    @Override
    public void update(TriangleObservable triangle) {
        double area = calculator.getArea(triangle);
        double perimeter = calculator.getPerimeter(triangle);
        Parameters params = new Parameters(area, perimeter);
        int triangleId = triangle.getId();
        parametersMap.put(triangleId, params);
    }

    public Map<Integer, Parameters> getParametersMap() {
        return parametersMap;
    }
}
