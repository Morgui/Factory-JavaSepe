package factoria;

import factoria.exception.*;
/**
 * Clase para ejecutar y realizar las pruebas
 *
 * @author Luz Divina Delgado Castañeda
 */
public class Test {

    public static void main(String[] args) throws OverrideException {
        // Crear la Factory
        Factory laEmpresa = new Factory("DELPHI no-se-cierra");
        // Crear e insertar Secretary
        Secretary secretary1 = new Secretary("Juan", "Gran Vía, 22", "1234404J");
        // Crear e insertar Salesman
        Salesman salesman1 = new Salesman("Pedro", "Alcalá, 620", "1324324M");
        Salesman salesman2 = new Salesman("Montse", "Carlos Martín Álvarez, 77",
                "8859486I");
        // Crear e insertar Executive
        Executive executive1 = new Executive("Marcos", "Serrano, 50", "5326374V");
        // Añadir venta a Salesman
        salesman1.newSale(500);
        // Asignar Salesman a Executive
        try {
            executive1.addSalesman(salesman1);
            executive1.addSalesman(salesman2);
            executive1.addSalesman(salesman1); // Error deliverado
        } catch (OverrideException ovx) {
            System.out.println("ERROR -> " + ovx.getMessage());
        }
        try { // Asignar Secretary a Executive
            executive1.setSecretary(secretary1);
            executive1.setSecretary(secretary1); // Error deliverado
        } catch (OverrideException ovx) {
            System.out.println("ERROR -> " + ovx.getMessage());
        }
        System.out.println("Trabajadores del executive: " + executive1);
        // Listar los workers de un executive
        System.out.println(executive1.listWorkers());
        // Añadir workers a la factory
        laEmpresa.addWorker(secretary1);
        laEmpresa.addWorker(executive1);
        laEmpresa.addWorker(salesman1);
        laEmpresa.addWorker(salesman2);
        System.out.println("Salarios de la factory: " + laEmpresa.getName());
        System.out.println(laEmpresa.listSalaryWorkers());
        salesman1.newSale(3324); // Añadir venta a salesman
        System.out.println("Salarios de la factory: " + laEmpresa.getName());
        System.out.println(laEmpresa.listSalaryWorkers());
        try {
            System.out.println("Worker con dni: 1324324M -> "
                    + laEmpresa.getWorker("1324324M"));
            System.out.println("Worker con dni: 1324325M -> "
                    + laEmpresa.getWorker("1324325M")); // Error, no existe...
        } catch (NotFoundException nfe) {
            System.out.println("ERROR -> " + nfe.getMessage());
        }
    }
}
