/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author spupi
 */
public class Juego {
    public static ArrayList<Jugador> jugadores;
    public static ArrayList<Ficha> lineaJuego;

    
    public Juego() {
        Juego.jugadores = new ArrayList<>();
        Juego.lineaJuego = new ArrayList<>();
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        Juego.jugadores = jugadores;
    }
    
    public static ArrayList<Ficha> getLineaJuego() {
        return lineaJuego;
    }
        
    public static int obtenerValorInicioLinea(){
        return lineaJuego.get(0).getLado1();
    }
    
    public static int obtenerValorFinLinea(){
        return lineaJuego.get(lineaJuego.size()-1).getLado2();
    }
    
    public static void validarPosicion(String posicion){
        if(posicion.equals("Inicio") || posicion.equals("Fin")){
            Jugador.posicion = posicion;
        }
        else{
            throw new IllegalPosicionException();
        }
    }
}
