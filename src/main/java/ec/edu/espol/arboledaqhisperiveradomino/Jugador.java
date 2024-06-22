/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.arboledaqhisperiveradomino;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 
 */
class Jugador {
    String nombre;
    ArrayList<Ficha> manoJugador;
    int posibilidades;
    
    public Jugador(){}
    
    public Jugador(String nombre, ArrayList<Ficha> manoJugador){
        this.nombre = nombre;
        this.manoJugador = manoJugador;
    }
    
    public Jugador(String nombre){
        this(nombre, Utilitaria.crearManoJugador());
    }
    
    public Ficha getFicha(int indice){
        if (indice >= 0 && indice < manoJugador.size()){
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
            sb.append(f).append(" - ");
        }
        Ficha fFinal = manoJugador.get(manoJugador.size()-1);
        sb.append(fFinal);
        System.out.println(sb.toString());
    }
    
    /*
    public static boolean posibleFichaAFicha(Ficha f1, Ficha f2){
       return (f1.getLado1() == f2.getLado2() || f1.getLado2() == f2.getLado1());
    }
    */
    
    public static boolean posibleFichaALinea(Ficha f, Juego j){
        if (j.getLineaJuego().isEmpty()) return true;
        else if (f instanceof FichaComodin) return true;
        else return (f.getLado1() == j.obtenerValorFinLinea() || f.getLado2() == j.obtenerValorInicioLinea());           
    }
    
    public void posibilidades(Juego j){     
        for (Ficha fJugador : manoJugador){
            if (posibleFichaALinea(fJugador, j)){
                    posibilidades += 1;
                }
            }
        }
    
    public void turno(Juego juego, Scanner sc){      
        System.out.print("Jugador " + getNombre() + ": Mano -> ");
        imprimirMano();
        System.out.print("Linea de Juego: ");
        juego.mostrarLinea();
        posibilidades = 0;
        posibilidades(juego);
        System.out.println("Posibilidades: " + posibilidades);          
        System.out.print("Indice de ficha para jugar (0 es el primero): ");
        int indice = sc.nextInt();
        boolean valido = false;
        if (indice < manoJugador.size()){
            valido = agregarFichaLinea(getFicha(indice), juego);
        }
        if (valido) System.out.println("Movimiento Valido");
        else System.out.println("Movimiento No Valido");
        System.out.print("Nueva Linea de Juego: ");
        juego.mostrarLinea();
    }     
       
    public boolean agregarFichaLinea(Ficha f, Juego j){
        ArrayList<Ficha> lineaJuego = j.getLineaJuego();
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        
        if (f instanceof FichaComodin fComodin){
                    if (lineaJuego.isEmpty()){
                        fComodin.setLado1Scanner(sc);
                        fComodin.setLado2Scanner(sc);
                        lineaJuego.add(fComodin);
                        removerFicha(f);
                    }

                    else{
                        System.out.println("Ingrese la posicion donde quiere agregar la ficha (Inicio o Fin): ");
                        String posicion = sc.next();

                        if (posicion.equals("Inicio")){
                            int lado2 = lineaJuego.get(0).getLado1();
                            fComodin.setLado2(lado2);
                            fComodin.setLado1Scanner(sc);
                            lineaJuego.add(0, fComodin);
                            removerFicha(f);
                        }

                        else if (posicion.equals("Fin")){
                            int lado1 = lineaJuego.get(lineaJuego.size()-1).getLado2();
                            fComodin.setLado1(lado1);
                            fComodin.setLado2Scanner(sc);
                            lineaJuego.add(fComodin);
                            removerFicha(f);
                        }  
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
                   System.out.print("Ingrese la posicion donde quiere agregar la ficha (Inicio o Fin)");
                    String posicion = sc.next();
                    if (posicion.equals("Inicio")){
                       lineaJuego.add(0, f); 
                       removerFicha(f);
                    }

                    else if (posicion.equals("Fin")){
                        lineaJuego.add(f);
                        removerFicha(f);
                    }
               }

               return true;
            }

            else{
                System.out.println("Ficha tenia " + f + " No puede jugar esa ficha, intentelo de nuevo");
                return false;
            }
        }    
    }
}
