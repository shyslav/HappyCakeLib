package com.happycake.sitemodels;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Shyshkin Vladyslav
 */
public class OrderDetailsList extends ArrayList<OrderDetails> {
    private HashMap<Integer, OrderDetails> map = new HashMap<>();

    @Override
    public boolean add(OrderDetails details) {
        map.put(details.getId(), details);
        return super.add(details);
    }

    /**
     * Get News by id
     *
     * @param id category id
     * @return category by id
     */
    public OrderDetails getByID(int id) {
        return map.get(id);
    }
}
