/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.modelos.ModeloTipoPago;
import org.interfaces.CrudTipoPago;

public class DaoTipoPago implements CrudTipoPago{
    
     //Se crea un objeto publico del Cliente
    ModeloTipoPago tipo = new ModeloTipoPago();
    //Variable para crear las sentencias SQL
    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();
    //Obtiene el resultado de las consultas SQL
    ResultSet rs = null;
    //flag para retornar si la sentencia SQL fue satisfactorio o no
    boolean respuesta = false;
    
     @Override
    public List listar() {
        ArrayList<ModeloTipoPago>lstTipo = new ArrayList<>();
         try {            
            strSql = "SELECT * FROM TIPO_PAGO";
             
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModeloTipoPago tipo = new ModeloTipoPago();
                tipo.setTipoCuenta(rs.getInt("TIPO_PAGO"));
                tipo.setDescripcion(rs.getString("DESCRIPCION"));
                                              
                lstTipo.add(tipo);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoTipoPago.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoTipoPago.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstTipo;
    }
    
    @Override
    public ModeloTipoPago list(int id) {
        try {            
            strSql = "SELECT * FROM TIPO_PAGO WHERE TIPO_PAGO = " + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {                
                tipo.setTipoCuenta(rs.getInt("TIPO_PAGO"));
                tipo.setDescripcion(rs.getString("DESCRIPCION"));
                                            
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoTipoPago.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoTipoPago.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return tipo;
    }
    
    @Override
    public boolean insertar(ModeloTipoPago tipo) {
         //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "INSERT INTO TIPO_PAGO (TIPO_PAGO,DESCRIPCION) "
                + "VALUES ( (SELECT ISNULL(MAX(TIPO_PAGO),0) + 1 FROM TIPO_PAGO), " +                   
                "'" + tipo.getDescripcion()+ "' " +
               
                ")";
        
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoTipoPago.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoTipoPago.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }
    
    @Override
    public boolean modificar(ModeloTipoPago tipo) {
         //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "UPDATE TIPO_PAGO " +
                 "SET " +
                "DESCRIPCION = '" + tipo.getDescripcion()+ "'" +
                 
                 "WHERE TIPO_PAGO =  " + tipo.getTipoCuenta();
                 
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoTipoPago.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoTipoPago.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }
    
    @Override
    public boolean eliminar(ModeloTipoPago tipo) {
         //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "DELETE TIPO_PAGO WHERE TIPO_PAGO = " + tipo.getTipoCuenta();
        
        
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoTipoPago.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoTipoPago.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }
    
}
