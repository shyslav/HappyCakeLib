package com.happycake.sitemodels;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Shyshkin Vladyslav
 */
public class PreOrderList extends ArrayList<PreOrder> {
    private HashMap<Integer, PreOrder> map = new HashMap<>();

    @Override
    public boolean add(PreOrder preOrder) {
        map.put(preOrder.getId(), preOrder);
        return super.add(preOrder);
    }

    /**
     * Get preorder by id
     *
     * @param id category id
     * @return category by id
     */
    public PreOrder getByID(int id) {
        return map.get(id);
    }

    /**
     * Get all preorders for order
     *
     * @param id order id
     * @return preorder list
     */
    public PreOrderList getByOrderID(int id) {
        PreOrderList list = new PreOrderList();
        for (PreOrder preOrder : this) {
            if (preOrder.getReservationID() == id) {
                list.add(preOrder);
            }
        }
        return list;
    }
}
