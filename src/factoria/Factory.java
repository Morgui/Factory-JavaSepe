package factoria;

import java.util.ArrayList;
import factoria.exception.NotFoundException;
import factoria.exception.OverrideException;

/**
 * Esta clase define Factory
 *
 * @author Luz Divina Delgado Castañeda
 *
 */
public class Factory {

    //Campos de la clase
    private String name;
    private ArrayList<Worker> workers;

    /**
     * Constructor de Factory
     *
     */
    public Factory() {
        workers = new ArrayList<Worker>();
    }

    /**
     * Contructor de Factory
     *
     * @param name El nombre de la Factoría
     *
     */
    public Factory(String name) {
        this();
        this.name = name;
    }

    /**
     * Este método me da el nombre de Factory
     *
     * @return El nombre de la Factoría
     */
    public String getName() {
        return name;
    }

    /**
     * Setea el nombre de Factory
     *
     * @param name El nombre de la Factoría
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Este método añade trabajadores (worker) a Factory
     *
     * @param pNewWorker Trabajador (worker) nuevo añadido
     * @throws Indica la exepción que lanza el método cuando el worker ya existe
     */
    public void addWorker(Worker pNewWorker) throws OverrideException {
        for (Worker worker : workers) {
            if (pNewWorker.equals(worker)) {
                throw new OverrideException("ya existe");
            }
        }
        workers.add(pNewWorker);
    }

    /**
     * Este método me da la lista de trabajadores (workers)
     *
     * @return La lista de workers
     */
    public ArrayList<Worker> getWorkers() {
        return this.workers;
    }

    /**
     * Este método busca un trabajador (worker) en la lista y lo devuelve
     *
     * @param dni Busca al worker por el parametro dni
     * @return El worker si existe en la lista
     * @throws Indica la exepción que lanza el método si el worker no existe
     */
    public Worker getWorker(String dni) throws NotFoundException {
        for (Worker worker : workers) {
            if (worker.getDni().equals(dni)) {
                return worker;
            }
        }
        throw new NotFoundException("no existe");
    }

    /**
     * Este método nos devuelve la lista de todos los workers de Factory
     *
     * @return La lista de todos los workers, incluyendo el nombre, dni y
     * salario de cada uno
     */
    public String listSalaryWorkers() {
        String list = "";
        for (Worker worker : workers) {
            list = list + " Name: " + worker.getName() + " DNI: " + worker.getDni() + " Salary: " + worker.computeSalary()+"€" + "\n";
        }
        return list;
    }

}
