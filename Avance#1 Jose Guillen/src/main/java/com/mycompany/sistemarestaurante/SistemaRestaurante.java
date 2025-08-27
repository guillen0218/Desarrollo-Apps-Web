/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemarestaurante;

import java.util.*;

/**
 *
 * @author jguil
 */

public class SistemaRestaurante {
    public static void main(String[] args) {
        Admin admin = new Admin("A001", "Admin", "admin", "admin123");
        Cajero cajero = new Cajero("C001", "Cajero1", "cajero", "cajero123");
        Cocinero cocinero = new Cocinero("K001", "Cocinero1", "cocinero", "cocinero123");

        admin.crearUsuario(cajero);
        admin.crearUsuario(cocinero);

        Producto hamburguesa = new Producto("P001", "Hamburguesa", 5.99, "Comida");
        Producto refresco = new Producto("P002", "Refresco", 1.99, "Bebida");
        List comboProductos = new ArrayList();
        comboProductos.add(hamburguesa);
        comboProductos.add(refresco);
        Combo combo = new Combo("C001", "Combo Básico", comboProductos);

        admin.agregarProducto(hamburguesa);
        admin.agregarCombo(combo);

        Cliente cliente = new Cliente("CL001", "Juan Pérez");
        if (cajero.iniciarSesion("cajero", "cajero123")) {
            List productos = new ArrayList();
            productos.add(hamburguesa);
            productos.add(combo);
            Pedido pedido = cajero.registrarPedido(cliente, productos);
            admin.agregarHistorial(pedido);

            Factura factura = cajero.generarFactura(pedido, "Efectivo");
            factura.imprimirFactura();

            List pedidosPendientes = cocinero.verPedidosPendientes();
            for (int i = 0; i < pedidosPendientes.size(); i++) {
                cocinero.marcarPedidoListo((Pedido) pedidosPendientes.get(i));
            }

            admin.generarReporteVentas("Diario");
        }
    }
}
