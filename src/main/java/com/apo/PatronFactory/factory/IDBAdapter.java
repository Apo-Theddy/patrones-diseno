package com.apo.PatronFactory.factory;

import java.sql.Connection;

public interface IDBAdapter {
    public Connection getConnection();
}
