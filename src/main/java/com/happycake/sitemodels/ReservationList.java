package com.happycake.sitemodels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Shyshkin Vladyslav
 */
public class ReservationList extends ArrayList<Reservation> {
    private static HashMap<String, Integer> selectableMap = new HashMap<>();
    private HashMap<Integer, Reservation> map = new HashMap<>();

    @Override
    public boolean add(Reservation reservation) {
        selectableMap.put(reservation.getClientPhone() + " - " + reservation.getClientName(), reservation.getId());
        map.put(reservation.getId(), reservation);
        return super.add(reservation);
    }

    /**
     * Get News by id
     *
     * @param id category id
     * @return category by id
     */
    public Reservation getByID(int id) {
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
