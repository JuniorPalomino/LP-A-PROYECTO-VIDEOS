/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author USUARIO
 */
public class vhabitacion {

    //creacion de atributos de la base de datos de "habitacion"
    private int idhabitacion;
    private String numero;
    private String piso;
    private String descripcion;
    private String caracteristicas;
    private Double precio_diario;
    private String estado;
    private String tipo_habitacion;

    //constructor de la clase "vhabitacion"
    public vhabitacion(int idhabitacion, String numero, String piso, String descripcion, String caracteristicas, Double precio_diario, String estado, String tipo_habitacion) {
        this.idhabitacion = idhabitacion;
        this.numero = numero;
        this.piso = piso;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.precio_diario = precio_diario;
        this.estado = estado;
        this.tipo_habitacion = tipo_habitacion;
    }

    //constructor vacio
    public vhabitacion() {
    }

    //GETS
    public int getIdhabitacion() {
        return idhabitacion;
    }

    public String getNumero() {
        return numero;
    }

    public String getPiso() {
        return piso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public Double getPrecio_diario() {
        return precio_diario;
    }

    public String getTipo_habitacion() {
        return tipo_habitacion;
    }

    public String getEstado() {
        return estado;
    }

    //SETS
    public void setIdhabitacion(int idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public void setPrecio_diario(Double precio_diario) {
        this.precio_diario = precio_diario;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTipo_habitacion(String tipo_habitacion) {
        this.tipo_habitacion = tipo_habitacion;
    }

}
