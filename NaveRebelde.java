
import edu.epromero.util.Lienzo;
import java.awt.event.KeyEvent;

public class NaveRebelde extends ElementoGrafico {

    private int puntos;
    private boolean visible;
    private Lienzo canvas;
    private int contaCiclos;

    public NaveRebelde(Lienzo canvas) {
        super();
        super.setSprite(".\\resources\\Heroe.png");
        super.imagen(sprite);
        super.setX((int) (canvas.pideLimiteXMax() / 2) - 2);
        super.setY((int) (canvas.pideLimiteYMin() + 14));
        this.canvas = canvas;
        super.setVelocidad(5);
        setVisible(true);
        setContaCiclos(1);
    }

    public void mueve(Entrada e) {
        if (getCanvas().fuePulsadaTecla(KeyEvent.VK_A) || getCanvas().fuePulsadaTecla(KeyEvent.VK_LEFT)) {
            if (getX() > (getCanvas().pideLimiteXMin() + velocidad)) {
                if (getCanvas().existenMasTeclasPulsadas()) {
                    if (getX() > (getCanvas().pideLimiteXMin() + velocidad))/*Se suma el 5 para obtener el
            limite del canvas 0*/ {
                        setX(getX() - velocidad);
                    }
                }

            }
        }

        if (getCanvas().fuePulsadaTecla(KeyEvent.VK_D) || getCanvas().fuePulsadaTecla(KeyEvent.VK_RIGHT)) {
            if (getX() < (getCanvas().pideLimiteXMax() - velocidad)) {
                if (getCanvas().existenMasTeclasPulsadas()) {
                    if (getX() < (getCanvas().pideLimiteXMax() - velocidad))/*Se suma el 5 para obtener el
            limite del canvas 0*/ {
                        setX(getX() + velocidad);
                    }
                }
            }
        }

        //Disparar
        if (getCanvas().fuePulsadaTecla(KeyEvent.VK_SPACE) /*&& (e.getBala2().getY() == getY())*/) {
            e.getBala2().setVisible(true);
            if (getContaCiclos() == 1) {
                e.getBala2().mueveInicio(0, 10, this);
            }

        }
        if (e.getBala2().isVisible() == true) {
            e.getBala2().mueve(0, 10);
        }

        if (e.getBala2().getY() > 100 && e.getBala2().isVisible()) {
            e.getBala2().setVisible(false);
            setContaCiclos(0);
        }
        setContaCiclos(getContaCiclos() + 1);

    }

    //Getters & Setters
    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public boolean isVisible() {
        return visible;
    }

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

}
