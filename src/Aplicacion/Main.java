
/*
        Proyecto 1 POO
        Luis Carlos Fuentes Calvo 2026106554
        Marco Pérez Ramos 2026096083

*/

package Aplicacion;

import Conceptos.Cliente;
import Conceptos.Servicio;
import Conceptos.Veterinario;
import Ventanas.Escritorio;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        //Instanceo los arraylists
        ArrayList<Veterinario> listaVeterinarios = new ArrayList();
        ArrayList<Servicio> listaServicios = new ArrayList();
        ArrayList<Cliente> listaClientes = new ArrayList();
        
        try {
            //Creo los archivos
            File veterinariosXML = new File("data\\veterinarios.xml");
            File serviciosXML = new File("data\\servicios.xml");
            File clientesXML = new File("data\\clientes.xml");
            
            //Leo los archivos y los cargo en los respectivos arraylists
            listaServicios = Util.CargadorXML.cargarListaServicios(new FileInputStream(serviciosXML));
            listaVeterinarios = Util.CargadorXML.cargarListaVeterinarios(new FileInputStream(veterinariosXML), listaServicios);
            listaClientes = Util.CargadorXML.cargarListaClientes(new FileInputStream(clientesXML));
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    
        //Inicializo la ventana y le cargo las listas
        Escritorio ventana = new Escritorio(listaClientes, listaServicios, listaVeterinarios);
        ventana.setVisible(true);    
        
    //PRUEBAS
    for (Veterinario v : listaVeterinarios){
        System.out.println(v);
    }  
    for (Cliente c : listaClientes){
        System.out.println(c);
    }
    for (Servicio s : listaServicios){
        System.out.println(s);
    }  
        
    // PRUEBA PROVISIONAL DE ESCRITURA

    // se añade un nuevo cliente para ver el cambio en el archivo de prueba
    
    Cliente nuevoCliente = new Cliente();
    nuevoCliente.setIdentificacion("999999999");
    nuevoCliente.setNombre("Prueba Escritura");
    nuevoCliente.setPropietario("Marco");
    nuevoCliente.setTelefono("8888-8888");
    nuevoCliente.setEmail("marco@correo.com");
    listaClientes.add(nuevoCliente);
    
    // guardar en archivos de prueba (para no sobreescribir los originales)
    
    File pruebaClientes = new File("data\\test_clientes.xml");
    File pruebaServicios = new File("data\\test_servicios.xml");
    File pruebaVeterinarios = new File("data\\test_veterinarios.xml");
    
    Util.GuardadorXML.guardarClientes(listaClientes, pruebaClientes);
    Util.GuardadorXML.guardarServicios(listaServicios, pruebaServicios);
    Util.GuardadorXML.guardarVeterinarios(listaVeterinarios, pruebaVeterinarios);
    
    
    }
}
