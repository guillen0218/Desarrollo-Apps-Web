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

public class MonitorCocina {
    private static MonitorCocina instance = new MonitorCocina();
    private List pedidosPendientes;
    private List cocineros;

    private MonitorCocina() {
        pedidosPendientes = new ArrayList();
        cocineros = new ArrayList();
    }

    public static MonitorCocina getInstance() {
        return instance;
    }

    public void agregarCocinero(Cocinero cocinero) {
        cocineros.add(cocinero);
    }

    public void agregarPedido(Pedido pedido) {
        pedidosPendientes.add(pedido);
        notificarCocineros(pedido);
    }

    public List getPedidosPendientes() {
        return new ArrayList(pedidosPendientes);
    }

    public void actualizarEstadoPedido(Pedido pedido) {
        if (pedido.getEstado() == EstadoPedido.LISTO) {
            pedidosPendientes.remove(pedido);
        }
    }

    private void notificarCocineros(Pedido pedido) {
        Thread notificador = new Thread() {
            public void run() {
                for (int i = 0; i < cocineros.size(); i++) {
                    Cocinero cocinero = (Cocinero) cocineros.get(i);
                    System.out.println("Notificación a " + cocinero.getId() + ": Nuevo pedido " + pedido.getId());
                }
            }
        };
        notificador.start();
    }
}
