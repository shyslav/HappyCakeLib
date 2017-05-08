package com.happycake.sitemodels;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Shyshkin Vladyslav
 */
public class CategoriesList extends ArrayList<Category> {
    private static HashMap<String, Integer> selectableMap = new HashMap<>();
    private HashMap<Integer, Category> map = new HashMap<>();

    /**
     * Get category by id
     *
     * @param id category id
     * @return category by id
     */
    public Category getByID(int id) {
        return map.get(id);
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

    @Override
    public boolean add(Category category) {
        selectableMap.put(category.getName(), category.getId());
        map.put(category.getId(), category);
        return super.add(category);
    }
}
