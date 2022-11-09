/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import Datos.vhabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author USUARIO
 */
public class fhabitacion {
    
    private conexion mysql = new conexion(); //creacion de instacia de conexion
    private Connection cn = mysql.conectar(); //creamos un objeto a Connection y declaramos la funcion "conectar"
    private String sSQL=""; //declaramos un string para almacenar cadena de conexion
    public int totalregistros; //utilizaremos para contar el total de registros que se hagan
//Usamos diversos metodos para cambiar y operar los atributos de la habitacion   
   public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","Numero","Piso","Descripcion","Caracteristicas","Precio","Estado","Tipo habitacion"};
       
       String [] registro =new String [8];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from habitacion where piso like '%"+ buscar + "%' order by idhabitacion";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idhabitacion");
               registro [1]=rs.getString("numero");
               registro [2]=rs.getString("piso");
               registro [3]=rs.getString("descripcion");
               registro [4]=rs.getString("caracteristicas");
               registro [5]=rs.getString("precio_diario");
               registro [6]=rs.getString("estado");
               registro [7]=rs.getString("tipo_habitacion");
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
     } 
   
   
   public DefaultTableModel mostrarvista(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","Numero","Piso","Descripcion","Caracteristicas","Precio","Estado","Tipo habitacion"};
       
       String [] registro =new String [8];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from habitacion where piso like '%"+ buscar + "%' and estado='Disponible' order by idhabitacion";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idhabitacion");
               registro [1]=rs.getString("numero");
               registro [2]=rs.getString("piso");
               registro [3]=rs.getString("descripcion");
               registro [4]=rs.getString("caracteristicas");
               registro [5]=rs.getString("precio_diario");
               registro [6]=rs.getString("estado");
               registro [7]=rs.getString("tipo_habitacion");
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
     }
