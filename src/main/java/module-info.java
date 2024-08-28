module com.example.tablename {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.tablename to javafx.fxml;
    exports com.example.tablename;
}