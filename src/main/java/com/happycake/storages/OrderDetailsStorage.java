package com.happycake.storages;

import com.happycake.sitemodels.OrderDetails;
import com.happycake.sitemodels.OrderDetailsList;
import com.happycake.sitemodels.Position;
import com.shyslav.mysql.DBStorage;
import com.shyslav.mysql.connectionpool.ConnectionPool;
import com.shyslav.mysql.exceptions.DBException;
import com.shyslav.mysql.interfaces.DBEntity;

import java.util.ArrayList;

/**
 * @author Shyshkin Vladyslav on 29.04.17.
 */
public class OrderDetailsStorage extends DBStorage {
    public OrderDetailsStorage(ConnectionPool pool) throws DBException {
        super(pool, OrderDetails.class);
    }

    /**
     * Get order details by order id
     *
     * @param orderID order id
     * @return details list by order id
     * @throws DBException
     */
    public OrderDetailsList getByOrderID(int orderID) throws DBException {
        OrderDetailsList list = new OrderDetailsList();
        ArrayList<DBEntity> details = entityInitializer.select.where("id_order", orderID).execute();
        for (DBEntity detail : details) {
            list.add((OrderDetails) detail);
        }
        return list;
    }
}
