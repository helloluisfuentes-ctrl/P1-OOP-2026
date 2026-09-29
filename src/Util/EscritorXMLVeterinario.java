package Util;

import Conceptos.Servicio;
import Conceptos.Veterinario;
import java.io.File;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author marcoperezr
 */

public class EscritorXMLVeterinario extends EscritorXML {

    public void escribirVeterinarios(ArrayList<Veterinario> listaVeterinarios, File archivo) {
        try {
            Document doc = crearNuevoDocumento();

            // etiqueta raíz <veterinarios>
            Element raiz = doc.createElement("veterinarios");
            doc.appendChild(raiz);

            // recorrer la lista y crear cada <veterinario>
            for (Veterinario vet : listaVeterinarios) {
                Element vetElem = doc.createElement("veterinario");
                vetElem.setAttribute("id", vet.getIdentificacion());

                vetElem.appendChild(crearElementoTexto(doc, "nombre", vet.getNombre()));
                vetElem.appendChild(crearElementoTexto(doc, "puesto", vet.getPuesto()));

                // bloque anidado de llaves <servicios>
                Element serviciosContenedor = doc.createElement("servicios");
                if (vet.getListaServicios() != null) {
                    for (Servicio s : vet.getListaServicios()) {
                        serviciosContenedor.appendChild(crearElementoTexto(doc, "id", s.getIdentificacion()));
                    }
                }
                vetElem.appendChild(serviciosContenedor);

                raiz.appendChild(vetElem);
            }

            guardarDocumentoEnArchivo(doc, archivo);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
