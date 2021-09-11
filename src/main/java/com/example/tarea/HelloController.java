package com.example.tarea;

import com.example.tarea.utils.Conexion;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        Conexion con = new Conexion();
        con.getConnection();
    }
}
