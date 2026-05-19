
import edu.epromero.util.Lienzo;

/**
 * Clase gestora(secundaria) del videojuego Inasion Galactica
 *
 * @author speed
 */
public class Juego {

    private Lienzo canvas;
    private Fondo fondo;
    private NaveRebelde heroe;
    private Entrada entrada;
    private Destructor destructor;
    private ElementoGrafico elemento[];
    private Bala bala;
    private Bala bala2;
    private Bala[] balas;
    private boolean derHereo;

    /**
     * Metodo constructor Juego() de la clase Juego, hace declaraciones básicas,
     * establece el lienzo, el fondo, la Nave rebelde, el Destructor, las balas,
     * los arreglos de balas y elementos graficos
     *
     * @throws InterruptedException
     */
    public Juego() throws InterruptedException {

        //Declaraciones básicas
        elemento = new ElementoGrafico[3];
        balas = new Bala[2];
        setDerHereo(true);
        //Tamaño y escala lienzo
        canvas = new Lienzo();
        canvas.ponTamanioLienzo(1300, 650);
        canvas.ponEscalaX(00, 100);
        canvas.ponEscalaY(0, 100);

        //Establecer fondo
        fondo = new Fondo(canvas.pideLimiteXMax(), canvas.pideLimiteYMax());
        elemento[0] = fondo;

        //Mover Entrada
        entrada = new Entrada(canvas);

        //Estabecer Nave
        heroe = new NaveRebelde(canvas);
        elemento[1] = heroe;
        entrada.setHeroe((NaveRebelde) (elemento[1]));

        //Pintar Destructor
        destructor = new Destructor(canvas);
        elemento[2] = destructor;
        entrada.setDestructor((Destructor) (elemento[2]));
        /*Destructor d2 = new Destructor(canvas);
        elemento[3] = d2;*/

        //Iniciar Bala
        bala = new Bala(entrada, (NaveEnemiga) (elemento[2]));
        balas[0] = bala;
        bala2 = new Bala(entrada, (NaveRebelde) (elemento[1]));
        balas[1] = bala2;
        entrada.setBalas(balas);

    }

    /**
     * Dibuja todos los elementos graficos del programa en el lienzo
     */
    public void dibuja() {

        canvas.dibujo((canvas.pideLimiteXMax() / 2), (canvas.pideLimiteYMax() / 2), getElemento()[0].getImgSprite(), 1000, 650);

        for (int i = 1; i < getElemento().length; i++) {
            if (getElemento()[i].isVisible() == true) {
                canvas.dibujo(getElemento()[i].getX(), getElemento()[i].getY(), getElemento()[i].getImgSprite());
            }
        }
        for (int i = 0; i < getBalas().length; i++) {
            if (getBalas()[i].isVisible() == true) {
                canvas.dibujo(getBalas()[i].getX(), getBalas()[i].getY(), getBalas()[i].getImgSprite());
            }
        }
        fondo.pintaDatos(canvas, entrada);
        canvas.mostrar(0);
    }

    /**
     * Limpia el lienzo
     */
    public void limpia() {
        canvas.limpia();
    }

    /**
     * Mueve a los elementos de los arreglos de los Elementos graficos (uno por
     * uno)
     */
    public void mover() {
        for (int i = 1; i < getElemento().length; i++) {
            getElemento()[i].mueve(entrada);
        }
        for (int i = 0; i < getBalas().length; i++) {
            getBalas()[i].mueve(entrada);
        }

    }

    //Setters y Getters
    /**
     *
     * @return
     */
    public Lienzo getCanvas() {
        return canvas;
    }

    /**
     *
     * @param canvas
     */
    public void setCanvas(Lienzo canvas) {
        this.canvas = canvas;
    }

    /**
     *
     * @return
     */
    public Fondo getFondo() {
        return fondo;
    }

    /**
     *
     * @param fondo
     */
    public void setFondo(Fondo fondo) {
        this.fondo = fondo;
    }

    /**
     *
     * @return
     */
    public Entrada getEntrada() {
        return entrada;
    }

    /**
     *
     * @param entrada
     */
    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    /**
     *
     * @return
     */
    public NaveEnemiga getDestructor() {
        return destructor;
    }

    /**
     *
     * @param destructor
     */
    public void setDestructor(Destructor destructor) {
        this.destructor = destructor;
    }

    /**
     * @return
     */
    public ElementoGrafico[] getElemento() {
        return elemento;
    }

    /**
     *
     * @param elemento
     */
    public void setElemento(ElementoGrafico[] elemento) {
        this.elemento = elemento;
    }

    /**
     *
     * @return
     */
    public Bala getBala() {
        return bala;
    }

    /**
     *
     * @param bala
     */
    public void setBala(Bala bala) {
        this.bala = bala;
    }

    /**
     *
     * @return
     */
    public boolean isDerHereo() {
        return derHereo;
    }

    /**
     *
     * @param derHereo
     */
    public void setDerHereo(boolean derHereo) {
        this.derHereo = derHereo;
    }

    /**
     * @return the bala2
     */
    public Bala getBala2() {
        return bala2;
    }

    /**
     * @param bala2 the bala2 to set
     */
    public void setBala2(Bala bala2) {
        this.bala2 = bala2;
    }

    /**
     * @return the balas
     */
    public Bala[] getBalas() {
        return balas;
    }

    /**
     * @param balas the balas to set
     */
    public void setBalas(Bala[] balas) {
        this.balas = balas;
    }

}
