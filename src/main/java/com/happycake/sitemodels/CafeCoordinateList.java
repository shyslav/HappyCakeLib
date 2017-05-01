package com.happycake.sitemodels;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Shyshkin Vladyslav
 */
public class CafeCoordinateList extends ArrayList<CafeCoordinate> {
    private HashMap<Integer, CafeCoordinate> map = new HashMap<>();

    @Override
    public boolean add(CafeCoordinate cafeCoordinate) {
        map.put(cafeCoordinate.getId(), cafeCoordinate);
        return super.add(cafeCoordinate);
    }

    /**
     * Get News by id
     *
     * @param id category id
     * @return category by id
     */
    public CafeCoordinate getByID(int id) {
        return map.get(id);
    }
}
