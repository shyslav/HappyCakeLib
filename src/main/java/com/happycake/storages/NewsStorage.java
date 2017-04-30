package com.happycake.storages;

import com.shyslav.mysql.DBStorage;
import com.shyslav.mysql.connectionpool.ConnectionPool;
import com.shyslav.mysql.exceptions.DBException;
import com.happycake.sitemodels.News;

/**
 * @author Shyshkin Vladyslav on 29.04.17.
 */
public class NewsStorage extends DBStorage {
    public NewsStorage(ConnectionPool pool) throws DBException {
        super(pool, News.class);
    }
}
