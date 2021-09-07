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
import org.dao.DaoVehiculo;
import org.modelos.ModeloVehiculo;

/**
 *
 * @author Administrador
 */
@WebService(serviceName = "Vehiculo")
public class Vehiculo {

    private DaoVehiculo daoVehiculi = new DaoVehiculo();
    /**
     * This is a sample web service operation
     */
   @WebMethod(operationName = "listarVehiculos")
    public List listarVehiculos() {
        return daoVehiculi.listar();
    }
    
       @WebMethod(operationName = "insertarVehiculo")
    public boolean insertarVehiculo( String nombre,double precio) {
        ModeloVehiculo tipo = new ModeloVehiculo();
        tipo.setNombre(nombre);

        
        return daoVehiculi.insertar(tipo);
    }
    
       @WebMethod(operationName = "listarVehiculo")
    public ModeloVehiculo listarVehiculo(int id) {
        return daoVehiculi.list(id);
    }
}
