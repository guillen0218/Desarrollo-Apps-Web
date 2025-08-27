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

public class Factura {
    private String id;
    private Pedido pedido;
    private double total;
    private Date fecha;
    private String metodoPago;

    public Factura(String id, Pedido pedido, String metodoPago) {
        this.id = id;
        this.pedido = pedido;
        this.total = pedido.obtenerTotal();
        this.fecha = new Date();
        this.metodoPago = metodoPago;
    }

    public void generarArchivo() {
        System.out.println("Factura generada para pedido " + pedido.getId() + " en archivo.");
    }

    public void imprimirFactura() {
        System.out.println("Factura ID: " + id);
        System.out.println("Cliente: " + pedido.getCliente().getNombre());
        System.out.println("Fecha: " + fecha);
        System.out.println("Productos:");
        for (int i = 0; i < pedido.getProductos().size(); i++) {
            Producto p = (Producto) pedido.getProductos().get(i);
            System.out.println("- " + p.getNombre() + ": $" + p.getPrecio());
        }
        System.out.println("Total: $" + total);
        System.out.println("Método de pago: " + metodoPago);
    }
}
