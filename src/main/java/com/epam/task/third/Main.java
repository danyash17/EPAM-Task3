package com.epam.task.third;

import com.epam.task.third.composer.TriangleComposer;
import com.epam.task.third.creator.TriangleCreator;
import com.epam.task.third.figures.entities.Point;
import com.epam.task.third.figures.logics.Triangle;
import com.epam.task.third.reader.DataException;
import com.epam.task.third.reader.DataReader;
import com.epam.task.third.validaror.DataValidator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws DataException {
        TriangleComposer triangleComposer=new TriangleComposer();
        List<Triangle> triangleList=triangleComposer.compose("./src/main/resources/input.txt");
        Triangle triangle=triangleList.get(0);
        System.out.println("Perimeter " + triangle.perimeter() +",Area "+ triangle.area());
        System.out.println("Right "+ triangle.isRightTriangle()+",Acute "+ triangle.isAcuteTriangle()+",Obtuse "+triangle.isObtuseTriangle());
        System.out.println("Isosceles "+triangle.isIsoscelesTriangle()+",Equilateral "+triangle.isEquilateralTriangle());
    }
}
