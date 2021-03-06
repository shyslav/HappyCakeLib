package com.happycake.storages;

import com.shyslav.mysql.DBStorage;
import com.shyslav.mysql.connectionpool.ConnectionPool;
import com.shyslav.mysql.exceptions.DBException;
import com.happycake.sitemodels.Dish;

/**
 * @author Shyshkin Vladyslav on 29.04.17.
 */
public class DishStorage extends DBStorage {
    public DishStorage(ConnectionPool pool) throws DBException {
        super(pool, Dish.class);
    }
}
