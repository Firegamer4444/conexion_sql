package com.conexion_sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OperacionesCRUD {

    /**
     * Metodo que realiza la inserccion de un contacto
     * @param contacto contacto que se va a insertar
     */
    public void insertarContacto(Contacto contacto) {
        String sql = "INSERT INTO dbo.contactos (Nombre, Apellidos, DNI, Telefono, Ecorreo, Fechacumple, Direccion, Poblacion, Provincia, CodigoPostal, Categoria, Deuda) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conexion = ConexionBase.obtenerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, contacto.getNombre());
            pstmt.setString(2, contacto.getApellidos());
            pstmt.setString(3, contacto.getDni());
            pstmt.setString(4, contacto.getTelefono());
            pstmt.setString(5, contacto.getEcorreo());
            pstmt.setDate(6, java.sql.Date.valueOf(contacto.getFechacumple()));
            pstmt.setString(7, contacto.getDireccion());
            pstmt.setString(8, contacto.getPoblacion());
            pstmt.setInt(9, contacto.getProvincia());
            pstmt.setString(10, contacto.getCodigoPostal());
            pstmt.setString(11, contacto.getCategoria());
            pstmt.setInt(12, contacto.getDeuda());
            pstmt.executeUpdate();

            // Obtener el ID generado automáticamente
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    contacto.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("No se pudo obtener el ID del contacto insertado.");
                }
            }
            System.out.println("Contacto insertado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que lee los contactos y los imprime por pantalla
     */
    public void leerContactos() {
        String sql = "SELECT * FROM dbo.contactos";
        
        try (Connection conexion = ConexionBase.obtenerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("-------------------------");
                System.out.println("Id_contacto: " + rs.getInt("Id_contacto"));
                System.out.println("Nombre: " + rs.getString("Nombre"));
                System.out.println("Apellidos: " + rs.getString("Apellidos"));
                System.out.println("DNI: " + rs.getString("DNI"));
                System.out.println("Telefono: " + rs.getString("Telefono"));
                System.out.println("Ecorreo: " + rs.getString("Ecorreo"));
                System.out.println("Fechacumple: " + rs.getString("Fechacumple"));
                System.out.println("Direccion: " + rs.getString("Direccion"));
                System.out.println("Poblacion: " + rs.getString("Poblacion"));
                System.out.println("Provincia: " + rs.getString("Provincia"));
                System.out.println("CodigoPostal: " + rs.getString("CodigoPostal"));
                System.out.println("Categoria: " + rs.getString("Categoria"));
                System.out.println("Deuda: " + rs.getString("Deuda"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que realiza la actualizacion de un contacto
     * @param contacto contacto con la los datos que se van a actualizar 
     */
    public void actualizarContacto(Contacto contacto) {
        String sql = "UPDATE dbo.contactos SET Telefono = ?, Ecorreo = ? WHERE Id_contacto = ?";
        
        try (Connection conexion = ConexionBase.obtenerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, contacto.getTelefono());
            pstmt.setString(2, contacto.getEcorreo());
            pstmt.setInt(3, contacto.getId());
            pstmt.executeUpdate();
            System.out.println("Contacto actualizado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que realiza el borrado de un contacto
     * @param id id del contacto que se va a borrar
     */
    public void borrarContacto(int id) {
        String sql = "DELETE FROM dbo.contactos WHERE Id_contacto = ?";
        
        try (Connection conexion = ConexionBase.obtenerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Contacto borrado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que realiza la inserccion de una categoria
     * @param categoria catehoria que se va a insertar
     */
    public void insertarCategoria(Categorias categoria) {
        String sql = "INSERT INTO dbo.categorias VALUES (?, ?)";
        
        try (Connection conexion = ConexionBase.obtenerConexion();
            PreparedStatement pstmt = conexion.prepareStatement(sql)){
            pstmt.setString(1, categoria.getCategoria());
            pstmt.setString(2, categoria.getDescripcion());
            pstmt.executeUpdate();
            System.out.println("Categoria insertada con éxito.");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** 
     * Metodo que lee las categorias y las imprime por pantalla
     */
    public void leerCategorias(){
        String sql = "SELECT * FROM dbo.categorias";
        try (Connection conexion = ConexionBase.obtenerConexion();
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("-------------------------");
                System.out.println("Categoria: " + rs.getString("Categoria"));
                System.out.println("Descripcion: " + rs.getString("Descripcion"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que realiza la actualizacion de una categoria
     * @param categoria categoria con la categoria que se va a actualizar
     */
    public void actualizarCategoria(Categorias categoria){
        String sql = "UPDATE dbo.categorias SET Descripcion = ? WHERE Categoria = ?";
        try (Connection conexion = ConexionBase.obtenerConexion();
            PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, categoria.getDescripcion());
            pstmt.setString(2, categoria.getCategoria());
            pstmt.executeUpdate();
            System.out.println("Categoria actualizada con éxito.");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que realiza el borrado de una categoria
     * @param categoria categoria de la categoria que se va a borrar
     */
    public void borrarCategoria(String categoria){
        String sql = "DELETE FROM dbo.categorias WHERE Categoria = ?";
        try (Connection conexion = ConexionBase.obtenerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, categoria);
            pstmt.executeUpdate();
            System.out.println("Categoria borrada con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo pque realiza la inserccion de una provincia
     * @param provincia
     */
    public void insertarProvincia(Provincias provincia){
        String sql = "INSERT INTO dbo.provincias (NombreProvincia) VALUES ()";
        try (Connection conexion = ConexionBase.obtenerConexion();
            PreparedStatement pstmt = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
            pstmt.setString(1, provincia.getNombreProvincia());
            pstmt.executeUpdate();
        
            // Obtener la provincia generada automaticamente
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    provincia.setProvincia((generatedKeys.getInt(1)));
                } else {
                    throw new SQLException("No se pudo obtener la provincia de la provincia insertada.");
                }
            }
            System.out.println("Provincia insertada con éxito.");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Metodo que lee las provincias y las imprime por pantalla
     */
    public void leerPovincias(){
        String sql = "SELECT * FROM dbo.provincias";
        try (Connection conexion = ConexionBase.obtenerConexion();
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()){
            while (rs.next()){
                System.out.println("-------------------------");
                System.out.println("Provincia: " + rs.getInt("Provincia"));
                System.out.println("Nombe de provincia: " + rs.getString("NombreProvincia"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que realiza la actualizacion de una provincia
     * @param provincia provincia que se va a actualizar 
     */
    public void actualizarProvincia(Provincias provincia){
        String sql = "UPDATE dbo.provincias SET NombreProvincia = ? WHERE Provincia = ?";
        try (Connection conexion = ConexionBase.obtenerConexion();
            PreparedStatement pstmt = conexion.prepareStatement(sql)){
            pstmt.setString(1, provincia.getNombreProvincia());
            pstmt.setInt(2, provincia.getProvincia());
            pstmt.executeUpdate();
            System.out.println("Provincia se ha actualizado con exito");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que realiza el borrado de una provincia
     * @param provincia provincia de la provincia que se va a borrar
     */
    public void borrarProvincia(int provincia){
        String sql = "DELETE FROM dbo.provincia WHERE Provicia = ?";
        try (Connection conexion = ConexionBase.obtenerConexion();
            PreparedStatement pstmt = conexion.prepareStatement(sql)){
            pstmt.setInt(1, provincia);
            pstmt.executeUpdate();
            System.out.println("Provincia se ha borrado con exito");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}