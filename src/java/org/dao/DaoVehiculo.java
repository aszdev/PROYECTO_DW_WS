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
import org.modelos.ModeloVehiculo;


public class DaoVehiculo {
    
     //Se crea un objeto publico del Cliente
    ModeloVehiculo vehi = new ModeloVehiculo();
    //Variable para crear las sentencias SQL
    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();
    //Obtiene el resultado de las consultas SQL
    ResultSet rs = null;
    //flag para retornar si la sentencia SQL fue satisfactorio o no
    boolean respuesta = false;
    
    public List listar() {
        ArrayList<ModeloVehiculo>lstVehi = new ArrayList<>();
         try {            
            strSql = "SELECT * FROM VEHICULO";
             
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModeloVehiculo vehi = new ModeloVehiculo();
                vehi.setId(rs.getInt("ID"));
                vehi.setNombre(rs.getString("NOMBRE"));
                vehi.setEstatus(rs.getString("ESTATUS"));
                                              
                lstVehi.add(vehi);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoVehiculo.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoVehiculo.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstVehi;
    }
    

    public ModeloVehiculo list(int id) {
        try {            
            strSql = "SELECT * FROM VEHICULO WHERE ID = " + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {                
                vehi.setId(rs.getInt("ID"));
                vehi.setNombre(rs.getString("NOMBRE"));
                vehi.setEstatus(rs.getString("ESTATUS"));
                                            
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoVehiculo.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoVehiculo.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return vehi;
    }
    

    public boolean insertar(ModeloVehiculo ve) {
         //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "INSERT INTO VEHICULO (ID,NOMBRE,ESTATUS) "
                + "VALUES ( (SELECT ISNULL(MAX(ID),0) + 1 FROM VEHICULO), " +                   
                "'" + ve.getNombre()+ "', " +
                "'DISPONIBLE' " +
    
                ")";
        
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoVehiculo.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoVehiculo.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }
    

    
 
    
}
