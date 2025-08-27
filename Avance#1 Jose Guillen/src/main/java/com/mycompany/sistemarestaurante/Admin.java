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

public class Admin extends Usuario {
    private List usuarios;
    private List productos;
    private List historialPedidos;

    public Admin(String id, String nombre, String usuario, String contrasena) {
        super(id, nombre, usuario, contrasena, Rol.ADMIN);
        usuarios = new ArrayList();
        productos = new ArrayList();
        historialPedidos = new ArrayList();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void agregarCombo(Combo combo) {
        productos.add(combo);
    }

    public void crearUsuario(Usuario usuario) {
        usuarios.add(usuario);
        if (usuario.getRol() == Rol.COCINERO) {
            MonitorCocina.getInstance().agregarCocinero((Cocinero) usuario);
        }
    }

    public void editarUsuario(String id, String nuevoNombre, String nuevoUsuario, String nuevaContrasena) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = (Usuario) usuarios.get(i);
            if (u.getId().equals(id)) {
                usuarios.set(i, new Usuario(id, nuevoNombre, nuevoUsuario, nuevaContrasena, u.getRol()));
                break;
            }
        }
    }

    public void eliminarUsuario(String id) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (((Usuario) usuarios.get(i)).getId().equals(id)) {
                usuarios.remove(i);
                break;
            }
        }
    }

    public List consultarHistorialPedidos() {
        return historialPedidos;
    }

    public void generarReporteVentas(String periodo) {
        double totalVentas = 0.0;
        for (int i = 0; i < historialPedidos.size(); i++) {
            Pedido p = (Pedido) historialPedidos.get(i);
            totalVentas += p.obtenerTotal();
        }
        System.out.println("Reporte de ventas - " + periodo);
        System.out.println("Total de ventas: $" + totalVentas);
        System.out.println("Pedidos:");
        for (int i = 0; i < historialPedidos.size(); i++) {
            Pedido p = (Pedido) historialPedidos.get(i);
            System.out.println("- Pedido " + p.getId() + " - Total: $" + p.obtenerTotal());
        }
    }

    public void agregarHistorial(Pedido pedido) {
        historialPedidos.add(pedido);
    }
}