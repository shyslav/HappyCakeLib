package storages;

import com.shyslav.mysql.DBStorage;
import com.shyslav.mysql.connectionpool.ConnectionPool;
import com.shyslav.mysql.connectionpool.MysqlConnection;
import com.shyslav.mysql.exceptions.DBException;
import sitemodels.PreOrder;
import sitemodels.Reservation;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Shyshkin Vladyslav on 29.04.17.
 */
public class PreOrderStorage extends DBStorage {
    public PreOrderStorage(ConnectionPool pool) throws DBException {
        super(pool, PreOrder.class);
    }
}
