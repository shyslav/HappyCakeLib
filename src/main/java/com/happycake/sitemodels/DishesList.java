package com.happycake.sitemodels;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Shyshkin Vladyslav
 */
public class DishesList extends ArrayList<Dish> {
    private static HashMap<String, Integer> selectableMap = new HashMap<>();
    private HashMap<Integer, Dish> map = new HashMap<>();

    @Override
    public boolean add(Dish dish) {
        selectableMap.put(dish.getName(), dish.getId());
        map.put(dish.getId(), dish);
        return super.add(dish);
    }

    /**
     * Get dish names array
     *
     * @return array of dish names
     */
    public ArrayList<String> getDishNames() {
        ArrayList<String> strings = new ArrayList<>();
        strings.addAll(selectableMap.keySet());
        return strings;
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

    /**
     * Remove element by id
     *
     * @param id id of news
     */
    public void removeById(int id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId() == id) {
                map.remove(this.get(i).getId());
                this.remove(i);
            }
        }
    }

    /**
     * Get selectable map
     *
     * @return selectable map
     */
    public static HashMap<String, Integer> getSelectableMap() {
        return selectableMap;
    }

}
