package database.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {
    private Connection con;
    public Statement st;
    public ResultSet rs;

    /**
     * Open mysql connection and create statement
     */
    public void openConnection()
    {
        ClassLoader classLoader = getClass().getClassLoader();
        Properties props = new Properties();
        try (InputStream in = classLoader.getResourceAsStream("database/database.properties")) {
        props.load(in);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        try{
            Class.forName(props.getProperty("jdbc.drivers"));
            con = DriverManager.getConnection(props.getProperty("jdbc.url"),props.getProperty("jdbc.username"),props.getProperty("jdbc.password"));
            st = con.createStatement();
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            System.out.println("Error"+ex);
        }
    }

    /**
     * Get connection without statement
     * @return connection
     */
    public Connection getConnection(){
        ClassLoader classLoader = getClass().getClassLoader();
        Properties props = new Properties();
        try (InputStream in = classLoader.getResourceAsStream("database/database.properties")) {
            props.load(in);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        try {
            Class.forName(props.getProperty("jdbc.drivers"));
            con = DriverManager.getConnection(props.getProperty("jdbc.url"),props.getProperty("jdbc.username"),props.getProperty("jdbc.password"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void closeConnection()
    {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}