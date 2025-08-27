/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemarestaurante;
import java.util.*;
/**
 *
 * @author jguil
 */
public class Cajero extends Usuario {
    private static int contadorPedidos = 1;

    public Cajero(String id, String nombre, String usuario, String contrasena) {
        super(id, nombre, usuario, contrasena, Rol.CAJERO);
    }

    public Pedido registrarPedido(Cliente cliente, List productos) {
        String id = "PED" + contadorPedidos++;
        Pedido pedido = new Pedido(id, cliente, this, productos);
        MonitorCocina.getInstance().agregarPedido(pedido);
        return pedido;
    }

    public Factura generarFactura(Pedido pedido, String metodoPago) {
        return new Factura("FAC" + contadorPedidos, pedido, metodoPago);
    }
}