package com.epam.task.third.creator;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

import com.epam.task.third.figures.entities.Point;
import com.epam.task.third.figures.entities.Triangle;
import com.epam.task.third.parser.TriangleParser;
import com.epam.task.third.reader.DataException;
import com.epam.task.third.reader.DataReader;
import com.epam.task.third.validator.DataValidator;
import com.epam.task.third.validator.TriangleValidator;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleCreatorTest {
    private final Point FIRST=new Point(0,0);
    private final Point SECOND=new Point(1,1);
    private final Point THIRD=new Point(2,2);
    private final Point FOURTH=new Point(1,4);
    private final Point FIFTH=new Point(5,6);
    private final Point SIXTH=new Point(4,3);
    private final String PATH="./src/test/resources/input.txt";
    private final Triangle FIRST_TRIANGLE=new Triangle(FIRST,SECOND,THIRD);
    private final Triangle SECOND_TRIANGLE=new Triangle(FOURTH,FIFTH,SIXTH);
    private final Triangle[] ACTUAL_ARRAY= {FIRST_TRIANGLE,SECOND_TRIANGLE};
    private final List<String> LINES_FROM_FILE=Arrays.asList("0,0,1,1,2,2","1,4,5,6,4,3");
   @Test
    public void testCreation() throws DataException {
       //given
        DataReader reader = Mockito.mock(DataReader.class);
        DataValidator dataValidator = Mockito.mock(DataValidator.class);
        TriangleParser triangleParser = Mockito.mock(TriangleParser.class);
       TriangleValidator triangleValidator=Mockito.mock(TriangleValidator.class);
       TriangleCreator triangleCreator=new TriangleCreator();
       when(reader.readData(anyString())).thenReturn(LINES_FROM_FILE);
       when(dataValidator.validate(anyString())).thenReturn(true);
       when(triangleValidator.isExistingTriangle(any(Triangle.class))).thenReturn(true);
       when(triangleParser.create(LINES_FROM_FILE.get(0))).thenReturn(FIRST_TRIANGLE);
       when(triangleParser.create(LINES_FROM_FILE.get(1))).thenReturn(SECOND_TRIANGLE);
       //when
       List<Triangle> triangleList=triangleCreator.compose(PATH,reader,dataValidator,triangleParser,triangleValidator);
       //then
       Object[] expectedArray=triangleList.toArray();
       assertArrayEquals(expectedArray,ACTUAL_ARRAY);
   }
}
