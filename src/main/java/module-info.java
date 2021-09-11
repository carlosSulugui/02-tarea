module com.example.tarea {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires mysql.connector.java;

    opens com.example.tarea to javafx.fxml;
    exports com.example.tarea;
}
