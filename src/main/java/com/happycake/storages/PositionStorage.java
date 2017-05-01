package com.happycake.storages;

import com.happycake.sitemodels.Position;
import com.shyslav.mysql.DBStorage;
import com.shyslav.mysql.connectionpool.ConnectionPool;
import com.shyslav.mysql.exceptions.DBException;

/**
 * @author Shyshkin Vladyslav on 29.04.17.
 */
public class PositionStorage extends DBStorage {
    public PositionStorage(ConnectionPool pool) throws DBException {
        super(pool, Position.class);
    }
}
