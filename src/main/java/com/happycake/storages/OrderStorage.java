package com.happycake.storages;

import com.happycake.sitemodels.Order;
import com.happycake.sitemodels.OrderDetails;
import com.happycake.sitemodels.OrderList;
import com.happycake.sitemodels.Position;
import com.shyslav.mysql.DBEntityInitializer;
import com.shyslav.mysql.DBStorage;
import com.shyslav.mysql.connectionpool.ConnectionPool;
import com.shyslav.mysql.exceptions.DBException;
import com.shyslav.mysql.interfaces.DBEntity;

import java.util.ArrayList;

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
     * Delete order and order details by id
     *
     * @param id entity id
     * @throws DBException
     */
    @Override
    public void deleteByID(int id) throws DBException {
        orderDetailsStorage.deleteByOrderID(id);
        super.deleteByID(id);
    }

    /**
     * Get order list for cook
     *
     * @return order list for cook
     * @throws DBException
     */
    public OrderList getOrdersForCook() throws DBException {
        ArrayList<DBEntity> complite = entityInitializer.select.where("complite", false).execute();
        OrderList list = new OrderList();
        for (DBEntity dbEntity : complite) {
            list.add((Order) dbEntity);
        }
        return list;
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

    /**
     * Save order with details
     *
     * @param order order entity
     * @throws DBException
     */
    public void saveOrderWithDetails(Order order) throws DBException {
        long newID = saveAndGetLastInsertID(order);
        for (OrderDetails details : order.getOrderDetails()) {
            details.setOrderId((int) newID);
            orderDetailsStorage.save(details);
        }
    }
}
