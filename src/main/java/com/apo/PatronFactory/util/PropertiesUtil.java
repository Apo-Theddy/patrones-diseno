package com.apo.PatronFactory.util;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtil {
    public static final String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath()
            + "com/apo/PatronFactory/";

    public static Properties loadProperty(String propertiesURL) {
        try {

            FileInputStream fistream = new FileInputStream(new java.io.File(rootPath + propertiesURL));
            Properties properties = new Properties();
            properties.load(fistream);
            return properties;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
