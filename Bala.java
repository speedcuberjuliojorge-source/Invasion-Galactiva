
import edu.epromero.util.Lienzo;

/**
 * Clase bala, hereda de ELementoGrafico y trabaja con las Balas del juego
 *
 * @author speed
 */
public class Bala extends ElementoGrafico {

    private Lienzo canvas;

    /**
     * Constructor de la clase Bala, parametros
     *
     * @param entrada
     * @param nave
     */
    public Bala(Entrada entrada, NaveEnemiga nave) {
        super();
        super.setSprite(".\\resources\\bala.png");
        super.imagen(sprite);
        super.setX(nave.getX());
        super.setY(nave.getY());
        this.canvas = entrada.getCanvas();
        super.setVelocidad(10);
    }

    public void mueveInicio(int x, int y, NaveEnemiga nave) {
        setX(nave.getX() + x);
        setY(nave.getY() + y);

    }

    public Bala(Entrada entrada, NaveRebelde nave) {
        super();
        super.setSprite(".\\resources\\bala.png");
        super.imagen(sprite);
        super.setX(nave.getX());
        super.setY(nave.getY());
        this.canvas = entrada.getCanvas();
        super.setVelocidad(10);
    }

    public void mueveInicio(int x, int y, NaveRebelde nave) {
        setX(nave.getX() + x);
        setY(nave.getY() + y);

    }

    public void mueve(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
        System.out.println("Coordenadas bala: " + "(" + getX() + ", " + getY() + ")");
    }

    /**
     * @return the canvas
     */
    public Lienzo getCanvas() {
        return canvas;
    }

    /**
     * @param canvas the canvas to set
     */
    public void setCanvas(Lienzo canvas) {
        this.canvas = canvas;
    }
}
