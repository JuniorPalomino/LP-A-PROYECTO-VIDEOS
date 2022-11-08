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
}
