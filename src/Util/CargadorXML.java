/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Conceptos.Veterinario;
import Conceptos.Cliente;
import Conceptos.Servicio;
import Util.SAXHandlerVeterinario;
import Util.SAXHandlerServicio;
import Util.SAXHandlerCliente;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * Clase utilitaria para parsear y cargar información desde un archivo XML.
 * 
 * @author fuent
 */
public class CargadorXML {
    
    /**
     * Lee un flujo XML y extrae una lista de objetos utilizando SAX.
     * 
     * @param archivo Flujo de entrada (InputStream) del archivo XML.
     * @return Lista de objetos obtenidas del XML.
     */
    
    
    public static ArrayList<Veterinario> cargarListaVeterinarios(InputStream archivo, ArrayList<Servicio> listaServicios){
        ArrayList<Veterinario> listaVeterinarios = new ArrayList();
        
        try {
            InputSource original = new InputSource(archivo);
            SAXHandlerVeterinario handler = new SAXHandlerVeterinario(listaServicios);
            
            // Configuración del parser SAX
            SAXParserFactory categoria = SAXParserFactory.newInstance();
            SAXParser parser = categoria.newSAXParser();
            XMLReader lector = parser.getXMLReader();
            
            // Asigna el manejador de eventos y parsea el archivo
            lector.setContentHandler(handler);
            lector.parse(original);
            
            // Obtiene los objetos procesados por el manejador
            listaVeterinarios = handler.getListaVeterinarios();
        } catch (IOException | SAXException | ParserConfigurationException ex){
            ex.printStackTrace();
        } 
        return listaVeterinarios;
    }
    
    public static ArrayList<Servicio> cargarListaServicios(InputStream archivo){
        ArrayList<Servicio> listaServicios = new ArrayList();
        
        try {
            InputSource original = new InputSource(archivo);
            SAXHandlerServicio handler = new SAXHandlerServicio();
            
            // Configuración del parser SAX
            SAXParserFactory categoria = SAXParserFactory.newInstance();
            SAXParser parser = categoria.newSAXParser();
            XMLReader lector = parser.getXMLReader();
            
            // Asigna el manejador de eventos y parsea el archivo
            lector.setContentHandler(handler);
            lector.parse(original);
            
            // Obtiene los objetos procesados por el manejador
            listaServicios = handler.getListaServicios();
        } catch (IOException | SAXException | ParserConfigurationException ex){
            ex.printStackTrace();
        } 
        return listaServicios;
    }
    
    public static ArrayList<Cliente> cargarListaClientes(InputStream archivo){
        ArrayList<Cliente> listaClientes = new ArrayList();
        
        try {
            InputSource original = new InputSource(archivo);
            SAXHandlerCliente handler = new SAXHandlerCliente();
            
            // Configuración del parser SAX
            SAXParserFactory categoria = SAXParserFactory.newInstance();
            SAXParser parser = categoria.newSAXParser();
            XMLReader lector = parser.getXMLReader();
            
            // Asigna el manejador de eventos y parsea el archivo
            lector.setContentHandler(handler);
            lector.parse(original);
            
            // Obtiene los objetos procesados por el manejador
            listaClientes = handler.getListaClientes();
        } catch (IOException | SAXException | ParserConfigurationException ex){
            ex.printStackTrace();
        } 
        return listaClientes;
    }
}
