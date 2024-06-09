package com.conexion_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBase {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Agenda1";
    private static final String USUARIO = "sa";
    private static final String CONTRASEÑA = "sa";
    private static Connection conexion = null;

    private ConexionBase() {}

    /**
     * Metodo que abre la conexion con la base de datos
     * @return la conexion
     */
    public static Connection obtenerConexion() {
        if (conexion == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return conexion;
    }

    /** 
     * Metodo que cierra la conexion con la base de datos
     */
    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                conexion = null;
                System.out.println("\nConexión cerrada.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}