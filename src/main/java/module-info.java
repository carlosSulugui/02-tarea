module com.example.tarea {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.tarea to javafx.fxml;
    exports com.example.tarea;
}