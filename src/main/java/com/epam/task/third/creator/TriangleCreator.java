package com.epam.task.third.creator;

import com.epam.task.third.parser.TriangleParser;
import com.epam.task.third.figures.entities.Triangle;
import com.epam.task.third.reader.DataException;
import com.epam.task.third.reader.DataReader;
import com.epam.task.third.validator.DataValidator;
import com.epam.task.third.validator.TriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TriangleCreator {
    private static Logger LOGGER = LogManager.getLogger(TriangleCreator.class);

    public List<Triangle> compose(final String filepath,DataReader reader,DataValidator dataValidator,TriangleParser triangleParser,TriangleValidator triangleValidator) throws DataException {
        List<String> stringList = reader.readData(filepath);
        List<Triangle> triangleList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String current = stringList.get(i);
            if (dataValidator.validate(current)) {
                LOGGER.info("Creating another triangle");
                Triangle newTriangle = triangleParser.create(current);
                if (triangleValidator.isExistingTriangle(newTriangle)) {
                    triangleList.add(newTriangle);
                }
            }
        }
        return triangleList;
    }
}
