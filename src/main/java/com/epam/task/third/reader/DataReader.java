package com.epam.task.third.reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataReader {

    public List<String> readData(final String filename) throws DataException {
        try {
            List<String> rawData = new ArrayList<>();
            FileReader inputStream = new FileReader(filename);
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                rawData.add(scanner.nextLine());
            }
            inputStream.close();
            return rawData;
        } catch (IOException e) {
            throw new DataException(e.getMessage(),e);
        }
    }
}
