/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import ec.edu.espol.dominografico.SecondaryController;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.control.Alert;

/**
 *
 * @author spupi
 */
public class Jugador {
    public String nombre;
    public ArrayList<Ficha> manoJugador;
    public int posibilidades = 0; 
    public static Ficha staticFicha;
    public static String posicion;
    
    public static ArrayList<Ficha> crearManoJugador(){
        ArrayList<Ficha> mano = new ArrayList<>();
        // i<5 hace 6 fichas
        for(int i=0; i<5; i++){
            Random r = new Random();
            int lado1 = r.nextInt(6) + 1 ;
            int lado2 = r.nextInt(6) + 1;
            Ficha f = new Ficha(lado1, lado2);
            mano.add(f);
        }
        mano.add(new FichaComodin());
        return mano;
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.manoJugador = Jugador.crearManoJugador();
    }
    

    public int posibilidades(){
        posibilidades = 0;
        if(Juego.lineaJuego.isEmpty()) return manoJugador.size();
        else{
            for(Ficha f: manoJugador){
                if(f instanceof FichaComodin){
                    posibilidades +=1;
                }
                else if (f.getLado1() == Juego.obtenerValorFinLinea() || f.getLado2() == Juego.obtenerValorInicioLinea()){
                    posibilidades +=1;
                }
            }
        }
        return posibilidades;
    }
    
    public void removerFicha(Ficha f){
        if(manoJugador.contains(f)){
            manoJugador.remove(f);
        }
    }
 
    public void agregarFichaLinea(SecondaryController secondaryController, Ficha f) {
    ArrayList<Ficha> lineaJuegoModelo = Juego.lineaJuego;

        if (f instanceof FichaComodin) {
            secondaryController.openNewWindow();
            Ficha fComodin = staticFicha;

            if (fComodin != null) {
                if (lineaJuegoModelo.isEmpty()) {
                    agregarFichaComodin(lineaJuegoModelo, fComodin, f);
                } else {
                    switch (posicion) {
                        case "Inicio":
                            agregarFichaComodinInicio(lineaJuegoModelo, fComodin, f);
                            break;
                        case "Fin":
                            agregarFichaComodinFin(lineaJuegoModelo, fComodin, f);
                            break;
                    }
                }
            }
        } else {
            if (lineaJuegoModelo.isEmpty()) {
                agregarFicha(lineaJuegoModelo, f);
            } else {
                if (canAddToStart(lineaJuegoModelo, f)) {
                    agregarFichaInicio(lineaJuegoModelo, f);
                } else if (canAddToEnd(lineaJuegoModelo, f)) {
                    agregarFichaFin(lineaJuegoModelo, f);
                } else {
                    showAlert("Ficha tenía " + f + ". No puede jugar esa ficha, inténtelo de nuevo");
                }
            }
        }
    }

    private void agregarFichaComodin(ArrayList<Ficha> lineaJuegoModelo, Ficha fComodin, Ficha f) {
        lineaJuegoModelo.add(fComodin);
        removerFicha(f);
    }

    private void agregarFichaComodinInicio(ArrayList<Ficha> lineaJuegoModelo, Ficha fComodin, Ficha f) {
        int lado2 = lineaJuegoModelo.get(0).getLado1();
        fComodin.setLado2(lado2);
        lineaJuegoModelo.add(0, fComodin);
        removerFicha(f);
    }

    private void agregarFichaComodinFin(ArrayList<Ficha> lineaJuegoModelo, Ficha fComodin, Ficha f) {
        int lado1 = lineaJuegoModelo.get(lineaJuegoModelo.size() - 1).getLado2();
        fComodin.setLado1(lado1);
        lineaJuegoModelo.add(fComodin);
        removerFicha(f);
    }

    private void agregarFicha(ArrayList<Ficha> lineaJuegoModelo, Ficha f) {
        lineaJuegoModelo.add(f);
        removerFicha(f);
    }

    private void agregarFichaInicio(ArrayList<Ficha> lineaJuegoModelo, Ficha f) {
        lineaJuegoModelo.add(0, f);
        removerFicha(f);
    }

    private void agregarFichaFin(ArrayList<Ficha> lineaJuegoModelo, Ficha f) {
        lineaJuegoModelo.add(f);
        removerFicha(f);
    }

    private boolean canAddToStart(ArrayList<Ficha> lineaJuegoModelo, Ficha f) {
        return lineaJuegoModelo.get(0).getLado1() == f.getLado2();
    }

    private boolean canAddToEnd(ArrayList<Ficha> lineaJuegoModelo, Ficha f) {
        return lineaJuegoModelo.get(lineaJuegoModelo.size() - 1).getLado2() == f.getLado1();
    }

    private void showAlert(String message) {
        Alert a = new Alert(Alert.AlertType.WARNING, message);
        a.showAndWait();
    }

}