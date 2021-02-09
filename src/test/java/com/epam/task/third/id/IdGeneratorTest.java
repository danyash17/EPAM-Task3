package com.epam.task.third.id;

import org.junit.Test;

import static org.junit.Assert.*;

public class IdGeneratorTest {
    private final int EXPECTED_DEFAULT = 0;
    private final int EXPECTED = 1;

    @Test
    public void testIdGenerationDefault() {
        //given
        IdGenerator idGenerator = IdGenerator.getInstance();
        //when
        int idActual = idGenerator.generateId();
        assertEquals(EXPECTED_DEFAULT, idActual);
    }

    @Test
    public void testIdGeneration() {
        //given
        IdGenerator idGenerator = IdGenerator.getInstance(EXPECTED);
        //when
        int idActual = idGenerator.generateId();
        //then
        assertEquals(EXPECTED, idActual);
    }
}
