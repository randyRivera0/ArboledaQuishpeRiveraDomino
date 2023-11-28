/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.arboledaqhisperiveradomino;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author spupi
 */
class Utilitaria {
    
    public static ArrayList<Ficha> crearManoJugador(){
        ArrayList<Ficha> mano = new ArrayList<>();
        for(int i=0; i<6; i++){
            Random r = new Random(7);
            int lado1 = r.nextInt();
            int lado2 = r.nextInt();
            Ficha f = new Ficha(lado1, lado2);
            mano.add(f);
        }
        mano.add(new FichaComodin());
        return mano;
    }
}
