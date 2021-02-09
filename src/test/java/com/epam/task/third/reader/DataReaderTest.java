package com.epam.task.third.reader;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DataReaderTest {
    private List<String> LINES = Arrays.asList("1", "2", "4", "5", "2", "8");
    private String[] ARRAY = {"1,2,4,5,2,8"};
    private String FILE_PATH = "./src/test/resources/input.txt";

    @Test
    public void testDataReadingFromFile() throws DataException {
        //given
        DataReader dataReader = new DataReader();
        //when
        List<String> readResultList = dataReader.readData(FILE_PATH);
        Object[] readResult = readResultList.toArray();
        //then
        assertArrayEquals(readResult, ARRAY);
    }
}
