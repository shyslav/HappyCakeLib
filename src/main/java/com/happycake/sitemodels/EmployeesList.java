package com.happycake.sitemodels;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Shyshkin Vladyslav
 */
public class EmployeesList extends ArrayList<Employees> {
    private HashMap<Integer, Employees> map = new HashMap<>();

    @Override
    public boolean add(Employees employees) {
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
}
