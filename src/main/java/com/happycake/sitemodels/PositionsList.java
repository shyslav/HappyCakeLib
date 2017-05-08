package com.happycake.sitemodels;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Shyshkin Vladyslav
 */
public class PositionsList extends ArrayList<Position> {
    private static HashMap<String, Integer> selectableMap = new HashMap<>();
    private HashMap<Integer, Position> map = new HashMap<>();

    /**
     * Get selectable map
     *
     * @return selectable map
     */
    public static HashMap<String, Integer> getSelectableMap() {
        return selectableMap;
    }

    @Override
    public boolean add(Position position) {
        selectableMap.put(position.getName(), position.getId());
        map.put(position.getId(), position);
        return super.add(position);
    }

    /**
     * Get News by id
     *
     * @param id category id
     * @return category by id
     */
    public Position getByID(int id) {
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
