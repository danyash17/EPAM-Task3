package com.epam.task.third.validator;

import com.epam.task.third.figures.entities.Point;
import com.epam.task.third.figures.entities.Triangle;

public class TriangleValidator {
    public boolean isExistingTriangle(Triangle triangle) {
        Point first = triangle.getFirst();
        Point second = triangle.getSecond();
        Point third = triangle.getThird();
        //общее уравнение прямой,проверка третьей точки
        return (third.getX() - first.getX()) / (second.getX() - first.getX()) ==
                (third.getY() - first.getY()) / (second.getY() - first.getY());
    }
}
