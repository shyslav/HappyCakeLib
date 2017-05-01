package com.happycake.sitemodels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Shyshkin Vladyslav
 */
public class ReservationList extends ArrayList<Reservation> {
    private HashMap<Integer, Reservation> map = new HashMap<>();

    @Override
    public boolean add(Reservation reservation) {
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
}
