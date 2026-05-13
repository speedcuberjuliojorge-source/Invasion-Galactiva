
import edu.epromero.util.Lienzo;
import java.awt.Color;
//import java.awt.event.KeyEvent;
//import static java.lang.Thread.sleep;
import java.awt.event.KeyEvent;

/**
 *
 * @author speed
 */
public class Juego {

    //////////ATRIBUTOS//////////
    private Lienzo canvas;
    private Fondo fondo;
    private NaveRebelde heroe;
    private Entrada teclado;
    private Destructor destructor;
    private int contaDestructor;
    ElementoGrafico elemento[];

    //////////METODOS//////////
    //Constructor
    public Juego() throws InterruptedException {

        //Declaraciones básicas
        elemento = new ElementoGrafico[4];
        setContaDestructor(0);
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

        //Mover Nave
        teclado = new Entrada();

        //Pintar Destructor
        destructor = new Destructor(canvas);
        elemento[2] = destructor;
        Destructor d2 = new Destructor(canvas);
        elemento[3] = d2;
    }

    public void dibuja() {
        canvas.dibujo((canvas.pideLimiteXMax() / 2), (canvas.pideLimiteYMax() / 2), elemento[0].getImgSprite(), 1000, 650);
        for (int i = 1; i < elemento.length; i++) {
            canvas.dibujo(elemento[i].getX(), elemento[i].getY(), elemento[i].getImgSprite());
        }
        canvas.mostrar(0);
    }

    public void limpia() {
        canvas.limpia(Color.black);
    }

    boolean derHereo = true;

    public void mover() {
        for (int i = 1; i < elemento.length; i++) {
            elemento[i].mueve(teclado);
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

    public Entrada getTeclado() {
        return teclado;
    }

    public void setTeclado(Entrada teclado) {
        this.teclado = teclado;
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

}
