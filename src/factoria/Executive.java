package factoria;

import factoria.exception.OverrideException;
import java.util.ArrayList;

/**
 * Esta clase define un responsable (Executive) de la Factory
 *
 * @author Luz Divina Delgado Castañeda
 * 
 */
public class Executive extends Worker {

    //Campos de la clase
    private final double COMISSION = 2.0; //for para iterar por las ventas de los salesman y sumarselo
    private final double SALARYBASE = 2500.0;
    private Secretary secretary;
    private ArrayList<Salesman> salesmen = new ArrayList<Salesman>();

    /**
     * Contructor de Executive
     *
     * @param name El nombre del Executive
     * @param address La dirección del Executive
     * @param dni DNI del Executive
     */
    public Executive(String name, String address, String dni) {
        super(name, address, dni);
    }

    /**
     * En este método se crea una nueva variable para registrar las ventas
     * totales de los Salesman que tenga el executive para ello se itera con un
     * bucle for por la lista de salesman y así obtener sus ventas para
     * sumarselas(2%) al salario del executive
     *
     * @return El salario del Executive ya calculado
     */
    @Override
    public double computeSalary() {
        double totalComission = 0.0;
        for (Salesman salesman : salesmen) {
            totalComission += salesman.getSales();
        }
        double salary = this.SALARYBASE + (totalComission * this.COMISSION / 100);
        return salary;
    }

    /**
     * El método addSalesman puede lanzar exepciones del salesman que se quiere
     * añadir si este ya tiene un Executive. Luego si no tiene Executive, se usa
     * el setExecutive para registrarlo en salesman.
     *
     * @throws Indica la exepción que lanza el método cuando salesman ya tiene un
     * Executive
     */
    public void addSalesman(Salesman pNewSalesman) throws OverrideException {

        if (pNewSalesman.hasExecutive()) {
            throw new OverrideException("El Salesman ya tiene un Executive");
        }
        pNewSalesman.setExecutive(this);
        this.salesmen.add(pNewSalesman);
    }

    /**
     * El método setSecretary puede lanzar exepciones del secretary que se
     * quiere añadir si esta ya tiene un Executive. Luego si no tiene Executive,
     * se usa el setSecretary para registrarlo en secretary.
     *
     * @throws Indica la exepción que lanza el método cuando secretary ya tiene
     * un Executive
     */
    public void setSecretary(Secretary pNewSecretary) throws OverrideException {
        if (pNewSecretary.hasExecutive()) {
            throw new OverrideException("Esta Secretary ya tiene un Executive");
        }
        pNewSecretary.setExecutive(this);
        this.secretary = pNewSecretary;
    }

    /**
     * En el método listWorkers creo una variable nueva para ir añadiendo salesman a la cadena.
     * Itero con un for por la lista de salesman, ejecutando el método toString (por
     * debajo) para que me devuelva un string con la representación de cada
     * salesman y añadiéndolo a la cadena y usando \n para un salto de linea.
     *
     * @return La lista de salesmen que tiene bajo su cargo el Executive
     */
    public String listWorkers() {
        String list = "";
        for (Salesman salesman : salesmen) {
            list = list + salesman + "\n";
        }
        return list;
    }
}
