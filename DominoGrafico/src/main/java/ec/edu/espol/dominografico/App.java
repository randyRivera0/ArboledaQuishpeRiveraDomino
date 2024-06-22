package ec.edu.espol.dominografico;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import modelo.*;

/**
 * JavaFX App
 */

public class App extends Application {
   
    @Override
    public void start(Stage stage) throws IOException {
        Juego juego = new Juego();
        Jugador jugador1 = new Jugador("Usted");
        JugadorMaquina maquina = new JugadorMaquina();
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(maquina);
        juego.setJugadores(jugadores);
        PrimaryController primaryController = new PrimaryController(juego);
        
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
        loader.setController(primaryController);
        Parent root = loader.load();
   
        root.setStyle("-fx-background-image: url('img/91657.jpg'); -fx-background-size: cover;");
        

        Scene scene = new Scene(root);
        
        //scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setTitle("Domino");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }


    public static void main(String[] args) { 
        launch();
    }
}

