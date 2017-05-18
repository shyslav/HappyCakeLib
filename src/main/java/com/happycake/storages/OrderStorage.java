package com.happycake.storages;

import appmodels.GraphReport;
import appmodels.GraphReportList;
import appmodels.IMTData;
import appmodels.IMTDataList;
import com.happycake.sitemodels.*;
import com.shyslav.mysql.DBStorage;
import com.shyslav.mysql.connectionpool.ConnectionPool;
import com.shyslav.mysql.connectionpool.MysqlConnection;
import com.shyslav.mysql.exceptions.DBException;
import com.shyslav.mysql.interfaces.DBEntity;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
     * Get pie chart for period
     *
     * @param startTime start time
     * @param endTime   end time
     * @return ArrayList of data to chart
     * @throws DBException
     */
    public GraphReportList getSalesForPeriod(int startTime, int endTime) throws DBException {
        GraphReportList result = new GraphReportList();
        try (MysqlConnection session = entityInitializer.getConnectionPool().getConnection()) {
            String query = "select d.id,d.name,sum(od.amount) as count \n" +
                    "from orderdetails od \n" +
                    "inner join dish d on od.id_dish = d.id \n" +
                    "inner join orders o on o.id = od.id_order \n" +
                    "where o.date >= ? and o.date <= ? \n" +
                    "GROUP by d.id";
            PreparedStatement statement = session.createPrepareStatement(query);
            statement.setInt(1, startTime);
            statement.setInt(2, endTime);
            ResultSet resultSet = session.exectutePrepareStatement();
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                int amount = resultSet.getInt(3);
                GraphReport report = new GraphReport(name, amount);
                result.add(report);
            }
        } catch (SQLException e) {
            throw new DBException("Unable to generate pie chart array", e);
        }
        return result;
    }

    /**
     * Get sales for period group by date
     *
     * @param startTime start time
     * @param endTime   end time
     * @return ArrayList of data to chart
     * @throws DBException
     */
    public GraphReportList getDateSalesForPeriod(int startTime, int endTime) throws DBException {
        GraphReportList result = new GraphReportList();
        try (MysqlConnection session = entityInitializer.getConnectionPool().getConnection()) {
            String query = "SELECT DATE(FROM_UNIXTIME(date)) as order_date, sum(orderdetails.amount) as amount from orders\n" +
                    "inner join orderdetails on orders.id = orderdetails.id_order\n" +
                    "where orders.date >= ? and orders.date <= ? \n" +
                    "GROUP by order_date";
            PreparedStatement statement = session.createPrepareStatement(query);
            statement.setInt(1, startTime);
            statement.setInt(2, endTime);
            ResultSet resultSet = session.exectutePrepareStatement();
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                int amount = resultSet.getInt(2);
                GraphReport report = new GraphReport(name, amount);
                result.add(report);
            }
        } catch (SQLException e) {
            throw new DBException("Unable to generate pie chart array", e);
        }
        return result;
    }

    /**
     * Get list of data for IMT algorithm
     *
     * @return list of data for IMT algorithm
     * @throws DBException
     */
    public IMTDataList getIMTDataList() throws DBException {
        IMTDataList result = new IMTDataList();
        try (MysqlConnection session = entityInitializer.getConnectionPool().getConnection()) {
            String query =
                    "select DATE(FROM_UNIXTIME(orders.date)) as unixdate,orderdetails.id_dish, sum(orderdetails.amount) count\n" +
                            "from orders \n" +
                            "join orderdetails on orders.id=orderdetails.id_order\n" +
                            "group by unixdate, orderdetails.id_dish";
            ResultSet resultSet = session.executeSQLQuery(query);
            while (resultSet.next()) {
                Date date = resultSet.getDate(1);
                int dishID = resultSet.getInt(2);
                int count = resultSet.getInt(3);
                IMTData imtData = new IMTData((int) (date.getTime() / 1000), dishID, count);
                result.add(imtData);
            }
        } catch (SQLException e) {
            throw new DBException("Unable to data for imt algorithm", e);
        }
        return result;

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
