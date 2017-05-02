package com.happycake.sitemodels;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Shyshkin Vladyslav
 */
public class PositionsList extends ArrayList<Position> {
    private HashMap<Integer, Position> map = new HashMap<>();

    @Override
    public boolean add(Position position) {
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
