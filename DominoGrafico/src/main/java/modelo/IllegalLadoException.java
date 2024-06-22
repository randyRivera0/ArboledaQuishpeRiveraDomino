/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author spupi
 */
public class IllegalLadoException extends IllegalArgumentException {

    public IllegalLadoException() {
        super("El valor no es un numero");
    }

    
    public IllegalLadoException(String s) {
        super(s);
    }
    
}
