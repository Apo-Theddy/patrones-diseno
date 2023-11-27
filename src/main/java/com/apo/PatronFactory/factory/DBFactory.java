package com.apo.PatronFactory.factory;

import java.util.Properties;

import com.apo.PatronFactory.impl.MySQLDBAdapter;
import com.apo.PatronFactory.impl.OracleDBAdapter;
import com.apo.PatronFactory.impl.SQLServerDBAdapter;
import com.apo.PatronFactory.util.PropertiesUtil;

public class DBFactory {
    private static final String DB_FACTORY_PROPERTY_URL = "META-INF/DBFactory.properties";
    private static final String DEFAULT_DB_CLASS_PROP = "defaultDBClass";

    public static IDBAdapter getDBAdapter(DBType dbType) {
        switch (dbType) {
            case MySql:
                return new MySQLDBAdapter();
            case Oracle:
                return new OracleDBAdapter();
            case SqlServer:
                return new SQLServerDBAdapter();
            default:
                throw new IllegalArgumentException("No soportado");
        }
    }

    public static IDBAdapter getDefaultDBAdapter() {
        try {
            Properties prop = PropertiesUtil.loadProperty(DB_FACTORY_PROPERTY_URL);
            String defaultDBClass = prop.getProperty(DEFAULT_DB_CLASS_PROP);
            System.out.println("DefaultDBClass ==> " + defaultDBClass);
            return (IDBAdapter) Class.forName(defaultDBClass).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
