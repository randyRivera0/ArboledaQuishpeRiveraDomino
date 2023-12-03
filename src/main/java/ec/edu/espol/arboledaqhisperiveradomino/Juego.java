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
public class Juego {
    private ArrayList<Ficha> lineaJuego;
    private ArrayList<Jugador> jugadores;
    
    public Juego(){
        lineaJuego = new ArrayList<>();
        jugadores = new ArrayList<>();
    }

    public void setLineaJuego(ArrayList<Ficha> lineaJuego) {
        this.lineaJuego = lineaJuego;
    }
    
    public void setJugador(Jugador j){
        jugadores.add(j);
    }
    

    public ArrayList<Ficha> getLineaJuego() {
        return lineaJuego;
    }      
    
    public void agregarJugador(String nombre){
        Jugador j = new Jugador(nombre, Utilitaria.crearManoJugador());
        jugadores.add(j);
    }
    
    public int obtenerValorInicioLinea(){
        return lineaJuego.get(0).getLado1();
    }
    
    public int obtenerValorFinLinea(){
        return lineaJuego.get(lineaJuego.size()-1).getLado2();
    }
    
    public void mostrarLinea(){
        
        if (!lineaJuego.isEmpty()){
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i < lineaJuego.size() -1; i++){
            sb.append(lineaJuego.get(i).toString()).append(" - ");
            }
            sb.append(lineaJuego.get(lineaJuego.size()-1).toString());
            System.out.println(sb.toString());
        }
        
    }
    
   
    
    
/*
    public void jugarMach(Jugador mach){
        System.out.println("Juega máquina: " + mach.getNombre());
        System.out.println("Mano máquina");
        mach.imprimirMano();
        
        for (int i=0;i<mach.manoJugador.size();i++){
            Ficha primera=mach.getFicha(i);
            if(agregarFichaLinea(primera, mach)){
                System.out.println("Ficha: "+ primera);
                System.out.println("Nueva línea");
                mostrarLinea();
            }
        }

        for (int i=0;i<mach.manoJugador.size();i++){
            Ficha primera=mach.getFicha(i);
            if(primera instanceof FichaComodin){
                FichaComodin fc=(FichaComodin)primera;
                if(agregarFichaLinea(fc,mach)){
                    System.out.println("Ficha comodín de la maquina:"+fc);
                    System.out.println("Nueva línea");
                    mostrarLinea();
                }
                
            }
        }    
        mach.manoJugador.add(Utilitaria.crearManoJugador().get(0));
        System.out.println("Nueva ficha de la máquina");
    } 
*/
    

}
