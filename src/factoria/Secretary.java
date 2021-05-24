package factoria;

/**
 *Esta clase define Secretary de la Factory
 * 
 * @author Luz Divina Delgado Castañeda
 */
public class Secretary extends Worker {

    //Campos de la clase
    private double SALARYBASE = 1200.0;
    private Executive executive;

    /**
     * Constructor de Secretary
     * 
     * @param name El nombre de Secretary
     * @param address La dirección de Secretary
     * @param dni DNI de Secretary
     */
    public Secretary(String name, String address, String dni) {
        super(name, address, dni);
        this.salary = SALARYBASE;
    }

    /**
     * Método para calcular el salario del Secretary(worker) a través del
     * polimorfismo
     * 
     * @return El salario del Secretary
     */
    @Override
    public double computeSalary() {
        return this.salary;
    }

    /**
     * Accede al Executive que tenga asociado Secretary
     * 
     * @return El Executive al que pertenece Secretary
     */
    public Executive getExecutive() {
        return executive;
    }

    /**
     * Se le asigna un valor a executive
     * 
     * @param pExecutive Un Executive al que queda registrado Secretary
     */
    public void setExecutive(Executive pExecutive) {
        this.executive = pExecutive;
    }

    /**
     * Comprueba si Secretary tiene un Executive
     * Se usa getExecutive para dicha comprobación
     * 
     * @return True o false dependiendo de si Secretary tiene un Executive
     * asignado o no
     */
    public boolean hasExecutive() {
        if (this.getExecutive() == null) {
            return false;
        } else {
            return true;
        }
    }
}
