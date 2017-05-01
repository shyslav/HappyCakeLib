package com.happycake.sitemodels;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Shyshkin Vladyslav
 */
public class OrderList extends ArrayList<Order> {
    private HashMap<Integer, Order> map = new HashMap<>();

    @Override
    public boolean add(Order details) {
        map.put(details.getId(), details);
        return super.add(details);
    }

    /**
     * Get News by id
     *
     * @param id category id
     * @return category by id
     */
    public Order getByID(int id) {
        return map.get(id);
    }
}
