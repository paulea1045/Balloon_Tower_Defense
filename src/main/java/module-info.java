module com.example.tower_defense {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires eu.hansolo.tilesfx;

    opens com.example.tower_defense to javafx.fxml;
    exports com.example.tower_defense;
}