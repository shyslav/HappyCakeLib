package com.happycake.sitemodels;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Shyshkin Vladyslav
 */
public class DishesList extends ArrayList<Dish> {
    private HashMap<Integer, Dish> map = new HashMap<>();

    @Override
    public boolean add(Dish dish) {
        map.put(dish.getId(), dish);
        return super.add(dish);
    }

    /**
     * Get Dish by id
     *
     * @param id category id
     * @return category by id
     */
    public Dish getByID(int id) {
        return map.get(id);
    }

    /**
     * Get all Dish by Category id
     *
     * @param id Category id
     * @return Dish list
     */
    public DishesList getByCategoryId(int id) {
        DishesList result = new DishesList();
        for (Dish elements : this) {
            if (elements.getCategoryId() == id) {
                result.add(elements);
            }
        }
        return result;
    }

    /**
     * Load discount
     */
    public void loadDiscount(HotPriceList hotPrices) {
        for (Dish dish : this) {
            HotPrice price = hotPrices.getByDishID(dish.getId());
            if (price != null) {
                dish.setDiscount(price.getPercent());
            }
        }
    }
}
