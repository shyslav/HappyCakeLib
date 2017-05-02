package com.happycake.sitemodels;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Shyshkin Vladyslav
 */
public class ReportsList extends ArrayList<Reports> {
    private HashMap<Integer, Reports> map = new HashMap<>();

    @Override
    public boolean add(Reports report) {
        map.put(report.getId(), report);
        return super.add(report);
    }

    /**
     * Get report by id
     *
     * @param id category id
     * @return category by id
     */
    public Reports getByID(int id) {
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
