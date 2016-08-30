package database.select;


import database.configuration.DatabaseConnection;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import sitemodels.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectCommand {
    private static final Logger log = Logger.getLogger(SelectCommand.class.getName());

    private static DatabaseConnection db = new DatabaseConnection();

    /**
     * Action to get web menu from database
     *
     * @return web menu arraylist
     * @
     */
    protected ArrayList<WebMenu> selectWebMenu() {
        log.info("try to select webmenu");
        ArrayList<WebMenu> result = new ArrayList();
        String query = "select * from webmenu order by menusort";
        db.openConnection();
        try {
            db.rs = db.st.executeQuery(query);
            while (db.rs.next()) {
                result.add(new WebMenu(
                        db.rs.getInt("id"),
                        db.rs.getString("name"),
                        db.rs.getString("link"),
                        db.rs.getInt("menusort")));
            }
        } catch (SQLException ex) {
            log.error("execute query error" + ex);
        } finally {
            db.closeConnection();
        }
        return result;
    }

    /**
     * action to get max id from reservation
     *
     * @return max id
     */
    public static int selectMaxFromReservation() {
        log.info("try to select max from reservation");
        String query = "select max(id) from reservation";
        db.openConnection();
        int max = 1;
        try {
            db.rs = db.st.executeQuery(query);
            while (db.rs.next()) {
                max = db.rs.getInt(1);
            }
        } catch (SQLException ex) {
            log.error("execute query error" + ex);
        } finally {
            db.closeConnection();
        }
        return max;
    }

    /**
     * Action to get all cafe coordination from database
     *
     * @return arraylist of cafe coordinate
     * @
     */
    protected ArrayList<CafeCoordinate> selectCafeCoordinate() {
        log.info("try to select cafe coordinate");
        ArrayList<CafeCoordinate> result = new ArrayList();
        String query = "select * from cafecoordinate";
        db.openConnection();
        try {
            db.rs = db.st.executeQuery(query);
            while (db.rs.next()) {
                result.add(new CafeCoordinate(
                        db.rs.getInt("id"),
                        db.rs.getString("adress"),
                        db.rs.getString("mobilePhone"),
                        db.rs.getString("cafeemail")));
            }
        } catch (SQLException ex) {
            log.error("execute query error" + ex);
        } finally {
            db.closeConnection();
        }
        return result;
    }

    /**
     * Action to get all cafe categories from database
     *
     * @return arraylist of categories
     * @
     */
    protected ArrayList<Category> selectCategory() {
        log.info("try to select ALL category");
        ArrayList<Category> result = new ArrayList();
        String query = "select * from category";
        db.openConnection();
        try {
            db.rs = db.st.executeQuery(query);
            while (db.rs.next()) {
                result.add(new Category(
                        db.rs.getInt("id"),
                        db.rs.getString("name"),
                        db.rs.getString("description"),
                        IOUtils.toByteArray(db.rs.getBinaryStream("image"))));
            }
        } catch (IOException | SQLException ex) {
            log.error("execute query error" + ex);
        } finally {
            db.closeConnection();
        }
        return result;
    }

    /**
     * Action to get dish from database
     *
     * @return array list of dish
     */
    protected ArrayList<Dish> selectdish() {
        log.info("try to select ALL dish");
        ArrayList<Dish> result = new ArrayList();
        String query = "select id as idfromdish, categoryID, name, description, amount, price, image, readyORnot, (select percent from hotprice where dishID = idfromdish and dateEnd>=curdate() ) as sell from dish";
        db.openConnection();
        try {
            db.rs = db.st.executeQuery(query);
            while (db.rs.next()) {
                result.add(new Dish(
                        db.rs.getInt("idfromdish"),
                        db.rs.getInt("categoryID"),
                        db.rs.getString("name"),
                        db.rs.getString("description"),
                        db.rs.getInt("amount"),
                        db.rs.getDouble("price"),
                        IOUtils.toByteArray(db.rs.getBinaryStream("image")),
                        db.rs.getString("readyORnot").trim(),
                        db.rs.getString("sell")));
            }
        } catch (IOException | SQLException ex) {
            log.error("execute query error" + ex);
        } finally {
            db.closeConnection();
        }
        return result;
    }

    /**
     * Action to get all site news from database
     *
     * @return arraylist of news
     * @
     */
    protected ArrayList<News> selectNews() {
        log.info("try to select ALL news");
        ArrayList<News> result = new ArrayList();
        String query = "select * from news";
        db.openConnection();
        try {
            db.rs = db.st.executeQuery(query);
            while (db.rs.next()) {
                result.add(new News(
                        db.rs.getInt("id"),
                        db.rs.getInt("authorID"),
                        db.rs.getString("name"),
                        db.rs.getString("nText"),
                        db.rs.getDate("nDate"),
                        db.rs.getString("tegs"),
                        db.rs.getInt("views"),
                        db.rs.getString("imageLink")));
            }
        } catch (SQLException ex) {
            log.error("execute query error" + ex);
        } finally {
            db.closeConnection();
        }
        return result;
    }

    /**
     * Action to get reports from database
     *
     * @return arraylist of reports
     * @
     */
    protected ArrayList<Reports> selectReports() {
        log.info("try to select ALL reports");
        ArrayList<Reports> result = new ArrayList();
        String query = "select * from reports where vision = '+'";
        db.openConnection();
        try {
            db.rs = db.st.executeQuery(query);
            while (db.rs.next()) {
                result.add(new Reports(db.rs.getInt("id"),
                        db.rs.getString("author"),
                        db.rs.getString("rText"),
                        db.rs.getDate("rDate"),
                        db.rs.getString("mail"),
                        db.rs.getString("phone"),
                        db.rs.getString("vision")));
            }
        } catch (SQLException ex) {
            log.error("execute query error" + ex);
        } finally {
            db.closeConnection();
        }
        return result;
    }

    /**
     * Action to get hotprices from database
     *
     * @return arraylist of hotprice
     * @
     */
    protected ArrayList<HotPrice> selectHotPrice() {
        log.info("try to select ALL hotprice");
        ArrayList<HotPrice> result = new ArrayList();
        String query = "select * from hotprice order by  dateStart desc, dateEnd DESC";
        db.openConnection();
        try {
            db.rs = db.st.executeQuery(query);
            while (db.rs.next()) {
                result.add(new HotPrice(db.rs.getInt("id"),
                        db.rs.getInt("dishId"),
                        db.rs.getInt("percent"),
                        db.rs.getString("description"),
                        db.rs.getDate("dateStart"),
                        db.rs.getDate("dateEnd")));
            }
        } catch (SQLException ex) {
            log.error("execute query error" + ex);
        } finally {
            db.closeConnection();
        }
        return result;
    }
}
