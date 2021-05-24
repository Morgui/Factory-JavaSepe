package factoria;

/**
 *Esta clase define un vendedor (Salesman) de la Factory
 * 
 * @author Luz Divina Delgado Castañeda
 */
public class Salesman extends Worker {

    //Campos de la clase
    private double salesMonth;
    private double COMISSION = 5.0;
    private double SALARYBASE = 1300.0;
    private Executive executive;

    /**
     * Constructor de Salesman
     * 
     * @param name El nombre del Salesman
     * @param address La direción del Salesman
     * @param dni El DNI del Salesman
     */
    public Salesman(String name, String address, String dni) {
        super(name, address, dni);
    }

    /**
     * En este método se crea una nueva variable para calcular el salario
     * total del Salesman, sumando el salario base + las ventas realizadas y 
     * así obtener este con el 5% de comisión
     *
     * @return El salario del Salesman ya calculado
     */
    @Override
    public double computeSalary() {
        double salary = this.SALARYBASE + (this.getSales() * this.COMISSION / 100);
        return salary;
    }

    /**
     * En este método creo la variable totalSales para sumarle a las ventas ya 
     * realizadas(obtenidas con getSales), la nueva venta y luego asigno el valor
     * a salesMonth
     * 
     * @param pSale venta nueva realizada
     */
    public void newSale(double pSale) {
        double totalSales = this.getSales() + pSale;
        this.salesMonth = totalSales;
    }

    /**
     * Este método nos devuelve las ventas del Salesman
     * 
     * @return Las ventas del mes
     */
    public double getSales() {
        return salesMonth;
    }

    /**
     * Renicia salesMonth a 0 cuando se cambie de mes
     */
    public void changeMonth() {
        salesMonth = 0.0;
    }

    /**
     * Se le asigna un valor a executive
     * 
     * @param pExecutive Un Executive al que queda registrado el Salesman
     */
    public void setExecutive(Executive pExecutive) {
        this.executive = pExecutive;
    }

    /**
     * Accede al Executive que tenga asociado el Salesman
     * 
     * @return El Executive al que pertenece el Salesman
     */
    public Executive getExecutive() {
        return executive;
    }

    /**
     * Comprueba si el salesman tiene jefe(un executive).
     * Se usa getExecutive para dicha comprobación
     * 
     * @return True o false dependiendo de si el Salesman tiene un Executive
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
