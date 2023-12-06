package com.apo.PatronObserver.impl.observers;

import com.apo.PatronObserver.impl.ConfigurationManager;
import com.apo.PatronObserver.impl.IObserver;

public class MoneyFormatObserver implements IObserver {

    public void notifyObserver(String command, Object source) {
        if (command.equals("moneyFormat")) {
            ConfigurationManager conf = (ConfigurationManager) source;
            System.out.println("Observer ==> MoneyFormatObseerver.moneyFormatChange > "
                    + conf.getMoneyFormat().format(1.11));
        }
    }

}
