
import edu.epromero.util.Lienzo;

public class Bala extends ElementoGrafico {

    Lienzo canvas;

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

    public void mueve(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
        System.out.println("Coordenadas bala: " + "(" + getX() + ", " + getY() + ")");
    }
}
