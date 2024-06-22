/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author spupi
 */
public class IllegalPosicionException extends IllegalArgumentException {
    
     public IllegalPosicionException() {
        super("El valor no es Inicio o Fin");
    }

    public IllegalPosicionException(String s) {
        super(s);
    }
}
