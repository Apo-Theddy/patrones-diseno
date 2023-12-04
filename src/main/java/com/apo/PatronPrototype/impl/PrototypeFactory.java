package com.apo.PatronPrototype.impl;

import java.util.HashMap;

public class PrototypeFactory {
    private static HashMap<String, IPrototype> prototypes = new HashMap<String, IPrototype>();

    public static IPrototype getPrototype(String prototypeName) {
        return prototypes.get(prototypeName).deepClone();
    }

    public static void addPrototype(String prototypeName, IPrototype prototype) {
        prototypes.put(prototypeName, prototype);
    }
}
