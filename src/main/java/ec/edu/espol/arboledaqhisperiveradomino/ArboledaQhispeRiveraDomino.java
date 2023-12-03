/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.arboledaqhisperiveradomino;

import java.util.Scanner;

/**
 *
 * @author spupi
 */
public class ArboledaQhispeRiveraDomino {
    
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
        
        jugador.posibilidades = 6;
        maquina.posibilidades = 6;

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

        jugador1.posibilidades = 6;
        jugador2.posibilidades = 6;
        
        while(!jugador1.manoJugador.isEmpty()&&!jugador2.manoJugador.isEmpty()&&(!((jugador1.posibilidades==0)&&(jugador2.posibilidades==0)))){
            jugador1.turno(juego, sc);
            jugador2.turno(juego, sc);
        }
        
        ganador(jugador1, jugador2);
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        Juego juego = new Juego();
        
        
        System.out.print("1 Jugador o 2 Jugadores (Escriba 1 o 2): ");
        String modo = sc.next();
        
        while(!(modo.equals("1") || modo.equals("2"))){
            System.out.print("Opcion no valida. 1 Jugador o 2 Jugadores (Escriba 1 o 2): ");
            modo = sc.next();
        }
        
        if(modo.equals("1")){
            ArboledaQhispeRiveraDomino.modo1(juego, sc);
            }
        
        else if (modo.equals("2")){
            ArboledaQhispeRiveraDomino.modo2(juego, sc);
        }
                
    }
}
