
import edu.epromero.util.Lienzo;

public class Destructor extends NaveEnemiga {

    public Destructor(Lienzo canvas, NaveRebelde heroe) {
        super(canvas, heroe);
        super.setPuntosAlMorir(50);
        super.setSprite(".\\resources\\Destructor.png");
        super.imagen(sprite);
    }

}
