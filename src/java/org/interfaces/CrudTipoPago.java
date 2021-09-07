/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.modelos.ModeloTipoPago;

/**
 *
 * @author Jonathan
 */
public interface CrudTipoPago {
    
    public List listar();
    public ModeloTipoPago list (int id);
    public boolean insertar(ModeloTipoPago tipo);
    public boolean modificar(ModeloTipoPago tipo);
    public boolean eliminar(ModeloTipoPago tipo);
}
