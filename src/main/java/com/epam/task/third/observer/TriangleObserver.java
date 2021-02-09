package com.epam.task.third.observer;


import com.epam.task.third.figures.logics.TriangleCalculator;
import com.epam.task.third.parameters.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class TriangleObserver implements Observer {
    private static Logger LOGGER = LogManager.getLogger(TriangleObserver.class);
    private static TriangleObserver instance;
    private TriangleCalculator calculator = new TriangleCalculator();
    private Map<Integer, Parameters> parametersMap = new HashMap<Integer, Parameters>();

    private TriangleObserver() {
        LOGGER.info("Singleton TriangleObserver created");
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
