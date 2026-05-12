
import edu.epromero.util.Lienzo;

public class NaveEnemiga extends ElementoGrafico {

    protected int puntosAlMorir;
    protected int limiteMinXCanvas;
    protected int limiteMaxXCanvas;
    protected int limiteMinYCanvas;
    protected int limiteMaxYCanvas;
    protected int posicionRandomX;
    protected int posicionRandomY;
    protected Lienzo canvas;

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
    }

    public void Mueve(Entrada teclado) {

    }

    private void dispara() {

    }

    //Setters & Getters
    public int getPuntosAlMorir() {
        return puntosAlMorir;
    }

    public void setPuntosAlMorir(int puntosAlMorir) {
        this.puntosAlMorir = puntosAlMorir;
    }

    public int getLimiteMinXCanvas() {
        return limiteMinXCanvas;
    }

    public void setLimiteMinXCanvas(int limiteMinXCanvas) {
        this.limiteMinXCanvas = limiteMinXCanvas;
    }

    public int getLimiteMaxXCanvas() {
        return limiteMaxXCanvas;
    }

    public void setLimiteMaxXCanvas(int limiteMaxXCanvas) {
        this.limiteMaxXCanvas = limiteMaxXCanvas;
    }

    public int getLimiteMinYCanvas() {
        return limiteMinYCanvas;
    }

    public void setLimiteMinYCanvas(int limiteMinYCanvas) {
        this.limiteMinYCanvas = limiteMinYCanvas;
    }

    public int getLimiteMaxYCanvas() {
        return limiteMaxYCanvas;
    }

    public void setLimiteMaxYCanvas(int limiteMaxYCanvas) {
        this.limiteMaxYCanvas = limiteMaxYCanvas;
    }

    public int getPosicionRandomX() {
        return posicionRandomX;
    }

    public void setPosicionRandomX(int posicionRandomX) {
        this.posicionRandomX = posicionRandomX;
    }

    public int getPosicionRandomY() {
        return posicionRandomY;
    }

    public void setPosicionRandomY(int posicionRandomY) {
        this.posicionRandomY = posicionRandomY;
    }

    public Lienzo getCanvas() {
        return canvas;
    }

    public void setCanvas(Lienzo canvas) {
        this.canvas = canvas;
    }

}
