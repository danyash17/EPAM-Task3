package com.epam.task.third.id;

public class IdGenerator {
    private static final int DEFAULT = 0;
    private static int id;
    private static IdGenerator instance;

    private IdGenerator(int idIn) {
        id = idIn;
    }

    private IdGenerator() {
        id = DEFAULT;
    }

    public static IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }

    public static IdGenerator getInstance(int idIn) {
        if (instance == null) {
            instance = new IdGenerator(idIn);
        }
        return instance;
    }

    public int generateId() {
        return id++;
    }
}
