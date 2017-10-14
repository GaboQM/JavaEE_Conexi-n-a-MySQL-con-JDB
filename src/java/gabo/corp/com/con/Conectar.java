/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gabo.corp.com.con;
 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gaboqm
 */
public class Conectar {
   private Connection con;
   private PreparedStatement consulta;
   private ResultSet datos;
   private String server,user,bd,pass;
   

   public Conectar(){
       this.server="localhost";
       this.bd="testeo_db";
       this.user="root";
       this.pass="";
   }
   
   public void con() throws ClassNotFoundException, SQLException{
       try{
       Class.forName("com.mysql.jdbc.Driver");
       this.con=DriverManager.getConnection("jdbc:mysql://"+this.server+"/"+this.bd,this.user,this.pass);
       
       }catch(ClassNotFoundException e){
       e.printStackTrace();
   }
   }
   
   public void desconectar() throws SQLException{
       this.con.close();
   }
    public ResultSet getDatos() throws ClassNotFoundException, SQLException{
        this.con();
        this.consulta=this.con.prepareStatement("SELECT *FROM prueba_tabla");
        this.datos=this.consulta.executeQuery();
       return  this.datos;
        
    }
}
