package Conexion;

import Clases.clasePago;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class conexionPago {

    private conexionBD mysql = new conexionBD();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        //usamos el constructor para declarar las variables que usamos
        String[] titulos = {"ID", "Idreserva", "Comprobante", "Número", "Igv", "Total", "Fecha Emisión", "Fecha Pago"};
        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select * from pago where idreserva=" + buscar + " order by idpago desc";
//select para obtener todos los datos where para mostrar los datso que pertenescan a la reserva que se indica como parametro
//en este caso y el order by para que se muestre los paos mas resientes al final
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                //aqui acamodo los indices segun el orden de arriba
                registro[0] = rs.getString("idpago");
                registro[1] = rs.getString("idreserva");
                registro[2] = rs.getString("tipo_comprobante");
                registro[3] = rs.getString("numero_comprobante");
                registro[4] = rs.getString("igv");
                registro[5] = rs.getString("total_pago");
                registro[6] = rs.getString("fecha_emision");
                registro[7] = rs.getString("fecha_pago");
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(clasePago dts) { //vpago que se almacena en dts que es el objeto
        sSQL = "insert into pago (idreserva,tipo_comprobante,numero_comprobante,igv,total_pago,fecha_emision,fecha_pago)" + "values (?,?,?,?,?,?,?)";
        try {
            //actuzalimos los campos que se envian a dts que es el objeto 
            //lo que envia los parametros al sql
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdreserva());
            pst.setString(2, dts.getTipo_comprobante());
            pst.setString(3, dts.getNum_comprobante());
            pst.setDouble(4, dts.getIgv());
            pst.setDouble(5, dts.getTotal_pago());
            pst.setDate(6, (Date) dts.getFecha_emision());
            pst.setDate(7, (Date) dts.getFecha_pago());
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(clasePago dts) {
        sSQL = "update pago set idreserva=?,tipo_comprobante=?,numero_comprobante=?,igv=?,total_pago=?,fecha_emision=?,fecha_pago=?" + " where idpago=?";
        //update de los parametros antes de declarados para esta funcion

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdreserva());
            pst.setString(2, dts.getTipo_comprobante());
            pst.setString(3, dts.getNum_comprobante());
            pst.setDouble(4, dts.getIgv());
            pst.setDouble(5, dts.getTotal_pago());
            pst.setDate(6, (Date) dts.getFecha_emision());
            pst.setDate(7, (Date) dts.getFecha_pago());

            //añadimos este ulimo ya que el Idpago que actuzalizamos debe tener ese ultimo valor
            pst.setInt(8, dts.getIdpago());
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(clasePago dts) {
        sSQL = "delete from pago where idpago=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdpago());  //mediate el head idpago se elminan 
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
