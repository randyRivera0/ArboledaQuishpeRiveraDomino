/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.arboledaqhisperiveradomino;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author spupi
 */
public class Juego {
    private ArrayList<Ficha> lineaJuego;
    private ArrayList<Jugador> Jugadores;
    
    public Juego(){
        lineaJuego = new ArrayList<>();
        Jugadores = new ArrayList<>();
    }
    
    public void agregarJugador(String nombre){
        Jugador j = new Jugador(nombre, Utilitaria.crearManoJugador());
        Jugadores.add(j);
    }
    
    public int obtenerValorInicioLinea(){
        return lineaJuego.get(0).getlado1();
    }
    
    public int obtenerValorFinLinea(){
        return lineaJuego.get(lineaJuego.size()-1).getLado2();
    }
    
    public void mostrarLinea(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < lineaJuego.size() -1; i++){
            sb.append(lineaJuego.get(i).toString()).append(" - ");
            
        sb.append(lineaJuego.get(lineaJuego.size()-1).toString());
        System.out.println(sb.toString());
        }
    }
    
    public void/*boolean*/ agregarFichaLinea(Ficha f, Jugador j){
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        if (f instanceof FichaComodin fComodin){
            if (lineaJuego.isEmpty()){
                fComodin.setLado1Scanner(sc);
                fComodin.setLado2Scanner(sc);
                lineaJuego.add(fComodin);
            }
            
            else{
                System.out.println("Ingrese la posicion donde quiere agregar la ficha");
                String posicion = sc.next();
                
                if (posicion.equals("Inicio")){
                    int lado2 = lineaJuego.get(0).getlado1();
                    fComodin
                    lineaJuego.add(0, fComodin);
                }
                else if (posicion.equals("Fin")){
                    lineaJuego.add(lineaJuego.size()-1, fComodin);
                }
                
            }           
        }
    }
}
