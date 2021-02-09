package com.epam.task.third.observer;

import com.epam.task.third.figures.entities.Point;
import com.epam.task.third.figures.entities.Triangle;
import com.epam.task.third.id.IdGenerator;

import java.util.ArrayList;
import java.util.Iterator;

public class TriangleObservable extends Triangle {
    private int id;
    private IdGenerator idGenerator=IdGenerator.getInstance();
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public TriangleObservable(Point first, Point second, Point third) {
        super(first, second, third);
        id = idGenerator.generateId();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {

        Iterator iterator = observers.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (element==observer) {
                iterator.remove();
            }
        }
    }

    private void notifyObservers() {
        for (Observer thisObserver : observers) {
            thisObserver.update(this);
        }
    }

    @Override
    public void setFirst(Point first) {
        super.setFirst(first);
        notifyObservers();
    }

    @Override
    public void setSecond(Point second) {
        super.setSecond(second);
        notifyObservers();
    }

    @Override
    public void setThird(Point third) {
        super.setThird(third);
        notifyObservers();
    }

    public int getId() {
        return id;
    }
}
