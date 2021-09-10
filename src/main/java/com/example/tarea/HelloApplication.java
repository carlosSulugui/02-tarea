package com.example.tarea;

import com.example.tarea.utils.Conexion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Connection con = null;
        Conexion conexion = new Conexion();
        try {
            con = conexion.getConnection();
            String Query = "select * from empleados";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(Query);
            if (rs != null){
                while (rs.next()) {
                    System.out.println(rs.getString("Id") + " - " +
                            rs.getString("Nombre") + " - " +
                            rs.getString("Estado"));
                }
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}