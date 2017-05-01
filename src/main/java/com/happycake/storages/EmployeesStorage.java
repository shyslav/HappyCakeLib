package com.happycake.storages;

import com.happycake.sitemodels.Employees;
import com.shyslav.mysql.DBStorage;
import com.shyslav.mysql.connectionpool.ConnectionPool;
import com.shyslav.mysql.exceptions.DBException;
import com.shyslav.mysql.interfaces.DBEntity;

/**
 * @author Shyshkin Vladyslav on 29.04.17.
 */
public class EmployeesStorage extends DBStorage {
    public EmployeesStorage(ConnectionPool pool) throws DBException {
        super(pool, Employees.class);
    }

    /**
     * Get employee by login and password
     *
     * @param login    username login
     * @param password username password
     * @return Employee entity if exist
     */
    public Employees getEmployeeByLoginAndPassword(String login, String password) throws DBException {
        DBEntity entity = entityInitializer.select.where("login", login).where("password", password).getOne();
        if (entity == null) {
            return null;
        }
        return (Employees) entity;
    }
}
