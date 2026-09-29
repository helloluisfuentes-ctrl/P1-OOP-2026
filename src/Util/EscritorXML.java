package Util;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Clase abstracta base para la escritura de documentos XML usando DOM.
 * Contiene los métodos comunes que los escritores específicos van a reutilizar.
 * 
 * @author marcoperezr
 *
 */
public abstract class EscritorXML {

    // crea un nuevo documento XML en blanco en memoria
     
    protected Document crearNuevoDocumento() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.newDocument();
    }

    // toma el árbol DOM generado y lo escribe en el archivo con sangría y formato UTF-8
    
    protected void guardarDocumentoEnArchivo(Document doc, File archivo) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        DOMSource origen = new DOMSource(doc);
        StreamResult destino = new StreamResult(archivo);
        transformer.transform(origen, destino);
    }

    // Función auxiliar para crear un elemento XML con su respectivo contenido de texto
    
    protected Element crearElementoTexto(Document doc, String etiqueta, String texto) {
        Element elemento = doc.createElement(etiqueta);
        if (texto != null) {
            elemento.setTextContent(texto);
        } else {
            elemento.setTextContent("");
        }
        return elemento;
    }
}
