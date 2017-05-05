package com.happycake;

import com.happycake.storages.*;
import com.shyslav.mysql.connectionpool.ConnectionPool;
import com.shyslav.mysql.driver.DBSpringDriver;
import com.shyslav.mysql.exceptions.DBException;
import com.shyslav.springapp.ApplicationSpringContext;
import com.shyslav.springapp.SpringApplicationException;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

/**
 * @author Shyshkin Vladyslav on 29.04.17.
 */
public class HappyCakeStorage {
    private static final Logger log = Logger.getLogger(HappyCakeStorage.class.getName());
    /**
     * Database connection pool
     */
    private ConnectionPool pool;
    /**
     * Web menu storage
     */
    public WebMenuStorage webMenuStorage;
    /**
     * Hot price storage
     */
    public HotPriceStorage hotPriceStorage;
    /**
     * Category storage
     */
    public CategoryStorage categoryStorage;
    /**
     * Dish storage
     */
    public DishStorage dishStorage;
    /**
     * Storage of cafe coordinate
     */
    public CafeCoordinateStorage cafeCoordinate;
    /**
     * Storage of news
     */
    public NewsStorage newsStorage;
    /**
     * Reservation storage
     */
    public ReservationStorage reservationStorage;
    /**
     * pre order storage
     */
    public PreOrderStorage preOrderStorage;
    /**
     * Reports storage
     */
    public ReportsStorage reportsStorage;

    /**
     * Employees storage
     */
    public EmployeesStorage employeesStorage;

    /**
     * Positions storage
     */
    public PositionStorage positionStorage;

    /**
     * Orders storage
     */
    public OrderStorage orderStorage;
    public OrderDetailsStorage orderDetailsStorage;

    /**
     * Constructor
     */
    public HappyCakeStorage() {
        ApplicationContext context;
        try {
            context = ApplicationSpringContext.getFromEmbedSource("/etc/start.xml");
            DBSpringDriver driver = (DBSpringDriver) context.getBean("database_driver");
            this.pool = new ConnectionPool(driver);
            open();
        } catch (DBException | SpringApplicationException e) {
            log.trace("Unable to start db pool " + e.getMessage(), e);
            System.exit(-1);
        }
    }

    /**
     * Constructor
     */
    public HappyCakeStorage(String pathToFile) {
        ApplicationContext context;
        try {
            context = ApplicationSpringContext.getFromEmbedSource(pathToFile);
            DBSpringDriver driver = (DBSpringDriver) context.getBean("database_driver");
            this.pool = new ConnectionPool(driver);
            open();
        } catch (DBException | SpringApplicationException e) {
            log.trace("Unable to start db pool " + e.getMessage(), e);
            System.exit(-1);
        }
    }

    /**
     * Open all com.happycake.storages
     *
     * @throws DBException
     */
    public void open() throws DBException {
        this.webMenuStorage = new WebMenuStorage(pool);
        this.hotPriceStorage = new HotPriceStorage(pool);
        this.categoryStorage = new CategoryStorage(pool);
        this.dishStorage = new DishStorage(pool);
        this.cafeCoordinate = new CafeCoordinateStorage(pool);
        this.newsStorage = new NewsStorage(pool);
        this.reservationStorage = new ReservationStorage(pool);
        this.preOrderStorage = new PreOrderStorage(pool);
        this.reportsStorage = new ReportsStorage(pool);
        this.employeesStorage = new EmployeesStorage(pool);
        this.positionStorage = new PositionStorage(pool);
        this.orderDetailsStorage = new OrderDetailsStorage(pool);
        this.orderStorage = new OrderStorage(pool, orderDetailsStorage);
    }

    public ConnectionPool getPool() {
        return pool;
    }

    /**
     * Clear all storage's
     *
     * @throws DBException
     */
    public void clear() throws DBException {
        log.trace("Clear all storage's");
        webMenuStorage.clear();
        hotPriceStorage.clear();
        orderDetailsStorage.clear();
        orderStorage.clear();
        preOrderStorage.clear();
        dishStorage.clear();
        categoryStorage.clear();
        newsStorage.clear();
        reservationStorage.clear();
        reservationStorage.clear();
        employeesStorage.clear();
        positionStorage.clear();
    }
}
