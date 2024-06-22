package ec.edu.espol.dominografico;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import modelo.*;

public class PrimaryController implements Initializable{
    public Jugador jugador;
    public JugadorMaquina maquina;
    public SecondaryController secondaryController;

    
    @FXML
    private HBox lineaJuego, mazoMaquina, mazoJugador;
    @FXML
    private Label labelPosibilidadesJugador;
    
    public PrimaryController(Juego juego) {
        this.jugador = Juego.jugadores.get(0);
        this.maquina = (JugadorMaquina) Juego.jugadores.get(1);
        this.secondaryController = new SecondaryController();
    }
    
 
      
    @FXML
    public void turnoJugador(PrimaryController this, MouseEvent event){
        if(event.getSource() instanceof Button){
            Button clickedButton = (Button) event.getSource();
            Ficha buttonFicha = (Ficha) clickedButton.getUserData();
            jugador.agregarFichaLinea(this.secondaryController, buttonFicha);
            visualizarLineaJugador();
            maquina.turno();
            visualizarLinea(mazoMaquina, maquina.manoJugador);
            labelPosibilidadesJugador.setText("Posibilidades: "+ jugador.posibilidades());
            visualizarLinea(lineaJuego, Juego.lineaJuego);
            if(jugador.manoJugador.isEmpty()|| maquina.manoJugador.isEmpty()||(jugador.posibilidades==0 && (maquina.posibilidades==0))){
                ganador();    
            }
        }
    }
    
    public void ganador(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Fin del Juego");
        if (jugador.manoJugador.size() < maquina.manoJugador.size()){
            a.setContentText("Ganó el jugador 2: " + jugador.nombre);
        }
        
        else if (jugador.manoJugador.size() > maquina.manoJugador.size()){
            a.setContentText("Ganó el jugador 1: " + maquina.nombre);    
        }
        
        else a.setContentText("Empate entre: " + jugador.nombre + " y " + maquina.nombre);
        a.setOnCloseRequest(event -> {
            // Close the application when the Alert is closed
            Platform.exit();
        });
        a.showAndWait();
    }
    
    
    @FXML
    public void visualizarLineaJugador(){
        mazoJugador.getChildren().clear();
        for(Ficha f : jugador.manoJugador){           
            ImageView img = new ImageView(f.getPath());
            img.setFitWidth(100);
            img.setFitHeight(100);
            img.setPickOnBounds(true);
            img.setPreserveRatio(true);
            Button b = new Button();
            b.setGraphic(img);
            b.setPadding(new Insets(0, 0, 0, 0));
            b.setUserData(f);
            b.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> turnoJugador((MouseEvent) event));
            mazoJugador.getChildren().add(b);
        }
    }
    
    
    @FXML
    public void visualizarLinea(HBox hb, ArrayList<Ficha> linea){
        hb.getChildren().clear();
        for(Ficha f : linea){
            ImageView img = new ImageView(f.getPath());
            img.setFitWidth(100);
            img.setFitHeight(100);
            img.setPickOnBounds(true);
            img.setPreserveRatio(true);
            Button b = new Button();
            b.setGraphic(img);
            b.setPadding(new Insets(0, 0, 0, 0));
            b.setUserData(f);
            hb.getChildren().add(b);
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelPosibilidadesJugador.setText("Posibilidades: "+jugador.posibilidades());
        visualizarLineaJugador();
        visualizarLinea(mazoMaquina, maquina.manoJugador);
    }
}
