package com.apo.PatronObserver.impl.observers;

import java.util.Date;

import com.apo.PatronObserver.impl.ConfigurationManager;
import com.apo.PatronObserver.impl.IObserver;

public class DateFormatObserver implements IObserver {

    public void notifyObserver(String command, Object source) {
        if (command.equals("defaultDateFormat")) {
            ConfigurationManager conf = (ConfigurationManager) source;
            System.out.println("Observer ==> DatteFormatObserver.dateFormatChange> "
                    + conf.getDefaultDateFormat().format(new Date()));
        }

    }

}
