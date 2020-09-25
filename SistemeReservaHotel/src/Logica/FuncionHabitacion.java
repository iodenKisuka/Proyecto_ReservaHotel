
package Logica;

import Datos.Vhabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
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
        String[] registros= new String[8];
        totalRegistro = 0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL = "Select * from habitacion where piso like '%"+ buscar+"%' order by id_habitacion";
        
        try {
            Statement stateM = conec.createStatement();
            ResultSet resultS = stateM.executeQuery(sSQL);
            
            while(resultS.next()){
                registros[0]= resultS.getString("idhabitacion");
                registros[1]= resultS.getString("numero");
                registros[2]= resultS.getString("piso");
                registros[3]= resultS.getString("descripcion");
                registros[4]= resultS.getString("caracteristicas");
                registros[5]= resultS.getString("precio_diario");
                registros[6]= resultS.getString("estado");
                registros[7]= resultS.getString("tipo_habitacion");
                
                totalRegistro++;
                modelo.addRow(registros);
                return modelo;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return null;
        }
        return null;
        
    }
    
    public boolean insertar (Vhabitacion datos){
        sSQL="insert into habitacion (numero,piso,descripcion,caracteristicas,precio_diario,estado, tipo_habitacion)"+
                "value (?,?,?,?,?,?,?)";
        try {
            PreparedStatement prepareSt = conec.prepareStatement(sSQL) ;
            prepareSt.setString(1,datos.getNumero());
            prepareSt.setString(2,datos.getPiso());
            prepareSt.setString(3,datos.getDescripcion());
            prepareSt.setString(4,datos.getCaracteristicas());
            prepareSt.setDouble(5,datos.getPrecio_diario());
            prepareSt.setString(6,datos.getEstado());
            prepareSt.setString(7,datos.getTipo_habitacion());
            
            int num = prepareSt.executeUpdate();
            if(num!=0){
                return true;
            }
            else{
                return false;
            }
            
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return false;
        }
       
    }
     public boolean editar(Vhabitacion datos){
        sSQL="update habitacion set numero=?, piso=?,descripcion=?,caracteristicas=?,precio_diario=?,estado=?, tipo_habitacion=?"
                + " where idhabitacion=?";
        try {
            PreparedStatement prepareSt = conec.prepareStatement(sSQL) ;
            prepareSt.setString(1,datos.getNumero());
            prepareSt.setString(2,datos.getPiso());
            prepareSt.setString(3,datos.getDescripcion());
            prepareSt.setString(4,datos.getCaracteristicas());
            prepareSt.setDouble(5,datos.getPrecio_diario());
            prepareSt.setString(6,datos.getEstado());
            prepareSt.setString(7,datos.getTipo_habitacion());
            prepareSt.setInt(8,datos.getIdhabitacion());
            
            int num = prepareSt.executeUpdate();
            if(num!=0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return false;
        }
       
    }
     
      public boolean eliminar (Vhabitacion datos){
        sSQL="delete from habitacion where idhabitacion=?";
        try {
            
            PreparedStatement prepareSt = conec.prepareStatement(sSQL) ;
            prepareSt.setInt(1,datos.getIdhabitacion());
            
            int num = prepareSt.executeUpdate();
            if(num!=0){
                return true;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
           return false;
        }
       
    }
 
 
    
}
