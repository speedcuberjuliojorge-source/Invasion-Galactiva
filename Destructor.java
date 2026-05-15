
import edu.epromero.util.Lienzo;

public class Destructor extends NaveEnemiga {

    protected boolean derDestructor;
    private int contaCiclos;

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
        setContaCiclos(1);
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
        System.out.println("Coordenadas destructor: " + "(" + getX() + ", " + getY() + ")");

        if (getContaCiclos() % 2 == 0) {
            e.getBala().setVisible(true);
            if (getContaCiclos() == 2) {
                e.getBala().mueveInicio(0, -10, this);
            }

        }
        if (e.getBala().isVisible() == true) {
            e.getBala().mueve(0, -10);
        }

        if (e.getBala().getY() < 0) {
            e.getBala().setVisible(false);
            setContaCiclos(0);
        }
        setContaCiclos(getContaCiclos() + 1);
    }

    public boolean isDerDestructor() {
        return derDestructor;
    }

    public void setDerDestructor(boolean derDestructor) {
        this.derDestructor = derDestructor;
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
