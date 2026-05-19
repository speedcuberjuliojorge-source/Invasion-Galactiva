
import edu.epromero.util.Lienzo;
import static java.lang.Thread.sleep;

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
        super.setVelocidad(1);
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
        for (int i = 0; i < 1; i++) {
            if (getContaCiclos() % 13 == 0 && getContaCiclos() != 1) {
                e.getBalas()[i].setVisible(true);
                if (getContaCiclos() == 13) {
                    e.getBalas()[i].mueveInicio(0, -5, this);
                }

            }
            if (e.getBalas()[i].isVisible() == true) {
                e.getBalas()[i].mueve(0, -5);
            }

            if (e.getBalas()[i].getY() < 0 && e.getBalas()[i].isVisible()) {
                e.getBalas()[i].setVisible(false);
                setContaCiclos(1);
            }

            //verificar que se le disparo al heroe
            if (e.getBalas()[0].isVisible()) {
                boolean choque = hayColision(e);
                if (choque == true) {
                    e.getHeroe().setVidas(e.getHeroe().getVidas() - 1);
                    e.getBalas()[0].setX(getX());
                    e.getBalas()[0].setY(getY());
                    this.setContaCiclos(1);
                    e.getBalas()[0].setVisible(false);
                }
            }
            //verifica si le han disparado al destructor
            if (e.getBalas()[1].isVisible()) {
                boolean choque = hayColisionPropia(e);
                if (choque == true) {
                    setX((int) (Math.random() * (limiteMaxXCanvas - limiteMinXCanvas)));
                    setY((int) ((Math.random() + 0.64) * (limiteMaxYCanvas - limiteMinYCanvas)));
                    this.setContaCiclos(1);
                    e.getBalas()[1].setVisible(false);
                    e.getBalas()[1].setX(e.getHeroe().getX());
                    e.getBalas()[1].setY(e.getHeroe().getY());
                    e.getHeroe().setPuntos(e.getHeroe().getPuntos() + this.getPuntosAlMorir());
                }
            }
        }
        setContaCiclos(getContaCiclos() + 1);
    }

    /**
     * Motor de colision hero-bala
     *
     * @param e
     * @return
     */
    public boolean hayColision(Entrada e) {
        double limiteDerH = (e.getHeroe().getX() + e.getHeroe().getAnchura() / 2) - 3.09;
        double limiteIzqH = (e.getHeroe().getX() - e.getHeroe().getAnchura() / 2) + 3.09;
        double limiteUpH = (e.getHeroe().getY() + e.getHeroe().getAltura() / 2) - 1;
        double limiteDwH = (e.getHeroe().getY() - e.getHeroe().getAltura() / 2) + 1;

        double limiteDerD = e.getBalas()[0].getX() + e.getBalas()[1].getAnchura() / 2;
        double limiteIzqD = e.getBalas()[0].getX() - e.getBalas()[1].getAnchura() / 2;
        double limiteUpD = e.getBalas()[0].getY() + e.getBalas()[1].getAltura() / 2;
        double limiteDwD = e.getBalas()[0].getY() - e.getBalas()[1].getAltura() / 2;

        boolean colisionX = limiteIzqH <= limiteDerD && limiteDerH >= limiteIzqD;
        boolean colisionY = limiteDwH <= limiteUpD && limiteUpH >= limiteDwD;

        return colisionX && colisionY;
    }

    public boolean hayColisionPropia(Entrada e) {
        double thisLimiteDer = getX() + (this.getAnchura() / 2);
        double thisLimiteIzq = getX() - (this.getAnchura() / 2);
        double thisLimiteUp = getY() + (this.getAltura() / 2);
        double thisLimiteDw = getY() - (this.getAltura() / 2) + 6;

        double limiteDerD = e.getBalas()[1].getX() + e.getBalas()[1].getAnchura() / 2;
        double limiteIzqD = e.getBalas()[1].getX() - e.getBalas()[1].getAnchura() / 2;
        double limiteUpD = e.getBalas()[1].getY() + (e.getBalas()[1].getAltura() / 2) + 1;
        double limiteDwD = e.getBalas()[1].getY() - e.getBalas()[1].getAltura() / 2;

        boolean colisionX = thisLimiteIzq <= limiteDerD && thisLimiteDer >= limiteIzqD;
        boolean colisionY = thisLimiteUp >= limiteDwD && thisLimiteDw <= limiteUpD;

        return colisionX && colisionY;
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
