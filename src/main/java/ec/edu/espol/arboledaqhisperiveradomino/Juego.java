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
    private ArrayList<Jugador> jugadores;
    
    public Juego(){
        lineaJuego = new ArrayList<>();
        jugadores = new ArrayList<>();
    }

    public void setLineaJuego(ArrayList<Ficha> lineaJuego) {
        this.lineaJuego = lineaJuego;
    }

    public void setJugadores(String nombre) {
        if(jugadores.size() < 2){
            jugadores.add(new Jugador(nombre));
        }
    }
    
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
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
    
    public boolean agregarFichaLinea(Ficha f, Jugador j){
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        if (f instanceof FichaComodin fComodin){
            if (lineaJuego.isEmpty()){
                fComodin.setLado1Scanner(sc);
                fComodin.setLado2Scanner(sc);
                lineaJuego.add(fComodin);
                j.removerFicha(f);
            }
            
            else{
                System.out.println("Ingrese la posicion donde quiere agregar la ficha");
                String posicion = sc.next();
                
                if (posicion.equals("Inicio")){
                    int lado2 = lineaJuego.get(0).getLado1();
                    fComodin.setLado2(lado2);
                    fComodin.setLado1Scanner(sc);
                    lineaJuego.add(0, fComodin);
                    j.removerFicha(f);
                }
                
                else if (posicion.equals("Fin")){
                    int lado1 = lineaJuego.get(lineaJuego.size()-1).getLado2();
                    fComodin.setLado1(lado1);
                    fComodin.setLado2Scanner(sc);
                    lineaJuego.add(fComodin);
                    j.removerFicha(f);
                }  
            }
            
        return true;
        
        }
        
        else{
            if(lineaJuego.isEmpty()){
                lineaJuego.add(f);
                j.removerFicha(f);
                return true;
            }
            
            else if(lineaJuego.get(0).getLado1() == (f.getLado2()) || lineaJuego.get(lineaJuego.size()-1).getLado2() == f.getLado1()){
               if (lineaJuego.get(0).getLado1() == (f.getLado2()) && !(lineaJuego.get(lineaJuego.size()-1).getLado2() == (f.getLado1()))){
                   lineaJuego.add(0, f);
                   j.removerFicha(f);
               } 
               else if (!(lineaJuego.get(0).getLado1() == (f.getLado2())) && lineaJuego.get(lineaJuego.size()-1).getLado2() == f.getLado1()){
                   lineaJuego.add(f);
                   j.removerFicha(f);
               }
               
               else{
                   System.out.println("Ingrese la posicion donde quiere agregar la ficha");
                    String posicion = sc.next();
                    if (posicion.equals("Inicio")){
                       lineaJuego.add(0, f); 
                       j.removerFicha(f);
                    }
                    
                    else if (posicion.equals("Fin")){
                        lineaJuego.add(f);
                        j.removerFicha(f);
                    }
               }
               
               return true;
            }
            
            else{
                System.out.println("Ficha tenia " + f.getLado1() + ":" + f.getLado2() + " No puede jugar esa ficha, intentalo de nuevo");
                return false;
            }
        }
    }
}
