
import edu.epromero.util.Lienzo;

public class Destructor extends NaveEnemiga {

    public Destructor(Lienzo canvas) {
        super(canvas);
        super.setX(super.getPosicionRandomX());
        super.setY(super.getPosicionRandomY());
        System.out.println("X = " + super.getX());
        System.out.println("Y = " + super.getY());
        super.setPuntosAlMorir(50);
        super.setSprite(".\\resources\\Destructor.png");
        super.imagen(sprite);
    }

    public void mueve(Entrada e) {
        int avanze = 15;

    }

}
