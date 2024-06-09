package com.conexion_sql;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menuPrincipal();
    }

    /**
     * Menu principal del programa
     */
    public static void menuPrincipal(){
    	OperacionesCRUD operacionesCRUD = new OperacionesCRUD();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        while (true){
            System.out.println("\nMenú principal");
            System.out.println("1. Operaciones CRUD contactos");
            System.out.println("2. Operaciones CRUD categorias");
            System.out.println("3. Operaciones CRUD provincias");
            System.out.println("4. Cerrar programa");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    menuContactos(operacionesCRUD, scanner);
                    break;
                case 2:
                    menuCategorias(operacionesCRUD, scanner);
                    break;
                case 3:
                    menuProvincias(operacionesCRUD, scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

            
        }
    }

    /**
     * Menu para realizar las operaciones CRUD de la tabla contactos
     * @param operacionesCRUD objeto para realizar las operaciones
     * @param scanner scanner
     */
    public static void menuContactos(OperacionesCRUD operacionesCRUD , Scanner scanner){
        int opcion;
        while (true) {
            System.out.println("\nMenú de Operaciones CRUD");
            System.out.println("1. Insertar Contacto");
            System.out.println("2. Leer Contactos");
            System.out.println("3. Actualizar Contacto");
            System.out.println("4. Borrar Contacto");
            System.out.println("5. volver al menu principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    insertarContacto(operacionesCRUD, scanner);
                    break;
                case 2:
                    operacionesCRUD.leerContactos();
                    break;
                case 3:
                    actualizarContacto(operacionesCRUD, scanner);
                    break;
                case 4:
                    borrarContacto(operacionesCRUD, scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

            ConexionBase.cerrarConexion();
        }
    }

    /**
     * Menu para realizar las operaciones CRUD de la tabla categorias
     * @param operacionesCRUD objeto para realizar las operaciones
     * @param scanner scanner
     */
    public static void menuCategorias(OperacionesCRUD operacionesCRUD , Scanner scanner){
        int opcion;
        while (true) {
            System.out.println("\nMenú de Operaciones CRUD");
            System.out.println("1. Insertar Categorias");
            System.out.println("2. Leer Categorias");
            System.out.println("3. Actualizar Categoria");
            System.out.println("4. Borrar Categoria");
            System.out.println("5. volver al menu principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    insertarCategoria(operacionesCRUD, scanner);
                    break;
                case 2:
                    operacionesCRUD.leerCategorias();
                    break;
                case 3:
                    actualizarCategoria(operacionesCRUD, scanner);
                    break;
                case 4:
                    borrarCategoria(operacionesCRUD, scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

            ConexionBase.cerrarConexion();
        }
    }

    /**
     * Menu para realizar las operaciones CRUD de la tabla provincias 
     * @param operacionesCRUD objeto para realizar las operaciones
     * @param scanner scanner 
     */
    public static void menuProvincias(OperacionesCRUD operacionesCRUD , Scanner scanner){
        int opcion;
        while (true){
            System.out.println("\nMenú de Operaciones CRUD");
            System.out.println("1. Insertar provincia");
            System.out.println("2. Leer provincias");
            System.out.println("3. Actualizar provincia");
            System.out.println("4. Borrar provincia");
            System.out.println("5. volver al menu principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    insertarProvincia(operacionesCRUD, scanner);
                    break;
                case 2:
                    operacionesCRUD.leerPovincias();
                    break;
                case 3:
                    actualizarProvincia(operacionesCRUD, scanner);
                    break;
                case 4:
                    borrarProvincia(operacionesCRUD, scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

            ConexionBase.cerrarConexion();
        }
    }

    /**
     * Metodo que pide los datos que se quieren insertar en la tabla contactos
     * @param operacionesCRUD objeto para realizar la inserccion
     * @param scanner scanner
     */
    private static void insertarContacto(OperacionesCRUD operacionesCRUD, Scanner scanner) {
        System.out.print("Ingrese Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese Apellidos: ");
        String apellidos = scanner.nextLine();

        System.out.print("Ingrese DNI: ");
        String dni = scanner.nextLine();

        System.out.print("Ingrese Telefono: ");
        String telefono = scanner.nextLine();

        System.out.println("Ingrese Ecorreo: ");
        String ecorreo = scanner.nextLine();

        System.out.println("Ingrese Fecha de Cumpleaños (YYYY-MM-DD): ");
        String fechacumple = scanner.nextLine();

        System.out.print("Ingrese Dirección: ");
        String direccion = scanner.nextLine();

        System.out.println("Ingrese Población: ");
        String poblacion = scanner.nextLine();

        System.out.println("Ingrese Provincia (ID): ");
        int provincia = scanner.nextInt();

        System.out.println("Ingrese Código Postal: ");
        String codigoPostal = scanner.nextLine();

        System.out.println("Categoría: ");
        String categoria = scanner.nextLine();

        System.out.print("Ingrese Deuda: ");
        int deuda = scanner.nextInt();
        scanner.nextLine(); 

        Contacto contacto = new Contacto(0, nombre, apellidos, dni, telefono, ecorreo, fechacumple, direccion, poblacion, provincia, codigoPostal, categoria, deuda);
        operacionesCRUD.insertarContacto(contacto);
    }

    /**
     * Metodo que pide los datos para actualizar el telofono y el correo de un contacto
     * @param operacionesCRUD objeto para realizar las actualizacion
     * @param scanner scanner
     */
    private static void actualizarContacto(OperacionesCRUD operacionesCRUD, Scanner scanner) {
        System.out.print("Ingrese Id_contacto del contacto a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese nuevo Telefono: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese nuevo Ecorreo: ");
        String ecorreo = scanner.nextLine();

        Contacto contacto = new Contacto(id, null, null, null, telefono, ecorreo, null, null, null, 0, null, null, 0);
        operacionesCRUD.actualizarContacto(contacto);
    }

    /**
     * Metodo que pide el id del contacto que se quiere borrar
     * @param operacionesCRUD objeto para realizar el borrado
     * @param scanner scanner
     */
    private static void borrarContacto(OperacionesCRUD operacionesCRUD, Scanner scanner) {
        System.out.print("Ingrese Id_contacto del contacto a borrar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        operacionesCRUD.borrarContacto(id);
    }

    /**
     * Metodo que pide los datos para insertar una categoria
     * @param operacionesCRUD objeto para realizar la inserccion
     * @param scanner scanner
     */
    private static void insertarCategoria(OperacionesCRUD operacionesCRUD, Scanner scanner){
        System.out.println("Ingrese la categoria: ");
        String categoria = scanner.nextLine();

        System.out.println("Ingrese la descripcion: ");
        String descripcion = scanner.nextLine();

        Categorias categoria_ = new Categorias(categoria, descripcion);
        operacionesCRUD.insertarCategoria(categoria_);
    }

    /**
     * Metodo que pide los datos para actualizar una categoria
     * @param operacionesCRUD objeto para realizar la actualizacion
     * @param scanner scanner
     */
    private static void actualizarCategoria(OperacionesCRUD operacionesCRUD , Scanner scanner){
        System.out.println("Ingrese la categoria de la categoria a actualizar: ");
        String categoria = scanner.nextLine();

        System.out.println("Ingrese la descripcion: ");
        String descripcion = scanner.nextLine();

        Categorias categoria_ = new Categorias(categoria, descripcion);
        operacionesCRUD.actualizarCategoria(categoria_);
    }

    /**
     * Metodo que pide la categoria para borrar esa categoria
     * @param operacionesCRUD objeto para realizar el borrado
     * @param scanner scanner
     */
    private static void borrarCategoria(OperacionesCRUD operacionesCRUD , Scanner scanner){
        System.out.println("Ingrese la categoria de la categoria a borrar: ");
        String categoria = scanner.nextLine();

        operacionesCRUD.borrarCategoria(categoria);
    }

    /**
     * Metodo que pide los datos para insertar una provincia
     * @param operacionesCRUD objeto para realizar la inserccion
     * @param scanner scanner
     */
    private static void insertarProvincia(OperacionesCRUD operacionesCRUD , Scanner scanner){
        System.out.println("Introduzca el nombre de la provincia: ");
        String nombreProvincia = scanner.nextLine();

        Provincias provincia = new Provincias(0, nombreProvincia );
        operacionesCRUD.insertarProvincia(provincia);
    }

    /**
     * Metodo que pide los datos para actualizar una provincia
     * @param operacionesCRUD objeto para realizar la actualizacion
     * @param scanner scanner
     */
    private static void actualizarProvincia(OperacionesCRUD operacionesCRUD , Scanner scanner){
        System.out.println("Introduzca la provincia a actualizar: ");
        int provincia = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduzca el nombre de la provincia: ");
        String nombreProvincia = scanner.nextLine();

        Provincias provincia_ = new Provincias(provincia, nombreProvincia);
        operacionesCRUD.actualizarProvincia(provincia_);
    }

    /**
     * Metodo que pide la provincia para borrar esa provincia
     * @param operacionesCRUD objeto que realiza el borrado
     * @param scanner scanner
     */
    private static void borrarProvincia(OperacionesCRUD operacionesCRUD , Scanner scanner){
        System.out.println("Introduzca la provincia a borrar: ");
        int provincia = scanner.nextInt();
        scanner.nextLine();

        operacionesCRUD.borrarProvincia(provincia);
    }

}