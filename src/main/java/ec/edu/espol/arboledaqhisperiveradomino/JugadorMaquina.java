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
public class JugadorMaquina extends Jugador{
    public JugadorMaquina(){
        super("Maquina", Utilitaria.crearManoJugador());
    }
    
    @Override
    public void turno(Juego juego, Scanner sc){      
            System.out.print("Jugador " + getNombre() + ": Mano -> ");
            imprimirMano();
            System.out.print("Linea de Juego: ");
            juego.mostrarLinea();
            posibilidades = 0;
            posibilidades(juego);
            System.out.println("Posibilidades: " + posibilidades);
            if (posibilidades > 0){
                for (Ficha f : manoJugador){
                    if(Jugador.posibleFichaALinea(f, juego)){                        
                        agregarFichaLinea(f, juego);
                        System.out.println("Movimiento Valido");
                        break;
                    }
                }
            } else System.out.println("Movimiento No Valido");
            System.out.print("Nueva Linea de Juego: ");
            juego.mostrarLinea();
        }
    
    @Override
    public boolean agregarFichaLinea(Ficha f, Juego j){
        ArrayList<Ficha> lineaJuego = j.getLineaJuego();
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        if (f instanceof FichaComodin fComodin){
                    if (lineaJuego.isEmpty()){
                        fComodin.setLado1(1);
                        fComodin.setLado2(1);
                        lineaJuego.add(fComodin);
                        removerFicha(f);
                    }

                    else{
                        int lado2 = lineaJuego.get(0).getLado1();
                        fComodin.setLado2(lado2);
                        fComodin.setLado1(1);
                        lineaJuego.add(0, fComodin);
                        removerFicha(f);
                    }

                return true;

                }

                else{
                    if(lineaJuego.isEmpty()){
                        lineaJuego.add(f);
                        removerFicha(f);
                        return true;
                    }

                    else if(lineaJuego.get(0).getLado1() == (f.getLado2()) || lineaJuego.get(lineaJuego.size()-1).getLado2() == f.getLado1()){
                       if (lineaJuego.get(0).getLado1() == (f.getLado2()) && !(lineaJuego.get(lineaJuego.size()-1).getLado2() == (f.getLado1()))){
                           lineaJuego.add(0, f);
                           removerFicha(f);
                       } 
                       else if (!(lineaJuego.get(0).getLado1() == (f.getLado2())) && lineaJuego.get(lineaJuego.size()-1).getLado2() == f.getLado1()){
                           lineaJuego.add(f);
                           removerFicha(f);
                       }

                       else{
                            lineaJuego.add(0, f); 
                            removerFicha(f);
                       }

                       return true;
                    }

                    else{
                        System.out.println("Ficha tenia " + f + " No puede jugar esa ficha, intentalo de nuevo");
                        return false;
                    }
                }
    }
       
    
}
