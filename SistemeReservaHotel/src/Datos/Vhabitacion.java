/*
 * V de variable
 */
package Datos;


public class Vhabitacion {
    private int idhabitacion;
    private String numero ;
    private String piso;
    private String descripcion;
    private String caracteristicas;
    private double precio_diario;
    private String estado;
    private String tipo_habitacion;

    public Vhabitacion(int idhabitacion, String numero, String piso, String descripcion, String caracteristicas, double precio_diario, String estado, String tipo_habitacion) {
        this.idhabitacion = idhabitacion;
        this.numero = numero;
        this.piso = piso;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.precio_diario = precio_diario;
        this.estado = estado;
        this.tipo_habitacion = tipo_habitacion;
    }

    public Vhabitacion() {
    }
    
    
    
    
    
}
