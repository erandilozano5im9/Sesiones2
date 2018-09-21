/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ValidaSesionesServlet extends HttpServlet {
    
                    Connection conexion = null;
                    Statement stmt = null;
                    ResultSet r;
                    String nombre;
                    String password;
                    String nombreb;
                    String passwordb;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/lab3","root","n0m3l0"); 
        }catch(SQLException e){
            System.out.println("no jurula valida");  
        }
        try{
            stmt = conexion.createStatement();
            r = stmt.executeQuery("Select * from usuario where nombre ='"+nombre+"'");
            
            nombreb = r.getString("nombre");
            passwordb = r.getString("password");
            
        }catch(SQLException e){
            System.out.println("no consulta");
        }
        
        nombre = request.getParameter("nombre");
        password = request.getParameter("password");
        
      response.setContentType("text/html");
      
      if(nombre.equals(nombreb)&&password.equals(passwordb)){
      HttpSession sesion = request.getSession(true);
      sesion.setAttribute("usuario", nombre);
      }
      else{
          
      }

      //Mostramos los  valores en el cliente
      PrintWriter out = response.getWriter();
      out.println("<br>");
      
  
    }

}
