/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Conceptos.Servicio;
import Conceptos.Veterinario;
import java.util.ArrayList;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author fuent
 */
public class SAXHandlerVeterinario extends DefaultHandler {
    
    // Lista donde se guardan las clases procesadas
    private ArrayList<Veterinario> listaVeterinarios = new ArrayList();
    private ArrayList<Servicio> listaServiciosGlobales = new ArrayList();    
    
    // Pilas
    private Stack pilaVeterinarios     = new Stack();
    private Stack pilaEtiquetas     = new Stack();
    
    //Constructor

    public SAXHandlerVeterinario(ArrayList<Servicio> listaServiciosGlobales) {
        this.listaServiciosGlobales = listaServiciosGlobales;
    }
    
    
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
     * Si la etiqueta es <veterinario>, crea un nuevo objeto y lo coloca en la pila.
     * @param atributos
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atributos) throws SAXException {
        this.pilaEtiquetas.push(qName);
        if (qName.equalsIgnoreCase("veterinario")){
            Veterinario veterinario = new Veterinario();                     //creo nueva instancia
            veterinario.setIdentificacion(atributos.getValue("id"));   //le asigno el id que esta en atributos
            this.pilaVeterinarios.push(veterinario);
        }
    }
 
    /**
     * Se ejecuta al encontrar una etiqueta de cierre.
     * Si la etiqueta es </veterinario>, saca el objeto de la pila y lo añade a la lista final.
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.pilaEtiquetas.pop();
        
        if (qName.equalsIgnoreCase("veterinario")){
            Veterinario veterinario = (Veterinario)this.pilaVeterinarios.pop();
            listaVeterinarios.add(veterinario);
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
                Veterinario veterinario = (Veterinario)this.pilaVeterinarios.peek();
                veterinario.setNombre(valor);
            } else if (EtiquetaActual().equalsIgnoreCase("puesto")){
                Veterinario veterinario = (Veterinario)this.pilaVeterinarios.peek();
                veterinario.setPuesto(valor);
            } else if (EtiquetaActual().equalsIgnoreCase("id")){
                Veterinario veterinario = (Veterinario)this.pilaVeterinarios.peek();
                for (Servicio s : listaServiciosGlobales){
                    if (s.getIdentificacion().equalsIgnoreCase(valor)){
                        veterinario.AñadirServicio(s);
                        break;
                    }
                }
            }
        }
    }
    
    /**
     * Retorna la lista de personas construida durante el parsing.
     * @return 
     */
    public ArrayList<Veterinario> getListaVeterinarios(){
        return this.listaVeterinarios;
    }
    
}
