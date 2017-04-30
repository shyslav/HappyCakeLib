package com.happycake.sitemodels;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Shyshkin Vladyslav
 */
public class HotPriceList extends ArrayList<HotPrice> {
    private HashMap<Integer, HotPrice> map = new HashMap<>();

    @Override
    public boolean add(HotPrice hotPrice) {
        map.put(hotPrice.getId(), hotPrice);
        return super.add(hotPrice);
    }

    /**
     * Get Dish by id
     *
     * @param id category id
     * @return category by id
     */
    public HotPrice getByID(int id) {
        return map.get(id);
    }


    /**
     * Get hot price by dish id
     *
     * @param id dish id
     * @return hot price
     */
    public HotPrice getByDishID(int id) {
        for (HotPrice hotPrice : this) {
            if (hotPrice.getDishId() == id) {
                return hotPrice;
            }
        }
        return null;
    }
}
