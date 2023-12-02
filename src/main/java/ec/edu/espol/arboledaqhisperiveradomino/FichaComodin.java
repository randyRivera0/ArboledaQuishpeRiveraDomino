/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.arboledaqhisperiveradomino;

import java.util.Scanner;

/**
 *
 * @author spupi
 */
public class FichaComodin extends Ficha{
    public FichaComodin(){
        super(-1,-1);
    }
    
    public void setLado1(int lado1){
        if (lado1 >= 0){
            this.lado1 = lado1;    
        } else this.lado1 = 0;
        
    }
    
    public void setLado2(int lado2){
        if (lado2 >= 0){
            this.lado2 = lado2;
        } else this.lado2 = 0;
    }
    
    public void setLado1Scanner(Scanner sc){
        System.out.print("Ingrese el valor del lado1: ");
        int lado1 = sc.nextInt();
        this.setLado1(lado1);
    }
    
    public void setLado2Scanner(Scanner sc){
        System.out.print("Ingrese el valor del lado2: ");
        int lado2 = sc.nextInt();
        this.setLado2(lado2);
    }
    
    @Override
    public String toString(){
        return "*" + super.toString()+"*";
    }
}

