
package Logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class FuncionHabitacion {
    private Conexion mysql = new Conexion();
    private Connection conec= mysql.conectar();
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
        try {
            Statement stateM = conec.createStatement();
            ResultSet resultS = stateM.executeQuery(sSQL);
            
            while(resultS.next()){
                registro[0]= resultS.getString("idhabitacion");
            }
            
        } catch (Exception e) {
            
            
        }
        
    }
 
    
}
