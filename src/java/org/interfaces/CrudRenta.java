/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.modelos.ModeloRenta;

/**
 *
 * @author Jonathan
 */
public interface CrudRenta {
    
    public List listar();
    public ModeloRenta list (int id);
    public boolean insertar(ModeloRenta mov);
    public boolean modificar(ModeloRenta mov);
    public boolean eliminar(ModeloRenta mov);
}
