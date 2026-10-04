package Util;

import Conceptos.Cliente;
import Conceptos.Servicio;
import Conceptos.Veterinario;
import java.io.File;
import java.util.ArrayList;

/**
 * @author marcoperezr
 */

public class GuardadorXML {

    //guardar clientes
    public static void guardarClientes(ArrayList<Cliente> lista, File archivo) {
        EscritorXMLCliente escritor = new EscritorXMLCliente();
        escritor.escribirClientes(lista, archivo);
    }

    public static void guardarClientes(ArrayList<Cliente> lista, String rutaArchivo) {
        guardarClientes(lista, new File(rutaArchivo));
    }

    //guardar servicios
    public static void guardarServicios(ArrayList<Servicio> lista, File archivo) {
        EscritorXMLServicio escritor = new EscritorXMLServicio();
        escritor.escribirServicios(lista, archivo);
    }

    public static void guardarServicios(ArrayList<Servicio> lista, String rutaArchivo) {
        guardarServicios(lista, new File(rutaArchivo));
    }

    //guardar veterinarios
    public static void guardarVeterinarios(ArrayList<Veterinario> lista, File archivo) {
        EscritorXMLVeterinario escritor = new EscritorXMLVeterinario();
        escritor.escribirVeterinarios(lista, archivo);
    }

    public static void guardarVeterinarios(ArrayList<Veterinario> lista, String rutaArchivo) {
        guardarVeterinarios(lista, new File(rutaArchivo));
    }
}
