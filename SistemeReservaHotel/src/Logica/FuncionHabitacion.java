
package Logica;

import java.sql.Connection;
import javax.swing.table.DefaultTableModel;

public class FuncionHabitacion {
    private Conexion mysql = new Conexion();
    private Connection cn= mysql.conectar();
    private String sSQL="";
    public Integer totalRegistro;
    
    
    //  darle formato al contenido que va ir dentro de la tabla
    public DefaultTableModel mostrar (String buscar){
        DefaultTableModel modelo;
        // un arreglo con los nombre de las columnas
        String [] titulos={"ID ", "Número","Piso","Descripciónn", "Caracteristicas","Precio diario","Estado","Tipo de habitacion"};
        totalRegistro = 0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL = "Select * from habitacion where piso like '%"+ buscar+"%' order by id_habitacion";
        
        //Falta Try Catch y return
        
        
    }
 
    
}
