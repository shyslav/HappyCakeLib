package com.happycake.sitemodels;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Shyshkin Vladyslav
 */
public class CategoriesList extends ArrayList<Category> {
    private HashMap<Integer, Category> map = new HashMap<>();

    @Override
    public boolean add(Category category) {
        map.put(category.getId(), category);
        return super.add(category);
    }

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
}
