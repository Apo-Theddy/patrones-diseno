package com.apo.PatronObserver.impl;

public interface IObserver {
    public void notifyObserver(String command, Object source);
}
