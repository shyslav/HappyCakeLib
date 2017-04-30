package com.happycake.storages;

import com.shyslav.mysql.DBStorage;
import com.shyslav.mysql.connectionpool.ConnectionPool;
import com.shyslav.mysql.connectionpool.MysqlConnection;
import com.shyslav.mysql.exceptions.DBException;
import com.happycake.sitemodels.Reservation;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Shyshkin Vladyslav on 29.04.17.
 */
public class ReservationStorage extends DBStorage {
    public ReservationStorage(ConnectionPool pool) throws DBException {
        super(pool, Reservation.class);
    }

    /**
     * Get max id from reservation table
     *
     * @return id of max id in reservation table
     * @throws DBException
     */
    public int getMaxID() throws DBException {
        try (MysqlConnection session = entityInitializer.getConnectionPool().getConnection()) {
            ResultSet resultSet = session.executeSQLQuery("select max(id) from reservation");
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                throw new DBException(" Table reservation is empty ");
            }
        } catch (SQLException e) {
            throw new DBException("Unable to select max id from reservation table " + e.getMessage(), e);
        }
    }
}
