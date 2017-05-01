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
}
