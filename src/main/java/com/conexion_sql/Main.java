package com.conexion_sql;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conexion = ConexionBase.obtenerConexion();
        ConexionBase.cerrarConexion();
    }
}