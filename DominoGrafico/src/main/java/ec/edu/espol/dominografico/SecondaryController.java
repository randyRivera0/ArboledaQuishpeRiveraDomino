package ec.edu.espol.dominografico;

import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Ficha;
import modelo.IllegalLadoException;
import modelo.IllegalPosicionException;
import modelo.Juego;
import modelo.Jugador;

public class SecondaryController {    
    @FXML
    private TextField textFieldPosicion, textFieldLado1, textFieldLado2;
    

    public void openNewWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("secondary.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            
            stage.setTitle("Valores de Ficha Comodin");
            stage.setScene(new Scene(root));

            // Set the stage as a modal dialog on the application's primary stage
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @FXML
    private void closeButton(Event event){
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        s.close();
    }
    
    
    @FXML
    public void getValoresFichaComodinXVista(MouseEvent event){
        try{
            int lado1 = Integer.parseInt(textFieldLado1.getText());
            int lado2 = Integer.parseInt(textFieldLado2.getText());
            Ficha f = new Ficha(lado1, lado2);
            Jugador.staticFicha = f;
            String posicion = textFieldPosicion.getText();
            Juego.validarPosicion(posicion);
            closeButton((Event) event);
        
        }catch(NumberFormatException e){
            Alert a = new Alert(Alert.AlertType.WARNING, "Ingresa un valor adecuador.");
            a.showAndWait();
        }
        catch(IllegalLadoException | IllegalPosicionException e){
            Alert a = new Alert(Alert.AlertType.WARNING, e.getMessage());
            a.showAndWait();
        }
        catch(IllegalArgumentException | NullPointerException e){
            Alert a = new Alert(Alert.AlertType.WARNING, e.getMessage());
            a.showAndWait();
        }
        catch(Exception e){
            Alert a = new Alert(Alert.AlertType.WARNING);
            System.out.println(e.getMessage());
            a.showAndWait();
        }
    }
}