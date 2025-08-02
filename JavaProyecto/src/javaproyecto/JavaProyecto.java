/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaproyecto;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger
        
public class JavaProyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
   
            String usuario="root";
            String password="tokito";
            String url="jdbc:mysql://localhost:3306/proyecto";
            Connection cnx;
            Statement st;
            ResultSet rs;
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.getLogger (JavaProyecto.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex); 
            }
            
            try {
                cnx = DriverManager.getConnection(url, usuario, password);
                st=cnx.createStatement();
                rs=st.executeQuery("SELECT * FROM cargo");
                rs.next();
                do {
                    System.out.println(rs.getInt("id") + ":" + rs.getString("nombre") +":" + rs.getString("descripcion"));
                } while (rs.next ());
                
            }catch (SQLException ex) {
                System.getLogger(JavaProyecto.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            }
        }
