package src.main.java;

import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest; // Se necesita para simular una app web

public class MyVulnerableApp {
    // Método simulado que recibe una petición HTTP
    public void processRequest(HttpServletRequest request) { 

        // FUENTE (Source): CodeQL siempre detecta los parámetros HTTP como datos contaminados.
        String userInput = request.getParameter("username"); 

        // Construcción vulnerable de la consulta: SQL Injection
        String query = "SELECT * FROM users WHERE username = '" + userInput + "';"; 

        try {
            Connection c = null; 
            Statement s = c.createStatement();
            s.executeQuery(query); // SUMIDERO (Sink)

        } catch (Exception e) {
            // Manejo de errores
        }
    }
}
