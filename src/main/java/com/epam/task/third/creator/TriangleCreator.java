package com.epam.task.third.creator;

import com.epam.task.third.figures.entities.Point;
import com.epam.task.third.figures.logics.Triangle;

public class TriangleCreator {
    public Triangle create(String properties){
        char[] allChars=properties.toCharArray();
        char[] onlyNumbers=new char[6];
        for(int i=0,j=0;i<properties.length();i++){
            if(allChars[i]=='('){
                onlyNumbers[j]=allChars[i+1];
                j++;
                onlyNumbers[j]=allChars[i+3];
                j++;
            }
        }
        Point first=new Point(Double.parseDouble(Character.toString(onlyNumbers[0])),Double.parseDouble(Character.toString(onlyNumbers[1])));
        Point second=new Point(Double.parseDouble(Character.toString(onlyNumbers[2])),Double.parseDouble(Character.toString(onlyNumbers[3])));
        Point third=new Point(Double.parseDouble(Character.toString(onlyNumbers[4])),Double.parseDouble(Character.toString(onlyNumbers[5])));
        Triangle triangle=new Triangle(first,second,third);
        return triangle;
    }
}
