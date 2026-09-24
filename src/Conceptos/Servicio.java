/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conceptos;

/**
 *
 * @author fuent
 */
public class Servicio {
    
    //Atributos
    private String identificacion;
    private String nombre;
    private String precio;

    //Constructor
    public Servicio() {
    }
    
    //Getters and setters
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
    //toString
    @Override
    public String toString() {
        return "Servicio{" + "identificacion=" + identificacion + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
 
}
