package com.apo.PatronObserver.impl;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractObservable implements IObservable {
    private final List<IObserver> observers = new ArrayList<IObserver>();

    public void addObserver(IObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(IObserver observer) {
        this.observers.remove(observer);
    }

    public void notifyAllObservers(String command, Object source) {
        for (IObserver observer : observers) {
            observer.notifyObserver(command, source);
        }
    }

}
