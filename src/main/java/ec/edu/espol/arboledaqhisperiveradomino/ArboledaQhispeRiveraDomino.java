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
        System.out.print("Jugador0: Mano -> ");
            jugador.imprimirMano();
            System.out.print("Linea de Juego: ");
            juego.mostrarLinea();
            System.out.print("Indice de ficha para jugar (0 es el primero): ");
            int indice = sc.nextInt();
            boolean valido = juego.agregarFichaLinea(jugador.getFicha(indice), jugador);
            if (valido) System.out.println("Movimiento Valido");
            else System.out.println("Movimiento No Valido");
            System.out.print("Nueva Linea de Juego: ");
            juego.mostrarLinea();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Juego juego = new Juego();
        sc.useDelimiter("\n");
        System.out.println("Ingrese el nombre del jugador 1: ");
        String nombrej1 = sc.next();
        juego.setJugadores(nombrej1);
        System.out.println("Ingrese el nombre del jugador 2: ");
        String nombrej2 = sc.next();
        juego.setJugadores(nombrej2);
        
        Jugador jugador1 = juego.getJugadores().get(0);
        Jugador jugador2 = juego.getJugadores().get(1);
        
       
        
        while(!jugador1.manoJugador.isEmpty()&&!jugador2.manoJugador.isEmpty()){
            turno(jugador1, juego, sc);
            turno(jugador2, juego, sc);
        }
    }
}
