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
public class Cocinero extends Usuario {
    public Cocinero(String id, String nombre, String usuario, String contrasena) {
        super(id, nombre, usuario, contrasena, Rol.COCINERO);
    }

    public List verPedidosPendientes() {
        return MonitorCocina.getInstance().getPedidosPendientes();
    }

    public void marcarPedidoListo(Pedido pedido) {
        pedido.cambiarEstado(EstadoPedido.LISTO);
        MonitorCocina.getInstance().actualizarEstadoPedido(pedido);
    }
}