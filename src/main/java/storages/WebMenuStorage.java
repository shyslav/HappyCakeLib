package storages;

import com.shyslav.mysql.DBStorage;
import com.shyslav.mysql.connectionpool.ConnectionPool;
import com.shyslav.mysql.exceptions.DBException;
import sitemodels.WebMenu;

/**
 * @author Shyshkin Vladyslav on 29.04.17.
 */
public class WebMenuStorage extends DBStorage {
    public WebMenuStorage(ConnectionPool pool) throws DBException {
        super(pool, WebMenu.class);
    }
}
