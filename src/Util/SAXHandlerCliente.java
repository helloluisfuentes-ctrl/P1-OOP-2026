/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Conceptos.Cliente;
import java.util.ArrayList;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author fuent
 */
public class SAXHandlerCliente extends DefaultHandler {
    
    // Lista donde se guardan las clases procesadas
    private ArrayList<Cliente> listaClientes = new ArrayList();
    
    
    // Pilas
    private 
            Stack pilaClientes     = new Stack();
    private Stack pilaEtiquetas     = new Stack();
    
    @Override
    public void startDocument() throws SAXException {
        // nada
    }
    
    @Override
    public void endDocument() throws SAXException {
        // nada
    }
    
    /**
     * Se ejecuta al encontrar una etiqueta de apertura.
     * Si la etiqueta es <cliente>, crea un nuevo objeto y lo coloca en la pila.
     * @param atributos
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atributos) throws SAXException {
        this.pilaEtiquetas.push(qName);
        if (qName.equalsIgnoreCase("cliente")){
            Cliente cliente = new Cliente();                     //creo nueva instancia
            cliente.setIdentificacion(atributos.getValue("id"));   //le asigno el id que esta en atributos
            this.pilaClientes.push(cliente);
        }
    }
 
    /**
     * Se ejecuta al encontrar una etiqueta de cierre.
     * Si la etiqueta es </cliente>, saca el objeto de la pila y lo añade a la lista final.
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.pilaEtiquetas.pop();
        
        if (qName.equalsIgnoreCase("cliente")){
            Cliente cliente = (Cliente)this.pilaClientes.pop();
            listaClientes.add(cliente);
        }
    }
    
    /**
     * Función auxiliar para obtener el nombre de la etiqueta que se está procesando actualmente.
     */
    private String EtiquetaActual(){
        return (String)this.pilaEtiquetas.peek();
    }
    
    /**
     * Se ejecuta cuando se lee el contenido de texto dentro de una etiqueta.
     * Asigna el texto al atributo correspondiente al objeto en la cima de la pila.
     * @param lenght
     */
    @Override
    public void characters(char[] ch, int start, int lenght) throws SAXException {
        String valor = new String(ch, start, lenght);
        valor = valor.trim();   //quito espacios extra
        if (valor.length() > 0){
            if (EtiquetaActual().equalsIgnoreCase("nombre")){
                Cliente cliente = (Cliente)this.pilaClientes.peek();
                cliente.setNombre(valor);
            } else if (EtiquetaActual().equalsIgnoreCase("propietario")){
                Cliente cliente = (Cliente)this.pilaClientes.peek();
                cliente.setPropietario(valor);
            } else if (EtiquetaActual().equalsIgnoreCase("telefono")){
                Cliente cliente = (Cliente)this.pilaClientes.peek();
                cliente.setTelefono(valor);
            } else if (EtiquetaActual().equalsIgnoreCase("email")){
                Cliente cliente = (Cliente)this.pilaClientes.peek();
                cliente.setEmail(valor);
            } 
        }
    }
    
    /**
     * Retorna la lista de personas construida durante el parsing.
     * @return 
     */
    public ArrayList<Cliente> getListaClientes(){
        return this.listaClientes;
    }
    
}
    

