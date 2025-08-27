/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemarestaurante;

/**
 *
 * @author jguil
 */
import java.util.*;

public class Combo extends Producto {
    private List listaProductos;

    public Combo(String id, String nombre, List listaProductos) {
        super(id, nombre, 0.0, "Combo");
        this.listaProductos = listaProductos;
    }

    public double calcularPrecioTotal() {
        double total = 0.0;
        for (int i = 0; i < listaProductos.size(); i++) {
            total += ((Producto) listaProductos.get(i)).getPrecio();
        }
        return total;
    }

    public List listarProductos() {
        return listaProductos;
    }
}