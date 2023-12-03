package com.apo.PatronFactory.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.apo.PatronFactory.factory.IDBAdapter;
import com.apo.PatronFactory.util.PropertiesUtil;

public class SQLServerDBAdapter implements IDBAdapter {
    private static final String DB_PROPERTIES = "META-INF/DBSQLServer.properties";

    private static final String DB_NAME_PROP = "dbname";
    private static final String DB_USER_PROP = "user";
    private static final String DB_PASSWORD_PROP = "password";
    private static final String DB_PORT_PROP = "port";

    static {
        try {
            new com.microsoft.sqlserver.jdbc.SQLServerDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            String connectionString = createConnectionString();
            Connection connection = DriverManager.getConnection(connectionString);
            System.out.println("ConnectionClass ==> " + connection.getClass().getName());
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    String createConnectionString() {
        Properties prop = PropertiesUtil.loadProperty(DB_PROPERTIES);

        String dbname = prop.getProperty(DB_NAME_PROP);
        String user = prop.getProperty(DB_USER_PROP);
        String password = prop.getProperty(DB_PASSWORD_PROP);
        String port = prop.getProperty(DB_PORT_PROP);
        String connectionString = "jdbc:sqlserver://localhost:" + port + ";databaseName=" + dbname + ";user=" + user
                + ";password=" + password + ";encrypt=true;trustServerCertificate=true;";
        System.out.println("ConnectionString ==> " + connectionString);
        return connectionString;

    }

}
