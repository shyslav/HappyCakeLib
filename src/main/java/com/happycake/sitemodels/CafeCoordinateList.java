package com.happycake.sitemodels;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Shyshkin Vladyslav
 */
public class CafeCoordinateList extends ArrayList<CafeCoordinate> {
    private static HashMap<String, Integer> selectableMap = new HashMap<>();
    private HashMap<Integer, CafeCoordinate> map = new HashMap<>();

    @Override
    public boolean add(CafeCoordinate cafeCoordinate) {
        selectableMap.put(cafeCoordinate.getAddress(), cafeCoordinate.getId());
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
