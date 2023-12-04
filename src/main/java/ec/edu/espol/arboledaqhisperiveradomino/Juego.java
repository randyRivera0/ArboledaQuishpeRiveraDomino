/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.arboledaqhisperiveradomino;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author spupi
 */
public class Juego {
    private ArrayList<Ficha> lineaJuego;
    private ArrayList<Jugador> jugadores;
    static int nFichasIniciales;
    
    public Juego(){
        lineaJuego = new ArrayList<>();
        jugadores = new ArrayList<>();
    }

    public int getnFichasIniciales() {
        return nFichasIniciales;
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
        if (lineaJuego.isEmpty()) System.out.println("");        
        else{
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i < lineaJuego.size() -1; i++){
            sb.append(lineaJuego.get(i).toString()).append(" - ");
            }
            sb.append(lineaJuego.get(lineaJuego.size()-1).toString());
            System.out.println(sb.toString());
        }
        
    }
    
    public static void ganador(Jugador jugador1, Jugador jugador2){
        if (jugador1.manoJugador.size() < jugador2.manoJugador.size()){
            System.out.println("Gano el jugador 1: " + jugador1.getNombre());
        }
        
        else if (jugador1.manoJugador.size() > jugador2.manoJugador.size()){
            System.out.println("Gano el jugador 2: " + jugador2.getNombre());    
        }
        
        else System.out.println("Empate entre: " + jugador1.getNombre() + " y " + jugador2.getNombre());
    
    }
    
    public static void modo1(Juego juego, Scanner sc){
        System.out.println("MODO 1");
        System.out.print("Ingrese el nombre del jugador: ");
        String nombrej = sc.next();
        Jugador jugador = new Jugador(nombrej);
        JugadorMaquina maquina = new JugadorMaquina();
        
        juego.setJugador(jugador);        
        juego.setJugador(maquina);
        
        jugador.posibilidades = nFichasIniciales;
        maquina.posibilidades = nFichasIniciales;

        while(!jugador.manoJugador.isEmpty()&&!maquina.manoJugador.isEmpty()&&(!((jugador.posibilidades==0)&&(maquina.posibilidades==0)))){
            jugador.turno(juego, sc);
            maquina.turno(juego, sc);
        }      
        
        ganador(jugador, maquina);
    }
    
    public static void modo2(Juego juego, Scanner sc){
        System.out.println("MODO 2");
        System.out.print("Ingrese el nombre del jugador 1: ");
        String nombrej1 = sc.next();
        System.out.print("Ingrese el nombre del jugador 2: ");
        String nombrej2 = sc.next();
        Jugador jugador1 = new Jugador(nombrej1);
        Jugador jugador2 = new Jugador(nombrej2);
        
        juego.setJugador(jugador1);
        juego.setJugador(jugador2);                   

        jugador1.posibilidades = nFichasIniciales;
        jugador2.posibilidades = nFichasIniciales;
        
        while(!jugador1.manoJugador.isEmpty()&&!jugador2.manoJugador.isEmpty()&&(!((jugador1.posibilidades==0)&&(jugador2.posibilidades==0)))){
            jugador1.turno(juego, sc);
            jugador2.turno(juego, sc);
        }
        
        ganador(jugador1, jugador2);
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
