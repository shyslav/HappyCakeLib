package com.happycake.storages;

import com.shyslav.mysql.DBStorage;
import com.shyslav.mysql.connectionpool.ConnectionPool;
import com.shyslav.mysql.exceptions.DBException;
import com.happycake.sitemodels.PreOrder;

/**
 * @author Shyshkin Vladyslav on 29.04.17.
 */
public class PreOrderStorage extends DBStorage {
    public PreOrderStorage(ConnectionPool pool) throws DBException {
        super(pool, PreOrder.class);
    }
}
