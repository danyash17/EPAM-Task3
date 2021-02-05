package com.epam.task.third.reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.epam.task.third.creator.TriangleCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataReader {
    private static Logger LOGGER = LogManager.getLogger(TriangleCreator.class);

    public List<String> readData(final String filename) throws DataException {
        List<String> rawData = new ArrayList<>();
        FileReader inputStream = null;
        try {
            inputStream = new FileReader(filename);
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                rawData.add(scanner.nextLine());
            }
            inputStream.close();
            return rawData;
        } catch (IOException e) {
            LOGGER.warn("Something is not good with File Data");
            throw new DataException(e.getMessage(), e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    LOGGER.warn("Stream exception");
                }
            }
        }
    }
}
