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
import org.dao.DaoRenta;
import org.modelos.ModeloRenta;

/**
 *
 * @author Administrador
 */
@WebService(serviceName = "Renta")
@Stateless()
public class Renta {


    private DaoRenta daoRenta = new DaoRenta();
    
    @WebMethod(operationName = "InsertarRenta")
    public boolean InsertarRenta(int idrenta, int idvehi,double precio, String fechaini, String fechafin,int tipopago) {
        ModeloRenta ren = new ModeloRenta();
        ren.setIdrenta(idrenta);
        ren.setIdvehiculo(idvehi);
        ren.setPrecio(precio);
        ren.setFechaini(fechaini);
        ren.setFechafin(fechafin);
        ren.setTipopago(tipopago);
     
        return daoRenta.insertar(ren);
    }
    
    @WebMethod(operationName = "eliminarRenta")
    public boolean eliminarRenta (int renta){
         ModeloRenta mov = new ModeloRenta();
         mov.setIdrenta(renta);
        return daoRenta.eliminar(mov);
    }
    
       @WebMethod(operationName = "listarRentas")
    public List listarMovimientos() {
        return daoRenta.listar();
    }

    @WebMethod(operationName = "listarRenta")
    public ModeloRenta listarResta(int id) {
        return daoRenta.list(id);
    }

}
