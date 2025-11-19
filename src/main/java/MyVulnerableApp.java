package src.main.java;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class MyVulnerableApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String userInput = scanner.nextLine(); // Fuente de datos contaminados (Source)

        // Construcción vulnerable de la consulta: SQL Injection
        String query = "SELECT * FROM users WHERE username = '" + userInput + "';"; 

        try {
            Connection c = null; // Simula la conexión
            Statement s = c.createStatement();
            s.executeQuery(query); // Sumidero (Sink)

        } catch (Exception e) {
            // Manejo de errores
        }
    }
}
