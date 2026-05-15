
import edu.epromero.util.Lienzo;

/**
 * Clase abstracte NaveEnemiga, hereda de ElementoGrafico
 *
 * @author speed
 */
public abstract class NaveEnemiga extends ElementoGrafico {

    protected int puntosAlMorir;
    protected int limiteMinXCanvas;
    protected int limiteMaxXCanvas;
    protected int limiteMinYCanvas;
    protected int limiteMaxYCanvas;
    protected int posicionRandomX;
    protected int posicionRandomY;
    protected Lienzo canvas;

    /**
     * Constructor, define el lienzo, establece los limites del Canvas y
     * establece una visibilidad=true
     *
     * @param canvas
     */
    public NaveEnemiga(Lienzo canvas) {
        super();
        this.canvas = canvas;
        puntosAlMorir = 0;
        limiteMaxXCanvas = (int) (canvas.pideLimiteXMax() - 5);
        limiteMinXCanvas = (int) (canvas.pideLimiteXMin() + 5);

        limiteMaxYCanvas = (int) (canvas.pideLimiteYMax() - 26);
        limiteMinYCanvas = (int) (canvas.pideLimiteYMin() + 25);

        posicionRandomX = (int) (Math.random() * (limiteMaxXCanvas - limiteMinXCanvas));
        posicionRandomY = (int) ((Math.random() + 0.64) * (limiteMaxYCanvas - limiteMinYCanvas));

        super.setVisible(true);
    }

    /**
     * Metodo abstracto mueve
     *
     * @param e
     */
    public abstract void mueve(Entrada e);

    //Setters & Getters
    /**
     *
     * @return
     */
    public int getPuntosAlMorir() {
        return puntosAlMorir;
    }

    /**
     *
     * @param puntosAlMorir
     */
    public void setPuntosAlMorir(int puntosAlMorir) {
        this.puntosAlMorir = puntosAlMorir;
    }

    /**
     *
     * @return
     */
    public int getLimiteMinXCanvas() {
        return limiteMinXCanvas;
    }

    /**
     *
     * @param limiteMinXCanvas
     */
    public void setLimiteMinXCanvas(int limiteMinXCanvas) {
        this.limiteMinXCanvas = limiteMinXCanvas;
    }

    /**
     *
     * @return
     */
    public int getLimiteMaxXCanvas() {
        return limiteMaxXCanvas;
    }

    /**
     *
     * @param limiteMaxXCanvas
     */
    public void setLimiteMaxXCanvas(int limiteMaxXCanvas) {
        this.limiteMaxXCanvas = limiteMaxXCanvas;
    }

    /**
     *
     * @return
     */
    public int getLimiteMinYCanvas() {
        return limiteMinYCanvas;
    }

    /**
     *
     * @param limiteMinYCanvas
     */
    public void setLimiteMinYCanvas(int limiteMinYCanvas) {
        this.limiteMinYCanvas = limiteMinYCanvas;
    }

    /**
     *
     * @return
     */
    public int getLimiteMaxYCanvas() {
        return limiteMaxYCanvas;
    }

    /**
     *
     * @param limiteMaxYCanvas
     */
    public void setLimiteMaxYCanvas(int limiteMaxYCanvas) {
        this.limiteMaxYCanvas = limiteMaxYCanvas;
    }

    /**
     *
     * @return
     */
    public int getPosicionRandomX() {
        return posicionRandomX;
    }

    /**
     *
     * @param posicionRandomX
     */
    public void setPosicionRandomX(int posicionRandomX) {
        this.posicionRandomX = posicionRandomX;
    }

    /**
     *
     * @return
     */
    public int getPosicionRandomY() {
        return posicionRandomY;
    }

    /**
     *
     * @param posicionRandomY
     */
    public void setPosicionRandomY(int posicionRandomY) {
        this.posicionRandomY = posicionRandomY;
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

}
