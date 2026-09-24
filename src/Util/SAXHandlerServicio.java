
package Util;

import Conceptos.Servicio;
import java.util.ArrayList;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandlerServicio extends DefaultHandler{
   
    // Lista donde se guardan las clases procesadas
    private ArrayList<Servicio> listaServicios = new ArrayList();
    
    
    // Pilas
    private 
            Stack pilaServicios     = new Stack();
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
     * Si la etiqueta es <servicio>, crea un nuevo objeto y lo coloca en la pila.
     * @param atributos
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atributos) throws SAXException {
        this.pilaEtiquetas.push(qName);
        if (qName.equalsIgnoreCase("servicio")){
            Servicio servicio = new Servicio();                     //creo nueva instancia
            servicio.setIdentificacion(atributos.getValue("id"));   //le asigno el id que esta en atributos
            this.pilaServicios.push(servicio);
        }
    }
 
    /**
     * Se ejecuta al encontrar una etiqueta de cierre.
     * Si la etiqueta es </servicio>, saca el objeto de la pila y lo añade a la lista final.
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.pilaEtiquetas.pop();
        
        if (qName.equalsIgnoreCase("servicio")){
            Servicio servicio = (Servicio)this.pilaServicios.pop();
            listaServicios.add(servicio);
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
                Servicio servicio = (Servicio)this.pilaServicios.peek();
                servicio.setNombre(valor);
            } else if (EtiquetaActual().equalsIgnoreCase("precio")){
                Servicio servicio = (Servicio)this.pilaServicios.peek();
                servicio.setPrecio(valor);
            } 
        }
    }
    
    /**
     * Retorna la lista de personas construida durante el parsing.
     * @return 
     */
    public ArrayList<Servicio> getListaServicios(){
        return this.listaServicios;
    }
    
}
