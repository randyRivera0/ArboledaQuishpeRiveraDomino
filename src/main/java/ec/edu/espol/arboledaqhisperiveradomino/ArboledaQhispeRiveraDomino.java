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
    
    public static void turno(Jugador jugador, Juego juego, Scanner sc){
        System.out.print("Jugador " + jugador.getNombre() + ": Mano -> ");
        jugador.imprimirMano();
        System.out.print("Linea de Juego: ");
        juego.mostrarLinea();
        jugador.posibilidades = 0;
        jugador.posibilidades(juego);
        System.out.println("Posibilidades: " + jugador.posibilidades);          
        System.out.print("Indice de ficha para jugar (0 es el primero): ");
        int indice = sc.nextInt();
        boolean valido = false;
        if (indice < jugador.manoJugador.size()){
            valido = juego.agregarFichaLinea(jugador.getFicha(indice), jugador);
        }
        if (valido) System.out.println("Movimiento Valido");
        else System.out.println("Movimiento No Valido");
        System.out.print("Nueva Linea de Juego: ");
        juego.mostrarLinea();
            
            
    }
    
    public static void modo2(Juego juego, Scanner sc){
        System.out.print("Ingrese el nombre del jugador 1: ");
        String nombrej1 = sc.next();
        juego.setJugadores(nombrej1);
        System.out.print("Ingrese el nombre del jugador 2: ");
        String nombrej2 = sc.next();
        juego.setJugadores(nombrej2);
        
        Jugador jugador1 = juego.getJugadores().get(0);
        Jugador jugador2 = juego.getJugadores().get(1);
        
        /*
        
        
        */
        jugador1.posibilidades = 6;
        jugador2.posibilidades = 6;
        while(!jugador1.manoJugador.isEmpty()&&!jugador2.manoJugador.isEmpty()&&(!((jugador1.posibilidades==0)&&(jugador2.posibilidades==0)))){
            turno(jugador1, juego, sc);
            turno(jugador2, juego, sc);
        }
    }
    
    public static void main(String[] args) {
        
        // implementar menu y automatico
        
        Scanner sc = new Scanner(System.in);
        Juego juego = new Juego();
        sc.useDelimiter("\n");
        
        System.out.print("1 Jugador o 2 Jugadores (Escriba 1 o 2): ");
        int modo = sc.nextInt();
        
        while(!(modo==1 || modo==2)){
            System.out.print("Opcion no valida. 1 Jugador o 2 Jugadores (Escriba 1 o 2): ");
            modo = sc.nextInt();
        }
        
        if(modo==1){
        
            }
        
        else if (modo==2){
            ArboledaQhispeRiveraDomino.modo2(juego, sc);
        }
                
    }
}
