package com.happycake.storages;

import com.shyslav.mysql.DBStorage;
import com.shyslav.mysql.connectionpool.ConnectionPool;
import com.shyslav.mysql.exceptions.DBException;
import com.shyslav.mysql.interfaces.DBEntity;
import com.happycake.sitemodels.Reports;

import java.util.ArrayList;

/**
 * @author Shyshkin Vladyslav on 29.04.17.
 */
public class ReportsStorage extends DBStorage {
    public ReportsStorage(ConnectionPool pool) throws DBException {
        super(pool, Reports.class);
    }

    /**
     * Get reports by vision status
     *
     * @param status true if report vision
     * @return all reports by status
     * @throws DBException
     */
    public ArrayList<Reports> getReportsByVision(boolean status) throws DBException {
        ArrayList<Reports> result = new ArrayList<>();
        ArrayList<DBEntity> vision = entityInitializer.select.where("vision", status).execute();
        for (DBEntity entity : vision) {
            result.add((Reports) entity);
        }
        return result;
    }
}
