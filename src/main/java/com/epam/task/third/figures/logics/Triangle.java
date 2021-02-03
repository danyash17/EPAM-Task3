package com.epam.task.third.figures.logics;

import com.epam.task.third.figures.entities.Point;
import com.epam.task.third.figures.entities.TriangleEntity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Objects;

public class Triangle extends TriangleEntity implements CharacteristicsCalculator {
    public Triangle(Point first, Point second, Point third) {
        super(first, second, third);
    }

    private double distance(Point from, Point to) {
        double result = Math.sqrt((from.getX() - to.getX()) * (from.getX() - to.getX()) +
                (from.getY() - to.getY()) * (from.getY() - to.getY()));
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
        otherSymbols.setDecimalSeparator('.');
        String pattern = "###.####";
        DecimalFormat decimal = new DecimalFormat(pattern, otherSymbols);
        return Double.parseDouble(decimal.format(result));
    }

    private final double A = distance(super.getFIRST(), super.getSECOND());
    private final double B = distance(super.getSECOND(), super.getTHIRD());
    private final double C = distance(super.getTHIRD(), super.getFIRST());

    //формула Герона
    public double area() {
        double halfPerimeter = perimeter() / 2;
        double result = Math.sqrt(halfPerimeter * (halfPerimeter - A) * (halfPerimeter - B) * (halfPerimeter - C));
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
        otherSymbols.setDecimalSeparator('.');
        String pattern = "###.###";
        DecimalFormat decimal = new DecimalFormat(pattern, otherSymbols);
        return Double.parseDouble(decimal.format(result));
    }

    public double perimeter() {
        return A + B + C;
    }

    //прямоугольный
    public boolean isRightTriangle() {
        if (A * A + B * B == C * C || B * B + C * C == A * A || A * A + C * C == B * B) return true;
        else return false;
    }

    //тупоугольный
    public boolean isObtuseTriangle() {
        if (A * A + B * B < C * C || B * B + C * C < A * A || A * A + C * C < B * B) return true;
        else return false;
    }

    //остроугольный
    public boolean isAcuteTriangle() {
        if (!isObtuseTriangle()) return true;
        else return false;
    }

    //равнобедренный
    public boolean isIsoscelesTriangle() {
        if (A == B || B == C || A == C) return true;
        else return false;
    }

    //равносторонний
    public boolean isEquilateralTriangle() {
        if (A == B && A == C) return true;
        else return false;
    }
    //длины сторон могут быть не упорядочены,но это будет тот же треугольник
    private boolean sameCollection(Triangle triangle) {
        int matches = 0;
        if (triangle.A == A || triangle.A == B || triangle.A == C) matches++;
        if (triangle.B == A || triangle.B == B || triangle.B == C) matches++;
        if (triangle.C == A || triangle.C == B || triangle.C == C) matches++;
        return matches == 3;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Triangle)) return false;
        if (!super.equals(obj)) return false;
        Triangle triangle = (Triangle) obj;
        return sameCollection(triangle);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), A, B, C);
    }

    public String toString() {
        return "Triangle{" +
                "A=" + A +
                ", B=" + B +
                ", C=" + C +
                '}';
    }
}
