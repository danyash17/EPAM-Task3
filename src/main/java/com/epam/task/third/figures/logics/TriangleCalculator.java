package com.epam.task.third.figures.logics;

import com.epam.task.third.figures.entities.Point;
import com.epam.task.third.figures.entities.Triangle;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class TriangleCalculator {
    private double eps = 10e-3;

    private double countSide(Point from, Point to) {
        double result = Math.sqrt((from.getX() - to.getX()) * (from.getX() - to.getX()) +
                (from.getY() - to.getY()) * (from.getY() - to.getY()));
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
        otherSymbols.setDecimalSeparator('.');
        String pattern = "###.####";
        DecimalFormat decimal = new DecimalFormat(pattern, otherSymbols);
        String stringDecimal = decimal.format(result);
        return Double.parseDouble(stringDecimal);
    }

    public double getArea(Triangle triangle) {
        double sideA = countSide(triangle.getFirst(), triangle.getSecond());
        double sideB = countSide(triangle.getSecond(), triangle.getThird());
        double sideC = countSide(triangle.getFirst(), triangle.getThird());
        double halfPerimeter = (sideA + sideB + sideC) / 2;
        double result = Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
        otherSymbols.setDecimalSeparator('.');
        String pattern = "###.###";
        DecimalFormat decimal = new DecimalFormat(pattern, otherSymbols);
        String decimalString = decimal.format(result);
        return Double.parseDouble(decimalString);
    }

    public double getPerimeter(Triangle triangle) {
        double sideA = countSide(triangle.getFirst(), triangle.getSecond());
        double sideB = countSide(triangle.getSecond(), triangle.getThird());
        double sideC = countSide(triangle.getFirst(), triangle.getThird());
        return sideA + sideB + sideC;
    }

    //прямоугольный
    public boolean isRightTriangle(Triangle triangle) {
        double sideA = countSide(triangle.getFirst(), triangle.getSecond());
        double sideB = countSide(triangle.getSecond(), triangle.getThird());
        double sideC = countSide(triangle.getFirst(), triangle.getThird());
        return Math.abs(sideA * sideA + sideB * sideB - sideC * sideC) < eps ||
                Math.abs(sideB * sideB + sideC * sideC - sideA * sideA) < eps ||
                Math.abs(sideA * sideA + sideC * sideC - sideB * sideB) < eps;
    }

    //тупоугольный
    public boolean isObtuseTriangle(Triangle triangle) {
        double sideA = countSide(triangle.getFirst(), triangle.getSecond());
        double sideB = countSide(triangle.getSecond(), triangle.getThird());
        double sideC = countSide(triangle.getFirst(), triangle.getThird());
        return sideA * sideA + sideB * sideB < sideC * sideC ||
                sideB * sideB + sideC * sideC < sideA * sideA ||
                sideA * sideA + sideC * sideC < sideB * sideB;
    }

    //остроугольный
    public boolean isAcuteTriangle(Triangle triangle) {
        return !isObtuseTriangle(triangle);
    }

    //равнобедренный
    public boolean isIsoscelesTriangle(Triangle triangle) {
        double sideA = countSide(triangle.getFirst(), triangle.getSecond());
        double sideB = countSide(triangle.getSecond(), triangle.getThird());
        double sideC = countSide(triangle.getFirst(), triangle.getThird());
        return sideA == sideB || sideB == sideC || sideA == sideC;
    }

    //равносторонний
    public boolean isEquilateralTriangle(Triangle triangle) {
        double sideA = countSide(triangle.getFirst(), triangle.getSecond());
        double sideB = countSide(triangle.getSecond(), triangle.getThird());
        double sideC = countSide(triangle.getFirst(), triangle.getThird());
        return sideA == sideB && sideA == sideC;
    }

}
