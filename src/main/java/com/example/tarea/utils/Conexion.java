package com.example.tarea.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;


public class Conexion {

    private static java.sql.Connection conn = null;
    public Conexion() throws IOException {

        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String appConfigPath = rootPath + "local.properties";

        Properties props = new Properties();
        props.load(new FileInputStream(appConfigPath));

        String database = props.getProperty("connection.db");
        String host = props.getProperty("connection.db.host");
        String user = props.getProperty("connection.db.user");
        String password = props.getProperty("connection.db.password");
        String url = "jdbc:mysql://" +
                host+
                ":" +
                props.getProperty("connection.db.port")+
                "/"+ database;
        try {
            Class.forName(props.getProperty("connection.db.driver"));
            conn = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Internal Error: "+e.getMessage());
        }
    }

    public Connection getConnection(){
        return conn;
    }
}
