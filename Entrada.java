
import edu.epromero.util.Lienzo;

public class Entrada {

    private Lienzo canvas;
    private Bala bala;
    private Bala bala2;
    private Destructor destructor;

    public Entrada(Lienzo canvas) {
        this.canvas = canvas;
    }

    public Lienzo getCanvas() {
        return canvas;
    }

    public void setCanvas(Lienzo canvas) {
        this.canvas = canvas;
    }

    public Bala getBala() {
        return bala;
    }

    public void setBala(Bala bala) {
        this.bala = bala;
    }

    public Destructor getDestructor() {
        return destructor;
    }

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

}
