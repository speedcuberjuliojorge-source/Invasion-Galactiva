
import edu.epromero.util.Lienzo;

/**
 * Utilizada como stock para transportar atributos por diferentes clases
 *
 * @author speed
 */
public class Entrada {

    private Lienzo canvas;
    private Bala bala;
    private Bala bala2;
    private Destructor destructor;
    private Bala balas[];

    /**
     * Constructor, define el arreglo de balas
     */
    public Entrada() {
        balas = new Bala[2];
    }

    /**
     * Constructor, define el lienzo
     *
     * @param canvas
     */
    public Entrada(Lienzo canvas) {
        this.canvas = canvas;
    }

    /**
     *
     * @return
     */
    public Lienzo getCanvas() {
        return canvas;
    }

    /**
     *
     * @param canvas
     */
    public void setCanvas(Lienzo canvas) {
        this.canvas = canvas;
    }

    /**
     *
     * @return
     */
    public Bala getBala() {
        return bala;
    }

    /**
     *
     * @param bala
     */
    public void setBala(Bala bala) {
        this.bala = bala;
    }

    /**
     *
     * @return
     */
    public Destructor getDestructor() {
        return destructor;
    }

    /**
     *
     * @param destructor
     */
    public void setDestructor(Destructor destructor) {
        this.destructor = destructor;
    }

    /**
     * @return the bala2
     */
    public Bala getBala2() {
        return bala2;
    }

    /**
     * @param bala2 the bala2 to set
     */
    public void setBala2(Bala bala2) {
        this.bala2 = bala2;
    }

    /**
     * @return the balas
     */
    public Bala[] getBalas() {
        return balas;
    }

    /**
     * @param balas the balas to set
     */
    public void setBalas(Bala[] balas) {
        this.balas = balas;
    }

}
