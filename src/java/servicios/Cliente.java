/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import org.dao.DaoCliente;
import org.modelos.ModeloCliente;

/**
 *
 * @author Administrador
 */
@WebService(serviceName = "Cliente")
@Stateless()
public class Cliente {


    private DaoCliente daoCliente = new DaoCliente();

    @WebMethod(operationName = "insertarCliente")
    public boolean insertarCliente(String cui, String nombre, String apellido, String telefono, String direccion) {
        ModeloCliente cliente = new ModeloCliente();
        cliente.setCui(cui);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setTelefono(telefono);
        cliente.setDireccion(direccion);
        return daoCliente.insertar(cliente);
    }

    @WebMethod(operationName = "eliminarCliente")
    public boolean eliminarCliente(int idCliente) {
        ModeloCliente cliente = new ModeloCliente();
        cliente.setIdCliente(idCliente);
        return daoCliente.eliminar(cliente);
    }

    @WebMethod(operationName = "listarClientes")
    public List listarClientes() {
        return daoCliente.listar();
    }

    @WebMethod(operationName = "listarCliente")
    public ModeloCliente listarCliente(int id) {
        return daoCliente.list(id);
    }

    @WebMethod(operationName = "editarCliente")
    public boolean editarCliente(int id, String cui, String nombre, String apellido, String telefono, String direccion) {
        ModeloCliente cliente = new ModeloCliente();
        cliente.setIdCliente(id);
        cliente.setCui(cui);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setTelefono(telefono);
        cliente.setDireccion(direccion);
        return daoCliente.modificar(cliente);
    }

}
