
package org.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {    
    
    private PreparedStatement preparar = null;    
    private  Connection coneccion=null;    
    private ResultSet resultado = null;
    
    
    //Driver o controlador JDBC
     String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    public Connection open() throws ClassNotFoundException{        
        try { 
            
            
                      String stringConnectionUrl = "jdbc:sqlserver://localhost:1433;" +
                                "databaseName=NEGOCIO";
               
          
                Class.forName(driver);
                coneccion = DriverManager.getConnection(stringConnectionUrl,"UMG","12345678");
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);            
            System.out.println("Excepción: " + e.getMessage());
        }
        return coneccion;
    }
    
    public void close() throws Exception{
        //Connection coneccion = null;
        try {
            if (coneccion != null){
                coneccion.clearWarnings();
                coneccion.close();                
            }
        } catch (SQLException e) {
            coneccion = null;
            throw new Exception(e.getMessage());
        }

    }
    
    public boolean executeSql (String cmd) throws Exception{
            if (cmd != null)
            try {
                    this.preparar = this.coneccion.prepareStatement(cmd);
                    this.preparar.executeUpdate();
            } catch (SQLException e) {
                    throw new Exception(e.getMessage());
            }
            else
                    throw new Exception("El comando a ejecutar es nulo!");
            return true;
    }
    
        public void commit () throws Exception{
          
            try {
                    coneccion.commit();
            } catch (SQLException e) {
                    throw new Exception(e.getMessage());
            }
          
               
    }
        
                public void rollbak () throws Exception{
          
            try {
                    coneccion.rollback();
            } catch (SQLException e) {
                    throw new Exception(e.getMessage());
            }
          
               
    }
        
    public void begin () throws Exception{
          
            try {
                    
                   coneccion.setAutoCommit(false);
            } catch (SQLException e) {
                    throw new Exception(e.getMessage());
            }
          
               
    }
	
    public ResultSet executeQuery (String strSQL){
        
            if (strSQL != null)
            try {        
                    
                    preparar = coneccion.prepareStatement(strSQL);                    
                    resultado = preparar.executeQuery();	
            } catch (SQLException e) {                    
                System.out.println("Error al ejecutar el query en Clase: Conexion: " + e.toString());
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            }
            //close();
            return resultado;
    }
    
        public String onedato (String strSQL) throws SQLException{
        String dato=null;
            if (strSQL != null)
            try {        
                    
                    preparar = coneccion.prepareStatement(strSQL);   
                    resultado = preparar.executeQuery();
                    if(!resultado.wasNull()){
                  
                  while(resultado.next()){
                     dato=resultado.getString(1);
                    break;
                  }
                  resultado.close();
                    }else{
                        dato="";
                    }
              //     dato = resultado.getString(1);
       
            } catch (SQLException e) {                    
                System.out.println("Error al ejecutar el query en Clase: Conexion: " + e.toString());
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            }
            //close();
            return dato;
    }
    
}
