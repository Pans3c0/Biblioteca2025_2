/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.educastur.danielap62.biblioteca2025;

/**
 *
 * @author alu02d
 */
public class LibroNoExiste extends Exception {
    public LibroNoExiste (String cadena){
        super(cadena);
    }
}
