/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemarestaurante;

/**
 *
 * @author jguil
 */
public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private String categoria;

    public Producto(String id, String nombre, double precio, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public void modificarPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

    public boolean consultarDisponibilidad() {
        return true;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
}
