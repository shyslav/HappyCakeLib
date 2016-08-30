package sitestorages;


import org.apache.log4j.Logger;
import sitemodels.Dish;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Shyshkin Vladyslav on 18.08.2016.
 */
public class DishStorage extends ArrayList<Dish> {
    private static final Logger log = Logger.getLogger(DishStorage.class.getName());

    private HashMap<Integer,Dish> map = new HashMap();

    @Override
    public boolean add(Dish dish) {
        map.put(dish.getId(),dish);
        return super.add(dish);
    }
    /**
     * Get all Dish by Category id
     *
     * @param id Category id
     * @return Dish list
     */
    public ArrayList<Dish> getByCategoryId(int id) {
        log.info("get dish by category id = " + id);
        ArrayList<Dish> result = new ArrayList();
        for (Dish elements : this) {
            if (elements.getCategoryId() == id) {
                result.add(elements);
            }
        }
        return result;
    }

    /**
     * Get arrayelement by id
     * @param id _Category id
     * @return _Category object
     */
    public Dish getById(int id){
        return map.get(id);
    }
}
