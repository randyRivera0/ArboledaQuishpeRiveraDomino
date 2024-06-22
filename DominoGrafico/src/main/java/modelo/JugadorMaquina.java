/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author spupi
 */
public class JugadorMaquina extends Jugador {
    
    public JugadorMaquina() {
        super("Maquina");
    }
    
    
    public void turno(){

        if(Juego.lineaJuego.isEmpty()){
            if(!manoJugador.isEmpty()){
                Juego.lineaJuego.add(manoJugador.get(0));
                manoJugador.remove(0);
            } 
        }
        
        else{
            Ficha fRemover = null;
            for(Ficha f : manoJugador){
                if (f instanceof FichaComodin){
                    Ficha fComodin = new Ficha(1, Juego.obtenerValorInicioLinea());
                    Juego.lineaJuego.add(0, fComodin);
                    fRemover = f;
                    break;
                }
                else if(f.getLado2() == Juego.obtenerValorInicioLinea()){
                    Juego.lineaJuego.add(0, f);
                    fRemover = f;
                    break;
                }
                else if(f.getLado1() == Juego.obtenerValorFinLinea()){
                    Juego.lineaJuego.add(f);
                    fRemover = f;
                    break;
                }
            }
            if (fRemover!=null) removerFicha(fRemover);
        }
    }
}
