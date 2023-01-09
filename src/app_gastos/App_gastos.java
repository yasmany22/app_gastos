/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app_gastos;

import Entidades.Mis_gastos;
import Modelos.Coneccion;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bethecoder.ascii_table.ASCIITable;
import com.bethecoder.ascii_table.impl.JDBCASCIITableAware;
import com.bethecoder.ascii_table.spec.IASCIITableAware;

/**
 *
 * @author Yasmany
 */
public class App_gastos {

      /**
     * @param args the command line arguments
     * 
     * 
     *  Revise los siguientes artículos "Java: JDBC – 6. Statement y ResultSet Links to an external site."
        Escriba un programa que permita ejecutar las siguientes actividades en la base de datos configurada anteriormente, en caso de no tener creada su base de datos puede ejecutar el script adjunto para generar la tabla en su base de datos.
        Escriba un programa JAVA que ejecute las siguientes operaciones sobre la base de datos:

     *   Eliminar el ítem "Ps4 Juego"
     *   Actualizar el valor de despensa por 23,78
     *   Ingresar un ítem de compra en la fecha actual
     *   Recuperar todos los items.
     *   Subir el código a github así como una captura de la tabla compras luego de ejecutar el programa.

        Adjuntar el enlace a su proyecto en la actividad.
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
        * 
     */
    
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        Coneccion conn = new Coneccion().conectar();
      
        System.out.println("**** Información Inicial ******");
        // Imprimir tabla método creado..
        imprimir();
        
       
        // ***** Eliminar el ítem "Ps4 Juego"      
        try {
            String sql ;
            // Dos maneras
            // sentencia para eliminación por detalle
            sql = "DELETE FROM mis_gastos WHERE detalle='Ps4 Juego';";
           // o para eliminación por id_gasto
           // sql = "DELETE FROM mis_gastos WHERE id_gasto=1;";

           if (conn.ejecutar(sql)) {
                System.out.println("Eliminación de item Ps4 en tabla !!");
            } else {
                System.out.println("Ocurrió un problema al ejecutar!");
            } 
        } catch (Exception e) {
        }
        
        
        
      
        //*****   Actualizar el valor de despensa por 23,78
        try {
            String sql ;
            
            sql = "UPDATE mis_gastos SET valor='23,78' WHERE id_gasto=6;";
          
           if (conn.ejecutar(sql)) {
                System.out.println("Actualizado correctamente item Despensa en tabla !!");
            } else {
                System.out.println("Ocurrió un problema al ejecutar!");
            } 
        } catch (Exception e) {
        }
        
        
        
      
        // ******  Ingresar un ítem de compra en la fecha actual
        
        try {
            Mis_gastos gastos = new Mis_gastos();
            
            String sql ;
            gastos.setTipo_gasto("Ocio");
            gastos.setDetalle("Equipo de Sonido");
            gastos.setValor("150");
            // objeto tipo Date
            java.util.Date date=new java.util.Date();
            java.sql.Date sqlDate=new java.sql.Date(date.getTime());
            gastos.setFecha(sqlDate);
            System.out.println("fecha: "+String.valueOf(sqlDate));
            
            sql = "INSERT INTO mis_gastos(tipo_gasto,detalle,valor,fecha) VALUES('"+gastos.getTipo_gasto()+"','"+gastos.getDetalle()+"','"+gastos.getValor()+"','"+String.valueOf(gastos.getFecha())+"');";
          
            if (conn.ejecutar(sql)) {
                System.out.println("Item ingresado correctamente con fecha actual en tabla !!");
            } else {
                System.out.println("Ocurrió un problema al ejecutar!");
            } 
        } catch (Exception e) {
        }
        
               
        System.out.println("-----Recuperar Items -----");        
        ResultSet resultados = conn.consultar("SELECT * FROM bd_gastos");  
         
        // el valor es leido como booleano en java con el método resultados.getBoolean()
        if (resultados != null) {
            try {
                System.out.println("  Id gasto     Tipo Gasto   Detalle    Valor    Fecha");
                System.out.println("-------------------------------------------------------------------------------------------");
                while (resultados.next()) {
                    System.out.println(""+resultados.getInt("id_gasto")+"        "+resultados.getString("tipo_gasto")+"       "+resultados.getString("detalle")+"       "+resultados.getString("valor")+"       "+String.valueOf(resultados.getDate("Fecha")));
                }
            } catch (SQLException e) {
            }
        }
        
      
        // Recuperar todos lo items.
         imprimir();
         
       
     
    }
    
    /**
     * Función para imprimir la tabla de base de datos, usando libreria ASCIITable y su método
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
     private static void imprimir() throws ClassNotFoundException, SQLException {
        // Obtenemos la conección
        Coneccion conn = new Coneccion().conectar();
        // Se imprime la tabla gastos
        IASCIITableAware asciiTableAware = new JDBCASCIITableAware(
            conn.getConexion(), "select * from mis_gastos");
        ASCIITable.getInstance().printTable(asciiTableAware);

  }
}
