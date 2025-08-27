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

public class Pedido {
    private String id;
    private Cliente cliente;
    private Cajero cajero;
    private List productos;
    private EstadoPedido estado;
    private Date fecha;

    public Pedido(String id, Cliente cliente, Cajero cajero, List productos) {
        this.id = id;
        this.cliente = cliente;
        this.cajero = cajero;
        this.productos = productos;
        this.estado = EstadoPedido.PENDIENTE;
        this.fecha = new Date();
    }

    public void cambiarEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public double obtenerTotal() {
        double total = 0.0;
        for (int i = 0; i < productos.size(); i++) {
            Producto p = (Producto) productos.get(i);
            total += p.getPrecio();
        }
        return total;
    }

    public String getId() {
        return id;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public List getProductos() {
        return productos;
    }

    public Cliente getCliente() {
        return cliente;
    }
}