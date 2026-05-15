
import edu.epromero.util.Lienzo;

public class Entrada {

    private Lienzo canvas;
    private Bala bala;
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

}
