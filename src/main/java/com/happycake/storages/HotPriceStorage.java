package com.happycake.storages;

import com.shyslav.mysql.DBStorage;
import com.shyslav.mysql.connectionpool.ConnectionPool;
import com.shyslav.mysql.exceptions.DBException;
import com.happycake.sitemodels.HotPrice;

/**
 * @author Shyshkin Vladyslav on 29.04.17.
 */
public class HotPriceStorage extends DBStorage {
    public HotPriceStorage(ConnectionPool pool) throws DBException {
        super(pool, HotPrice.class);
    }
}
