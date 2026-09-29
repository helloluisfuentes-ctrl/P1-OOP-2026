package Util;

import Conceptos.Cliente;
import java.io.File;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author marcoperezr
 */

public class EscritorXMLCliente extends EscritorXML {

    public void escribirClientes(ArrayList<Cliente> listaClientes, File archivo) {
        try {
            Document doc = crearNuevoDocumento();

            // etiqueta raíz <clientes>
            Element raiz = doc.createElement("clientes");
            doc.appendChild(raiz);

            // recorrer la lista y crear cada <cliente>
            for (Cliente cliente : listaClientes) {
                Element clienteElem = doc.createElement("cliente");
                clienteElem.setAttribute("id", cliente.getIdentificacion());

                clienteElem.appendChild(crearElementoTexto(doc, "nombre", cliente.getNombre()));
                clienteElem.appendChild(crearElementoTexto(doc, "propietario", cliente.getPropietario()));
                clienteElem.appendChild(crearElementoTexto(doc, "telefono", cliente.getTelefono()));
                clienteElem.appendChild(crearElementoTexto(doc, "email", cliente.getEmail()));

                raiz.appendChild(clienteElem);
            }

            guardarDocumentoEnArchivo(doc, archivo);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
