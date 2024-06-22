/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author spupi
 */
public class Ficha {
    public int lado1;
    public int lado2;

    public Ficha(int lado1, int lado2) throws IllegalLadoException{
        validarLados(lado1, lado2);
        this.lado1 = lado1;
        this.lado2 = lado2;
    }
    
    private void validarLados(int lado1, int lado2){
        if(lado1<0 || lado1>6 || lado2<0 || lado2>6){
            throw new IllegalLadoException("Valores de los lados no estan entre 1 y 6 incluidos.");
        }
    }

    public void setLado1(int lado1) {
        if(lado1 >= 0){
            this.lado1 = lado1;
        }   else this.lado1 = 0;
    }

    public void setLado2(int lado2) {
        if(lado2 >= 0){
            this.lado2 = lado2;
        }   else this.lado2 = 0;
    }

    public int getLado1() {
        return lado1;
    }

    public int getLado2() {
        return lado2;
    }
    
    
    @Override
    public String toString() {
        return lado1 + " | " + lado2;
    }
    
    public String getPath(){
        return "img/" + lado1 + "_" + lado2 + ".png";
    }
}
