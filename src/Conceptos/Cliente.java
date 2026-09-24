/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conceptos;

/**
 *
 * @author fuent
 */
public class Cliente {
    
    //Atributos
    private String identificacion;
    private String nombre;
    private String propietario;
    private String telefono;
    private String email;

    //Constructor
    public Cliente() {
    }

    //getters and setters
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    //toString
    @Override
    public String toString() {
        return "Cliente{" + "identificacion=" + identificacion + ", nombre=" + nombre + ", propietario=" + propietario + ", telefono=" + telefono + ", email=" + email + '}';
    }
    
    
}
