/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.modelos.ModeloCliente;

/**
 *
 * @author Jonathan
 */
public interface CrudCliente {
    
    public List listar();
    public ModeloCliente list (int id);
    public boolean insertar(ModeloCliente cliente);
    public boolean modificar(ModeloCliente cliente);
    public boolean eliminar(ModeloCliente cliente);
}
