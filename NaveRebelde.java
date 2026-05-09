
import edu.epromero.util.Lienzo;

public class NaveRebelde extends ElementoGrafico {

    private int puntos;
    private boolean visible;

    public NaveRebelde(Lienzo canvas) {
        super();
        super.setSprite(".\\resources\\Heroe.png");
        super.imagen(sprite);
        super.setX((int) (canvas.pideLimiteXMax() / 2) - 2);
        super.setY((int) (canvas.pideLimiteYMin() + 14));
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
