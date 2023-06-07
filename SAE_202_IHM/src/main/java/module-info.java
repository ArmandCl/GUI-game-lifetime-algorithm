module com.example.sae_202_ihm {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires org.testng;
    requires org.junit.jupiter.api;

    opens com.example.sae_202_ihm to javafx.fxml;
    exports com.example.sae_202_ihm;
    exports vue;
    opens modele to javafx.base;
    opens outil to javafx.base;
}