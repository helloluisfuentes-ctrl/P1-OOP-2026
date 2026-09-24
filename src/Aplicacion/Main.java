
/*
        Proyecto 1 POO
        Luis Carlos Fuentes Calvo 2026106554
*/

package Aplicacion;

import Conceptos.Cliente;
import Conceptos.Servicio;
import Conceptos.Veterinario;
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
        
        
        
    }
}
