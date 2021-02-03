package com.epam.task.third.figures.entities;

import com.epam.task.third.figures.logics.Triangle;

import java.util.Objects;

public class TriangleEntity {
    private final Point FIRST;
    private final Point SECOND;
    private final Point THIRD;
    private static boolean isTriangle(Point first, Point second, Point third){
        if ((third.getX() - first.getX()) / (second.getX() - first.getX()) ==
                (third.getY() - first.getY()) / (second.getY() - first.getY())){
            return false;
        }
        else return true;
    }
    public TriangleEntity(Point first, Point second, Point third) {
        if(!isTriangle(first,second,third)){
            throw new NotATriangleException();
        }
        this.FIRST = first;
        this.SECOND = second;
        this.THIRD = third;
    }

    public Point getFIRST() {
        return FIRST;
    }

    public Point getSECOND() {
        return SECOND;
    }

    public Point getTHIRD() {
        return THIRD;
    }
    //точки могут быть не упорядочены,но это будет тот же треугольник
    private boolean sameCollection(TriangleEntity triangle) {
        int matches = 0;
        if (triangle.FIRST == FIRST || triangle.FIRST == SECOND || triangle.FIRST == THIRD) matches++;
        if (triangle.SECOND == FIRST || triangle.SECOND == SECOND || triangle.SECOND == THIRD) matches++;
        if (triangle.THIRD == FIRST || triangle.THIRD == SECOND || triangle.THIRD == THIRD) matches++;
        return matches == 3;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TriangleEntity that = (TriangleEntity) obj;
        return sameCollection(that);
    }

    public int hashCode() {
        return Objects.hash(FIRST, SECOND, THIRD);
    }

    public String toString() {
        return "TriangleEntity{" +
                "first point=" + FIRST +
                ", second point=" + SECOND +
                ", third point=" + THIRD +
                '}';
    }
}
