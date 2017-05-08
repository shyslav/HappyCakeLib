package com.happycake.sitemodels;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Shyshkin Vladyslav
 */
public class EmployeesList extends ArrayList<Employees> {
    private static HashMap<String, Integer> selectableMap = new HashMap<>();
    private HashMap<Integer, Employees> map = new HashMap<>();

    @Override
    public boolean add(Employees employees) {
        selectableMap.put(employees.getName(), employees.getId());
        map.put(employees.getId(), employees);
        return super.add(employees);
    }

    /**
     * Get News by id
     *
     * @param id category id
     * @return category by id
     */
    public Employees getByID(int id) {
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
