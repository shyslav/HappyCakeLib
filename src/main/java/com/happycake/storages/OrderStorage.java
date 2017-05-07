package com.happycake.storages;

import com.happycake.sitemodels.*;
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
    private final DishStorage dishStorage;

    public OrderStorage(ConnectionPool pool, OrderDetailsStorage orderDetailsStorage, DishStorage dishStorage) throws DBException {
        super(pool, Order.class);
        this.orderDetailsStorage = orderDetailsStorage;
        this.dishStorage = dishStorage;
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
     * Check need to cook
     *
     * @param order order
     * @return true if need
     */
    public boolean isNeedCookOrder(Order order) throws DBException {
        //get dishes list
        ArrayList<DBEntity> dishes = dishStorage.getAll();
        DishesList list = new DishesList();
        for (DBEntity dish : dishes) {
            list.add((Dish) dish);
        }
        //check dishes in order
        for (OrderDetails orderDetails : order.getOrderDetails()) {
            if (list.getByID(orderDetails.getDishID()).isNeedCook()) {
                return true;
            }
        }
        return false;
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
        return load(list);
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
