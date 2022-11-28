package Conexion;

import Clases.claseTrabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class conexionTrabajador {

    private conexionBD mysql = new conexionBD();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nombre", "Apaterno", "Amaterno", "Doc", "Número Documento", "Dirección", "Teléfono", "Email", "Sueldo", "Acceso", "Login", "Clave"};
        String[] registro = new String[14]; //indices segun la variable "titulos"
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select p.idpersona,p.nombre,p.apaterno,p.amaterno,p.tipo_documento,p.num_documento,"
                + "p.direccion,p.telefono,p.email,t.sueldo,t.acceso,t.login,t.password from persona p inner join Trabajador t "
                + "on p.idpersona=t.idpersona where num_documento like '%"
                + buscar + "%' order by idpersona desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apaterno");
                registro[3] = rs.getString("amaterno");
                registro[4] = rs.getString("tipo_documento");
                registro[5] = rs.getString("num_documento");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("telefono");
                registro[8] = rs.getString("email");
                registro[9] = rs.getString("sueldo");
                registro[10] = rs.getString("acceso");
                registro[11] = rs.getString("login");
                registro[12] = rs.getString("password");
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    //
    public boolean insertar(claseTrabajador dts) {
        sSQL = "insert into persona (nombre,apaterno,amaterno,tipo_documento,num_documento,direccion,telefono,email)" + "values (?,?,?,?,?,?,?,?)";       
                //se inserta en persona, base de datos
        sSQL2 = "insert into trabajador (idpersona,sueldo,acceso,login,password)" + "values ((select idpersona from persona order by idpersona desc limit 1),?,?,?,?)"; 
                //se inserta en cliente, base de datos
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); // Insercion  persona
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);  // Insercion cliente

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApaterno());
            pst.setString(3, dts.getAmaterno());
            pst.setString(4, dts.getTipo_documento());
            pst.setString(5, dts.getNum_documento());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getTelefono());
            pst.setString(8, dts.getEmail());
            pst2.setDouble(1, dts.getSueldo());
            pst2.setString(2, dts.getAcceso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getPassword());
            int n = pst.executeUpdate();
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(claseTrabajador dts) {
        sSQL = "update persona set nombre=?,apaterno=?,amaterno=?,tipo_documento=?,num_documento=?," + " direccion=?,telefono=?,email=? where idpersona=?";
                //se inserta en persona, base de datos
        sSQL2 = "update trabajador set sueldo=?,acceso=?,login=?,password=?" + " where idpersona=?";
                //se inserta en cliente, base de datos
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApaterno());
            pst.setString(3, dts.getAmaterno());
            pst.setString(4, dts.getTipo_documento());
            pst.setString(5, dts.getNum_documento());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getTelefono());
            pst.setString(8, dts.getEmail());
            pst.setInt(9, dts.getIdpersona());
            pst2.setDouble(1, dts.getSueldo());
            pst2.setString(2, dts.getAcceso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getPassword());
            pst2.setInt(5, dts.getIdpersona());
            int n = pst.executeUpdate();
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(claseTrabajador dts) {
        sSQL = "delete from trabajador where idpersona=?";
        //elimina IDpersona de la tabla trabajador, base de datos
        sSQL2 = "delete from persona where idpersona=?";
        //elimina IDpersona de la tabla persona, base de datos
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            pst.setInt(1, dts.getIdpersona());
            pst2.setInt(1, dts.getIdpersona());
            int n = pst.executeUpdate();
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public DefaultTableModel login(String login, String password) {
        //Recibe como parametro login y contraseña
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nombre", "Apaterno", "Amaterno", "Acceso", "Login", "Clave"};
        String[] registro = new String[7];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select p.idpersona,p.nombre,p.apaterno,p.amaterno," + "t.acceso,t.login,t.password from persona p inner join Trabajador t " + "on p.idpersona=t.idpersona where t.login='"
                + login + "' and t.password='" + password + "' and t.acceso='Administrador'or t.acceso= 'Digitador'";    
        //Validar si el trabajor es administrador o digitador
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apaterno");
                registro[3] = rs.getString("amaterno");
                registro[4] = rs.getString("acceso");
                registro[5] = rs.getString("login");
                registro[6] = rs.getString("password");
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
}
