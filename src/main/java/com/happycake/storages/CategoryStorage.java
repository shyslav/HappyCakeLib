package com.happycake.storages;

import com.shyslav.mysql.DBStorage;
import com.shyslav.mysql.connectionpool.ConnectionPool;
import com.shyslav.mysql.exceptions.DBException;
import com.happycake.sitemodels.Category;

/**
 * @author Shyshkin Vladyslav on 29.04.17.
 */
public class CategoryStorage extends DBStorage {
    public CategoryStorage(ConnectionPool pool) throws DBException {
        super(pool, Category.class);
    }
}
