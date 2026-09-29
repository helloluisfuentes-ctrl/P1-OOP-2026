package Util;

import Conceptos.Servicio;
import java.io.File;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author marcoperezr
 */

public class EscritorXMLServicio extends EscritorXML {

    public void escribirServicios(ArrayList<Servicio> listaServicios, File archivo) {
        try {
            Document doc = crearNuevoDocumento();

            // etiqueta raíz <servicios>
            Element raiz = doc.createElement("servicios");
            doc.appendChild(raiz);

            // recorrer la lista y crear cada <servicio>
            for (Servicio servicio : listaServicios) {
                Element servicioElem = doc.createElement("servicio");
                servicioElem.setAttribute("id", servicio.getIdentificacion());

                servicioElem.appendChild(crearElementoTexto(doc, "nombre", servicio.getNombre()));
                servicioElem.appendChild(crearElementoTexto(doc, "precio", servicio.getPrecio()));

                raiz.appendChild(servicioElem);
            }

            guardarDocumentoEnArchivo(doc, archivo);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
