
import edu.epromero.util.Imagen;
import edu.epromero.util.Lienzo;
import java.awt.Color;
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
        super.setVelocidad(3);
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
            if (getContaCiclos() % 8 == 0) {
                e.getBalas()[i].setVisible(true);
                if (getContaCiclos() == 8) {
                    e.getBalas()[i].mueveInicio(0, -5, this);
                }

            }
            if (e.getBalas()[i].isVisible() == true) {
                e.getBalas()[i].mueve(0, -5);
            }

            if (e.getBalas()[i].getY() < 0 && e.getBalas()[i].isVisible()) {
                e.getBalas()[i].setVisible(false);
                setContaCiclos(0);
            }

            //verificar choque
            if (e.getBalas()[1].isVisible()) {
                boolean choque = hayColision(e);
                if (choque == true) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        System.getLogger(Destructor.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                }
            }
        }
        setContaCiclos(getContaCiclos() + 1);
    }

    /*public boolean hayColision(Entrada e) {
        int contador = 0;

        double limitecx = ((e.getBalas()[1].getAnchura() / 2) + e.getBalas()[1].getX());//limite en x de la imagen parametro
        int limitecy = ((e.getBalas()[1].getAltura() / 2) + e.getBalas()[1].getY());//limite en y de la imagen parametro
        int neocy = e.getBalas()[1].getY() - (e.getBalas()[1].getAltura() / 2);//esquina inferior izquierda de la imagen parametro, coordenada y
        double neocx = e.getBalas()[1].getX() - (e.getBalas()[1].getAnchura() / 2);//esquina inferior izquierda de la imagen parametro, coordenada x

        for (neocy = neocy; neocy <= limitecy; neocy++) {
            for (neocx = neocx; neocx <= limitecx; neocx++) {

                for (int i = 0; i < e.getHeroe().getAltura(); i++) {//Si i == alto de imagen del objeto
                    for (double j = 0; j < e.getHeroe().getAnchura(); j++) {//Si j == ancho de imagen del objeto
                        int sumacY = e.getHeroe().getY() - (e.getHeroe().getAltura() / 2) + i;//coordenada y de esq. inf. izq. de imagen del objeto
                        double sumacX = (e.getHeroe().getX() - (e.getHeroe().getAnchura() / 2)) + j;//coordenada y de esq. inf. izq. de imagen del objeto
                        System.out.println("(" + sumacX + "," + sumacY + ")\n_______");
                        if (sumacY == (neocy) && sumacX == (neocx)) {
                            contador++;
                        }

                    }
                }
            }
        }

        return contador > 1;
    }*/
 /* public boolean hayColision(Entrada e) {
        int contador = 0;
        int limitecx = (e.getHeroe().getX() - (e.getHeroe().getAnchura() / 2)) + (e.getHeroe().getAnchura()) - 1;
        int limitecy = (e.getHeroe().getY() - (e.getHeroe().getAltura() / 2)) + (e.getHeroe().getAltura()) - 1;
        int neocx = (e.getHeroe().getX() - (e.getHeroe().getAnchura() / 2));
        int neocy = (e.getHeroe().getY() - (e.getHeroe().getAltura() / 2));
        for (neocy = e.getHeroe().getY(); neocy <= limitecy; neocy++) {
            for (neocx = e.getHeroe().getX(); neocx <= limitecx; neocx++) {

                for (int i = 0; i < e.getBalas()[1].getAltura(); i++) {//Si i < alto de imagen del objeto
                    for (int j = 0; j < e.getBalas()[1].getAnchura(); j++) {//Si j < ancho de imagen del objeto
                        int sumacY = (e.getBalas()[1].getY() - (e.getBalas()[1].getAltura() / 2)) + i;//coordenada y de esq. inf. izq. de imagen del objeto
                        int sumacX = (e.getBalas()[1].getX() - (e.getBalas()[1].getAnchura() / 2)) + j;//coordenada y de esq. inf. izq. de imagen del objeto
                        if (sumacY == (neocy) && sumacX == (neocx)) {
                            contador++;
                        }

                    }
                }
            }
        }
        return contador > 1;
    }*/
    public boolean hayColision(Entrada e) {
        int limiteDerH = e.getHeroe().getX() + e.getHeroe().getAnchura() / 2;
        int limiteIzqH = e.getHeroe().getX() - e.getHeroe().getAnchura() / 2;
        int limiteUpH = e.getHeroe().getY() + e.getHeroe().getAltura() / 2;
        int limiteDwH = e.getHeroe().getY() - e.getHeroe().getAltura() / 2;

        int limiteDerD = e.getBalas()[1].getX() + e.getBalas()[1].getAnchura() / 2;
        int limiteIzqD = e.getBalas()[1].getX() - e.getBalas()[1].getAnchura() / 2;
        int limiteUpD = e.getBalas()[1].getY() + e.getBalas()[1].getAltura() / 2;
        int limiteDwD = e.getBalas()[1].getY() - e.getBalas()[1].getAltura() / 2;

        boolean colisionX = limiteUpH <= limiteDerD && limiteDerH >= limiteIzqD;
        boolean colisionY = limiteUpD <= limiteDwD && limiteDwH >= limiteUpD;

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
