/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.modelos.ModeloRenta;
import org.interfaces.CrudRenta;


public class DaoRenta implements CrudRenta{
    
    //Se crea un objeto publico del Cliente
    ModeloRenta renta = new ModeloRenta();
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
        ArrayList<ModeloRenta>lstRenta = new ArrayList<>();
         try {            
            strSql = "SELECT * FROM RENTA";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModeloRenta renta = new ModeloRenta();
                renta.setIdrenta(rs.getInt("ID_RENTA"));
                renta.setIdvehiculo(rs.getInt("ID_VEHICULO"));
                renta.setPrecio(rs.getDouble("PRECIO"));
                renta.setFechaini(rs.getString("FECHA_INI"));
                renta.setFechafin(rs.getString("FECHA_FIN"));
                renta.setIdcliente(rs.getInt("ID_CLIENTE"));
                renta.setTipopago(rs.getInt("TIPO_PAGO"));
                
                                
                lstRenta.add(renta);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoRenta.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoRenta.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstRenta;
    }
    
    @Override
    public ModeloRenta list(int id) {
        try {            
            strSql = "SELECT * FROM RENTA WHERE ID_RENTA = " + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {                
           renta.setIdrenta(rs.getInt("ID_RENTA"));
                renta.setIdvehiculo(rs.getInt("ID_VEHICULO"));
                renta.setPrecio(rs.getDouble("PRECIO"));
                renta.setFechaini(rs.getString("FECHA_INI"));
                renta.setFechafin(rs.getString("FECHA_FIN"));
                 renta.setIdcliente(rs.getInt("ID_CLIENTE"));
                 renta.setTipopago(rs.getInt("TIPO_PAGO"));
             
                             
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoRenta.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoRenta.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return renta;
    }

    @Override
    public boolean insertar(ModeloRenta rent) {
         boolean hayerror=false;
    

         //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "INSERT INTO RENTA (ID_RENTA,ID_VEHICULO,PRECIO,FECHA_INI,FECHA_FIN,ID_CLIENTE,TIPO_PAGO) "
                + "VALUES ( (SELECT ISNULL(MAX(X.ID_RENTA),0)+1 FROM RENTA X), " +                   
                "" + rent.getIdvehiculo()+ ", " +                 
                "" + rent.getPrecio()+ ", " +       
                "'" + rent.getFechaini()+ "', " +
                 "'" + rent.getFechafin()+ "'," +
                "" + rent.getIdrenta()+ "," +
                "'" + rent.getTipopago()+ "'" +
                ")";
    
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            
            conexion.begin();  ///INICIA LA TRANSACCION
            
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            
            
            
        String sql="UPDATE VEHICULO SET ESTATUS = 'RESERVADO' WHERE ID="+rent.getIdvehiculo();
    
        respuesta = conexion.executeSql(sql);
        
        hayerror= false;
        
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoRenta.class.getName()).log(Level.SEVERE, null, ex);     
                hayerror=true;
        } catch(Exception ex){
            hayerror=true;
            Logger.getLogger(DaoRenta.class.getName()).log(Level.SEVERE, null, ex);            
        } finally{
        if(!hayerror){
            try {
                conexion.commit(); //FINALIZA LA TRANSACCION Y HACE COMMIT;
                conexion.close();
            } catch (Exception ex) {
                Logger.getLogger(DaoRenta.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }else{
            try {
                conexion.rollbak();//FINALIZA LA TRANSACCION Y HACE ROLLBACK
                conexion.close();
            } catch (Exception ex) {
                Logger.getLogger(DaoRenta.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
        }
        return respuesta;
    }

     @Override
    public boolean modificar(ModeloRenta mov) {
         //Se prepara la sentencia SQL a ejecutar en la BD

                 
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
          //  respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoRenta.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoRenta.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }

     @Override
    public boolean eliminar(ModeloRenta mov) {
         //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "DELETE RENTA WHERE ID_RENTA = " + mov.getIdrenta();
        String str2 = "select ID_VEHICULO from RENTA WHERE ID_RENTA = " + mov.getIdrenta();
        
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            
            int idv= Integer.parseInt(conexion.onedato(str2));
            
              String sql="UPDATE VEHICULO SET ESTATUS = 'DISPONIBLE' WHERE ID="+idv;
                
               respuesta = conexion.executeSql(strSql);
               respuesta = conexion.executeSql(sql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoRenta.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoRenta.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }


    
    
}
