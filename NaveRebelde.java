
import edu.epromero.util.Lienzo;
import java.awt.event.KeyEvent;

public class NaveRebelde extends ElementoGrafico {

    private int puntos;
    private boolean visible;
    Lienzo canvas;

    public NaveRebelde(Lienzo canvas) {
        super();
        super.setSprite(".\\resources\\Heroe.png");
        super.imagen(sprite);
        super.setX((int) (canvas.pideLimiteXMax() / 2) - 2);
        super.setY((int) (canvas.pideLimiteYMin() + 14));
        this.canvas = canvas;
        super.setVelocidad(5);
        setVisible(true);
    }

    public void mueve(Entrada e) {
        if (canvas.fuePulsadaTecla(KeyEvent.VK_A) || canvas.fuePulsadaTecla(KeyEvent.VK_LEFT)) {
            if (getX() > (canvas.pideLimiteXMin() + velocidad)) {
                if (canvas.existenMasTeclasPulsadas()) {
                    if (getX() > (canvas.pideLimiteXMin() + velocidad))/*Se suma el 5 para obtener el
            limite del canvas 0*/ {
                        setX(getX() - velocidad);
                    }
                }

            }
        }

        if (canvas.fuePulsadaTecla(KeyEvent.VK_D) || canvas.fuePulsadaTecla(KeyEvent.VK_RIGHT)) {
            if (getX() < (canvas.pideLimiteXMax() - velocidad)) {
                if (canvas.existenMasTeclasPulsadas()) {
                    if (getX() < (canvas.pideLimiteXMax() - velocidad))/*Se suma el 5 para obtener el
            limite del canvas 0*/ {
                        setX(getX() + velocidad);
                    }
                }
            }
        }
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

}
