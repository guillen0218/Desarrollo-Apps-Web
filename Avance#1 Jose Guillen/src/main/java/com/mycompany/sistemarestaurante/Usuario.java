/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemarestaurante;

/**
 *
 * @author jguil
 */
public class Usuario {
    private String id;
    private String nombre;
    private String usuario;
    private String contrasena;
    private Rol rol;

    public Usuario(String id, String nombre, String usuario, String contrasena, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public boolean iniciarSesion(String usuario, String contrasena) {
        return this.usuario.equals(usuario) && this.contrasena.equals(contrasena);
    }

    public void cerrarSesion() {
        System.out.println(nombre + " ha cerrado sesión.");
    }

    public void cambiarContrasena(String nuevaContrasena) {
        this.contrasena = nuevaContrasena;
        System.out.println("Contraseña cambiada para " + nombre);
    }

    public String getId() {
        return id;
    }

    public Rol getRol() {
        return rol;
    }
}
