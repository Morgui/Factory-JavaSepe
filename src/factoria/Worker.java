package factoria;

/**
 *Clase abstracta que define e implementa los fundamentos básicos de Worker de la Factory
 * 
 * @author Luz Divina Delgado Castañeda
 */
abstract public class Worker {

    //Campos de la clase
    private String name;
    private String address;
    private String dni;
    protected double salary;

    /**
     * Constructor de Worker
     *
     * @param name El nombre del Worker
     * @param address La direción del Worker
     * @param dni El DNI del Worker
     */
    public Worker(String name, String address, String dni) {
        this.name = name;
        this.address = address;
        this.dni = dni;
    }

    /**
     * Devuelve el nombre del Worker
     *
     * @return El nombre
     */
    public String getName() {
        return name;

    }

    /**
     * Devuelve el DNI del Worker
     *
     * @return El DNI
     */
    public String getDni() {
        return dni;

    }

    /**
     * Devuelve la dirección del Worker
     *
     * @return La dirección
     */
    public String getAddress() {
        return address;
    }

    /**
     * Convierte y concatena en una cadena de String los datos que le solicitamos
     * 
     * @return Nombre, DNI y Dirección, separados por un espacio en blanco
     */
    public String toString() {
        return new String("Nombre: " + this.name + " DNI: "+ this.dni + " Address: "+ this.address);
    }

    /**
     * Compara si 2 workers tienen el mismo dni son el mismo worker, para ello
     * se comprueba con instanceof si el obj que pasa por parametro es un worker
     * Luego casteamos a una nueva variable obj como Worker para poder realizar 
     * la comparación, utilizando getDni
     * 
     * @param obj El otro worker con el que se compara
     * @return el resultado de la comparación como booleano
     */
    public boolean equals(Object obj) {
        if (obj instanceof Worker != true) {
            return false;
        }
        Worker worker2 = (Worker) obj;
        if (this.getDni() == worker2.getDni()) {
            return true;
        }
        return false;
    }

    /**
     *Método abstracto que calcula el salario del Worker
     * 
     * @return El salario
     */
    abstract public double computeSalary();

    /**
     * Devuelve el salario base
     *
     * @return El salario
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Asigna un salario al Worker
     * 
     * @param salary El salario
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
