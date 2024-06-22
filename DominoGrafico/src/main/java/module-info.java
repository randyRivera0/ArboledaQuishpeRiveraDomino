module ec.edu.espol.dominografico {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.dominografico to javafx.fxml;
    exports ec.edu.espol.dominografico;
}
