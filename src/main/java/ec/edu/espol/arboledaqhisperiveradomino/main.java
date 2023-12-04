/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.arboledaqhisperiveradomino;

import static ec.edu.espol.arboledaqhisperiveradomino.Juego.modo1;
import static ec.edu.espol.arboledaqhisperiveradomino.Juego.modo2;
import static ec.edu.espol.arboledaqhisperiveradomino.Juego.nFichasIniciales;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        
        System.out.print("Escriba el numero de fichas iniciales: ");
        nFichasIniciales = sc.nextInt();
        Juego juego = new Juego();
        
        System.out.print("1 Jugador o 2 Jugadores (Escriba 1 o 2): ");
        String modo = sc.next();
        
        while(!(modo.equals("1") || modo.equals("2"))){
            System.out.print("Opcion no valida. 1 Jugador o 2 Jugadores (Escriba 1 o 2): ");
            modo = sc.next();
        }
        
        if(modo.equals("1")){
            modo1(juego, sc);
            }
        
        else if (modo.equals("2")){
            modo2(juego, sc);
        }
                
    }
}
