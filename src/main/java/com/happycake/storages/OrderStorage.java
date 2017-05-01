package com.happycake.storages;

import com.happycake.sitemodels.Order;
import com.happycake.sitemodels.OrderDetails;
import com.happycake.sitemodels.OrderList;
import com.happycake.sitemodels.Position;
import com.shyslav.mysql.DBStorage;
import com.shyslav.mysql.connectionpool.ConnectionPool;
import com.shyslav.mysql.exceptions.DBException;

/**
 * @author Shyshkin Vladyslav on 29.04.17.
 */
public class OrderStorage extends DBStorage {
    private final OrderDetailsStorage orderDetailsStorage;

    public OrderStorage(ConnectionPool pool, OrderDetailsStorage orderDetailsStorage) throws DBException {
        super(pool, Order.class);
        this.orderDetailsStorage = orderDetailsStorage;
    }

    /**
     * Add to order details
     *
     * @param list list of orders
     * @throws DBException
     */
    public OrderList load(OrderList list) throws DBException {
        for (Order order : list) {
            order.setOrderDetails(orderDetailsStorage.getByOrderID(order.getId()));
        }
        return list;
    }
}
