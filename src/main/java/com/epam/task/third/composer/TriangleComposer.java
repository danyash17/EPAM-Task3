package com.epam.task.third.composer;

import com.epam.task.third.creator.TriangleCreator;
import com.epam.task.third.figures.logics.Triangle;
import com.epam.task.third.reader.DataException;
import com.epam.task.third.reader.DataReader;
import com.epam.task.third.validaror.DataValidator;

import java.util.ArrayList;
import java.util.List;

public class TriangleComposer {
    public List<Triangle> compose(final String filepath) throws DataException {
        DataReader reader=new DataReader();
        DataValidator validator=new DataValidator();
        TriangleCreator triangleCreator=new TriangleCreator();
        List<String> stringList=reader.readData("./src/main/resources/input.txt");
        List<Triangle> triangleList=new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            if (validator.validate(stringList.get(i))) {
                triangleList.add(triangleCreator.create(stringList.get(i)));
            }
        }
        return triangleList;
    }
}
