
import edu.epromero.util.Lienzo;

/**
 * Clase Destructor, hereda de NaveEnemiga
 *
 * @author speed
 */
public class Destructor extends NaveEnemiga {

    protected boolean derDestructor;
    private int contaCiclos;

    /**
     * Constructor
     *
     * @param canvas
     */
    public Destructor(Lienzo canvas) {
        super(canvas);
        super.setX(super.getPosicionRandomX());
        super.setY(super.getPosicionRandomY());
        super.setPuntosAlMorir(50);
        super.setSprite(".\\resources\\Destructor.png");
        super.imagen(sprite);
        derDestructor = true;
        super.setVelocidad(15);
        setContaCiclos(1);
        super.setAnchura(6);
        super.setAltura(10);
    }

    /**
     * Mueve al destructor, y al ciclo de sus balas
     *
     * @param e
     */
    public void mueve(Entrada e) {
        //Mover destructor
        if (getX() >= (canvas.pideLimiteXMin() + velocidad) && isDerDestructor() == true) {
            if (!(getX() < (canvas.pideLimiteXMin() - velocidad))) {
                setX(getX() - velocidad);
            }

        } else if (getX() <= (canvas.pideLimiteXMax() - velocidad)) {
            setDerDestructor(false);
            if (getX() <= (canvas.pideLimiteXMax() - velocidad)) {
                setX(getX() + velocidad);
            }

            if (!(getX() < (canvas.pideLimiteXMax() - velocidad))) {
                setDerDestructor(true);
            }

        }
        //Disparar

        //La i se inicializa en el indice donde inican las balas del destructor
        //y  terminan donde el indice inica las balas de otro enemigo
        for (int i = 1; i < 2; i++) {
            if (getContaCiclos() % 2 == 0) {
                e.getBalas()[i].setVisible(true);
                if (getContaCiclos() == 2) {
                    e.getBalas()[i].mueveInicio(0, -10, this);
                }

            }
            if (e.getBalas()[i].isVisible() == true) {
                e.getBalas()[i].mueve(0, -10);
            }

            if (e.getBalas()[i].getY() < 0 && e.getBalas()[i].isVisible()) {
                e.getBalas()[i].setVisible(false);
                setContaCiclos(0);
            }

            //verificar choque
            boolean choque = hayColision(e);
            System.out.println(choque);
        }
        setContaCiclos(getContaCiclos() + 1);
    }

    public boolean hayColision(Entrada entrada) {

        System.out.println("Bala x = " + entrada.getBalas()[0].getX());
        System.out.println("Bala y = " + entrada.getBalas()[0].getY());
        System.out.println("Heroe x = " + entrada.getHeroe().getX());
        System.out.println("Heroe y = " + entrada.getHeroe().getY());
        if (entrada.getBalas()[0].getX() == entrada.getHeroe().getX() && entrada.getBalas()[0].getY() == entrada.getHeroe().getY()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return
     */
    public boolean isDerDestructor() {
        return derDestructor;
    }

    /**
     *
     * @param derDestructor
     */
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
