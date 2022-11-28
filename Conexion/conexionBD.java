package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

class conexionBD {

    public String db = "basereserva"; //nombre de la base de datos
    public String url = "jdbc:mysql://127.0.0.1/" + db; //conexion localhost + nombre de la base de datos
    public String user = "root"; //usuario localhost
    public String pass = ""; //contraseña localhost

    //constructor vacio
    public conexionBD() {
    }

    //metodo conectar de "import java.sql.Connection;"
    public Connection conectar() {
        //objeto inicializa en nulo
        Connection link = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver"); //cargamos el driver de la conexionBD adjuntandon la ubicacion del driver  
            link = DriverManager.getConnection(this.url, this.user, this.pass); //agrega los atributos en este caso serian la url, usuario, contraseña

        } catch (ClassNotFoundException | SQLException e) { //"EXCEPCIONES ESPECIFICAS" declamos las exceptiones de clase no encontrada y de sqlexceptio
            JOptionPane.showConfirmDialog(null, e); //muestra la exception de la conexionBD
        }
        return link;    //retorna link
    }
}
