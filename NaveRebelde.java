
import edu.epromero.util.Lienzo;
import java.awt.event.KeyEvent;

/**
 * Clase NaveRebelde, hereda de ElementoGrafico e instancía al heroe
 *
 * @author speed
 */
public class NaveRebelde extends ElementoGrafico {

    private int puntos;
    private boolean visible;
    private Lienzo canvas;
    private int contaCiclos;
    private int vidas;

    /**
     * Constructor, define el lienzo
     *
     * @param canvas
     */
    public NaveRebelde(Lienzo canvas) {
        super();
        super.setSprite(".\\resources\\Heroe.png");
        super.imagen(sprite);
        super.setX((int) (canvas.pideLimiteXMax() / 2) - 2);
        super.setY((int) (canvas.pideLimiteYMin() + 14));
        this.canvas = canvas;
        super.setVelocidad(2);
        setVisible(true);
        setContaCiclos(1);
        super.setAltura(27);
        super.setAnchura(6);
        setVidas(3);

    }

    /**
     * Mueve a la NAverRebelde y a sus balas movimiento a movimiento
     *
     * @param e
     */
    public void mueve(Entrada e) {

        //Mover la nave
        if (getCanvas().fuePulsadaTecla(KeyEvent.VK_A) || getCanvas().fuePulsadaTecla(KeyEvent.VK_LEFT)) {
            if (getX() > (getCanvas().pideLimiteXMin() + velocidad)) {
                setX(getX() - velocidad);

            }
        }

        if (getCanvas().fuePulsadaTecla(KeyEvent.VK_D) || getCanvas().fuePulsadaTecla(KeyEvent.VK_RIGHT)) {
            if (getX() < (getCanvas().pideLimiteXMax() - velocidad)) {

                setX(getX() + velocidad);

            }
        }

        //Disparar
        //La i se inicializa en el indice donde inican las balas del destructor
        //y  terminan donde el indice inica las balas de otro enemigo
        for (int i = 1; i < 2; i++) {

            if (getCanvas().fuePulsadaTecla(KeyEvent.VK_SPACE) && (e.getBalas()[1].getY() >= e.getDestructor().getLimiteMaxXCanvas() || e.getBalas()[i].getY() == this.getY())) {
                e.getBalas()[i].setVisible(true);
                e.getBalas()[i].setX(this.getX());
                e.getBalas()[i].setY(this.getY());

                if (getContaCiclos() == 1) {
                    e.getBalas()[i].mueveInicio(0, 5, this);
                }

            }
            if (e.getBalas()[i].isVisible() == true) {
                e.getBalas()[i].mueve(0, 5);
            }

            if (e.getBalas()[i].getY() > 100 && e.getBalas()[i].isVisible()) {
                e.getBalas()[i].setVisible(false);
                setContaCiclos(0);
            }

        }
        setContaCiclos(getContaCiclos() + 1);

    }

    //Getters & Setters
    /**
     *
     * @return
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     *
     * @param puntos
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     *
     * @return
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     *
     * @param visible
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
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

    /**
     * @return the contaCiclos
     */
    public int getContaCiclos() {
        return contaCiclos;
    }

    /**
     * @param contaCiclos the contaCiclos to set
     */
    public void setContaCiclos(int contaCiclos) {
        this.contaCiclos = contaCiclos;
    }

    /**
     * @return the vidas
     */
    public int getVidas() {
        return vidas;
    }

    /**
     * @param vidas the vidas to set
     */
    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

}
