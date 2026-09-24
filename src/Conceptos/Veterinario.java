/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conceptos;

import java.util.ArrayList;

/**
 *
 * @author fuent
 */
public class Veterinario {
    
    //Atributos
    private String identificacion;
    private String nombre;
    private String puesto;
    private ArrayList<Servicio> listaServicios = new ArrayList();
    
    //Constructor
    public Veterinario() {
    }
    
    //Añadir y eliminar servicio
    public void AñadirServicio(Servicio servicio){
        this.listaServicios.add(servicio);
    }
    
    public void EliminarServicio(Servicio servicio){
        this.listaServicios.remove(servicio);
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public ArrayList<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(ArrayList<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }
    
    //toString
    @Override
    public String toString() {
        return "Veterinario{" + "identificacion=" + identificacion + ", nombre=" + nombre + ", puesto=" + puesto + ", listaServicios=" + listaServicios + '}';
    }
    
    
}
