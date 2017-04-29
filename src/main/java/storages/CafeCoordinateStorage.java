package storages;

import com.shyslav.mysql.DBStorage;
import com.shyslav.mysql.connectionpool.ConnectionPool;
import com.shyslav.mysql.exceptions.DBException;
import sitemodels.CafeCoordinate;
import sitemodels.Dish;

/**
 * @author Shyshkin Vladyslav on 29.04.17.
 */
public class CafeCoordinateStorage extends DBStorage {
    public CafeCoordinateStorage(ConnectionPool pool) throws DBException {
        super(pool, CafeCoordinate.class);
    }
}
