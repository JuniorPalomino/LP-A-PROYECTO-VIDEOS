/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author USUARIO
 */
public class conexion {
    public String db="basereserva"; //nombre de la base de datos
    public String url="jdbc:mysql://127.0.0.1/" +db; //conexion localhost + nombre de la base de datos
    public String user="root"; //usuario localhost
    public String pass=""; //contraseña localhost
    
    //constructor vacio
    public conexion() {
    }
    
    //metodo conectar de "import java.sql.Connection;"
    public Connection conectar(){
        //objeto inicializa en nulo
        Connection link=null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver"); //cargamos el driver de la conexion adjuntandon la ubicacion del driver  
            link=DriverManager.getConnection(this.url, this.user, this.pass); //agrega los atributos en este caso serian la url, usuario, contraseña
            
        } catch (ClassNotFoundException | SQLException e) { //"EXCEPCIONES ESPECIFICAS" declamos las exceptiones de clase no encontrada y de sqlexceptio
            JOptionPane.showConfirmDialog(null, e); //muestra la exception de la conexion
            
        }
        
        return link;    //retorna link
    }
}
