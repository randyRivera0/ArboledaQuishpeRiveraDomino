/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.arboledaqhisperiveradomino;

import java.util.ArrayList;

/**
 *
 * @author spupi
 */
class Jugador {
    String nombre;
    ArrayList<Ficha> manoJugador;
    
    public Jugador(){}
    
    public Jugador(String nombre, ArrayList<Ficha> manoJugador){
        this.nombre = nombre;
        this.manoJugador = manoJugador;
    }
    
    public Ficha getFicha(int indice){
        if (indice < manoJugador.size()){
            return manoJugador.get(indice);
        }
        else return null;
    }
    
    public void removerFicha(Ficha f){
        if (manoJugador.contains(f)){
            manoJugador.remove(f);
        }
    }

    public String getNombre() {
        return nombre;
    }
    
    public void imprimirMano(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < manoJugador.size()-1; i++ ){
            Ficha f = manoJugador.get(i);
            sb.append(f.getlado1()).append(":").append(f.getLado2());
        }
        System.out.println(sb.toString());
    }
}
