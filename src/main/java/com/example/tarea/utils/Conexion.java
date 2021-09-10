package com.example.tarea.utils;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String dataBase = "tareasUMG";
    public static String host = "database-1.cdrjlvrnxttv.us-east-2.rds.amazonaws.com";
    public static String user = "admin";
    public static String password = "12345678";

    public static String url = "jdbc:mysql://"+host+"/"+dataBase+"?autoReconnect=true&useSSL=false"; //connection ssl false
    //private static Connection conn;
    private static java.sql.Connection conn = null;
    //Constructor
    public Conexion(){

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            //System.out.println(conn != null? "Data base is connected": "Data base is not connected");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Internal Error: "+e.getMessage());
        }
    }

    public java.sql.Connection getConnection(){
        return conn;
    }
}
