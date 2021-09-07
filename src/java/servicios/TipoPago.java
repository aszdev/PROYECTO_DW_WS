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
import org.dao.DaoTipoPago;
import org.modelos.ModeloTipoPago;

/**
 *
 * @author Administrador
 */
@WebService(serviceName = "TipoPago")
public class TipoPago {
   private DaoTipoPago daoTipoCuenta = new DaoTipoPago();
    /**
     * This is a sample web service operation
     */
   @WebMethod(operationName = "listarTipoPagos")
    public List listarTipoPagos() {
        return daoTipoCuenta.listar();
    }
    
       @WebMethod(operationName = "insertarTipoPago")
    public boolean insertarTipoPago(int tipopago, String descripcion) {
        ModeloTipoPago tipo = new ModeloTipoPago();
        tipo.setTipoCuenta(tipopago);
        tipo.setDescripcion(descripcion);
        
        return daoTipoCuenta.insertar(tipo);
    }
    
       @WebMethod(operationName = "listarTipoPago")
    public ModeloTipoPago listarTipoPago(int id) {
        return daoTipoCuenta.list(id);
    }
}
