package com.apo;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import com.apo.PatronBuilder.dto.Employee;
import com.apo.PatronObserver.impl.ConfigurationManager;
import com.apo.PatronObserver.impl.observers.DateFormatObserver;
import com.apo.PatronObserver.impl.observers.MoneyFormatObserver;
import com.apo.PatronPrototype.impl.PriceListImpl;
import com.apo.PatronPrototype.impl.ProductItem;
import com.apo.PatronPrototype.impl.PrototypeFactory;

public class App {
    public static void main(String[] args) {
        // Patron Observer

        ConfigurationManager conf = ConfigurationManager.getInstance();

        // Se establecen los valores por default
        conf.setDefaultDateFormat(new SimpleDateFormat("yyyy/MM/dd"));
        conf.setMoneyFormat(new DecimalFormat("##.00"));

        System.out.println("Configuracion Establecida");

        // Se dan de alta a los observers
        DateFormatObserver dateFormatObserver = new DateFormatObserver();
        MoneyFormatObserver moneyFormatObserver = new MoneyFormatObserver();

        conf.addObserver(dateFormatObserver);
        conf.addObserver(moneyFormatObserver);

        System.out.println("");

        // Se cambia la configuracion
        conf.setDefaultDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
        conf.setMoneyFormat(new DecimalFormat("###,#00.00"));

        System.out.println("");

        // Se realiza otro cambio en la configuracion
        conf.setDefaultDateFormat(new SimpleDateFormat("MM/yyyy/dd"));
        conf.setMoneyFormat(new DecimalFormat("###,#00"));

        conf.removeObserver(dateFormatObserver);
        conf.removeObserver(moneyFormatObserver);
        System.out.println("");

        // Se realiza otro cambio en la configuracion
        conf.setDefaultDateFormat(new SimpleDateFormat("MM/yyyy/dd"));
        conf.setMoneyFormat(new DecimalFormat("###,#00"));
    }
}
