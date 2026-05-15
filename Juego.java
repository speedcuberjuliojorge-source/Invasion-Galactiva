
import edu.epromero.util.Lienzo;
//import java.awt.event.KeyEvent;
//import static java.lang.Thread.sleep;

/**
 *
 * @author speed
 */
public class Juego {

    //////////ATRIBUTOS//////////
    private Lienzo canvas;
    private Fondo fondo;
    private NaveRebelde heroe;
    private Entrada entrada;
    private Destructor destructor;
    private int contaDestructor;
    private ElementoGrafico elemento[];
    private Bala bala;
    private Bala bala2;
    private boolean derHereo;

    //////////METODOS//////////
    //Constructor
    public Juego() throws InterruptedException {

        //Declaraciones básicas
        elemento = new ElementoGrafico[5];
        setContaDestructor(0);
        setDerHereo(true);
        //Tamaño y escala lienzo
        canvas = new Lienzo();
        canvas.ponTamanioLienzo(1300, 650);
        canvas.ponEscalaX(00, 100);
        canvas.ponEscalaY(0, 100);

        //Establecer fondo
        fondo = new Fondo(canvas.pideLimiteXMax(), canvas.pideLimiteYMax());
        elemento[0] = fondo;

        //Pintar Nave
        heroe = new NaveRebelde(canvas);
        elemento[1] = heroe;

        //Mover Entrada
        entrada = new Entrada(canvas);

        //Pintar Destructor
        destructor = new Destructor(canvas);
        elemento[2] = destructor;
        entrada.setDestructor((Destructor) (elemento[2]));
        /*Destructor d2 = new Destructor(canvas);
        elemento[3] = d2;*/

        //Iniciar Bala
        bala = new Bala(entrada, destructor);
        elemento[3] = bala;
        entrada.setBala((Bala) (elemento[3]));

        bala2 = new Bala(entrada, destructor);
        elemento[4] = bala2;
        entrada.setBala2((Bala) (elemento[4]));

    }

    public void dibuja() {
        canvas.dibujo((canvas.pideLimiteXMax() / 2), (canvas.pideLimiteYMax() / 2), getElemento()[0].getImgSprite(), 1000, 650);
        for (int i = 1; i < getElemento().length; i++) {
            if (getElemento()[i].isVisible() == true) {
                canvas.dibujo(getElemento()[i].getX(), getElemento()[i].getY(), getElemento()[i].getImgSprite());
            }
        }
        canvas.mostrar(0);
    }

    public void limpia() {
        canvas.limpia();
    }

    public void mover() {
        for (int i = 1; i < getElemento().length; i++) {
            getElemento()[i].mueve(entrada);
        }

    }

    //Setters y Getters
    public Lienzo getCanvas() {
        return canvas;
    }

    public void setCanvas(Lienzo canvas) {
        this.canvas = canvas;
    }

    public Fondo getFondo() {
        return fondo;
    }

    public void setFondo(Fondo fondo) {
        this.fondo = fondo;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public NaveEnemiga getDestructor() {
        return destructor;
    }

    public void setDestructor(Destructor destructor) {
        this.destructor = destructor;
    }

    public int getContaDestructor() {
        return contaDestructor;
    }

    public void setContaDestructor(int contaDestructor) {
        this.contaDestructor = contaDestructor;
    }

    public ElementoGrafico[] getElemento() {
        return elemento;
    }

    public void setElemento(ElementoGrafico[] elemento) {
        this.elemento = elemento;
    }

    public Bala getBala() {
        return bala;
    }

    public void setBala(Bala bala) {
        this.bala = bala;
    }

    public boolean isDerHereo() {
        return derHereo;
    }

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

}
