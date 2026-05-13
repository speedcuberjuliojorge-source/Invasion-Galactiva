
import edu.epromero.util.Lienzo;

public class Destructor extends NaveEnemiga {

    protected boolean derDestructor;

    public Destructor(Lienzo canvas) {
        super(canvas);
        super.setX(super.getPosicionRandomX());
        super.setY(super.getPosicionRandomY());
        System.out.println("X = " + super.getX());
        System.out.println("Y = " + super.getY());
        super.setPuntosAlMorir(50);
        super.setSprite(".\\resources\\Destructor.png");
        super.imagen(sprite);
        derDestructor = true;
        super.setVelocidad(15);
    }

    public void mueve(Entrada e) {

        if (getX() >= (canvas.pideLimiteXMin() + velocidad) && isDerDestructor() == true) {
            if (!(getX() < (canvas.pideLimiteXMin() - velocidad))) {
                setX(getX() - velocidad);
            }

        } else if (getX() <= (canvas.pideLimiteXMax() - velocidad)) {
            setDerDestructor(false);
            if (getX() <= (canvas.pideLimiteXMax() - velocidad))/*Se suma el 5 para obtener el
            limite del canvas 0*/ {
                setX(getX() + velocidad);
            }

            if (!(getX() < (canvas.pideLimiteXMax() - velocidad))) {
                setDerDestructor(true);
            }

        }

    }

    public boolean isDerDestructor() {
        return derDestructor;
    }

    public void setDerDestructor(boolean derDestructor) {
        this.derDestructor = derDestructor;
    }

}
