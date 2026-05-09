
import edu.epromero.util.Lienzo;
import static java.lang.Thread.sleep;
//import java.awt.event.KeyEvent;

/**
 *
 * @author speed
 */
public class Juego {

    //////////ATRIBUTOS//////////
    private Lienzo canvas;
    private Fondo fondo;
    private NaveRebelde heroe;
    Entrada teclado;

    //////////METODOS//////////
    //Constructor
    public Juego() throws InterruptedException {

        //Tamaño y escala lienzo
        canvas = new Lienzo();
        canvas.ponTamanioLienzo(1300, 650);
        canvas.ponEscalaX(00, 100);
        canvas.ponEscalaY(0, 100);

        //Establecer fondo
        fondo = new Fondo(canvas.pideLimiteXMax(), canvas.pideLimiteYMax());
        canvas.dibujo((canvas.pideLimiteXMax() / 2), (canvas.pideLimiteYMax() / 2), fondo.getImgSprite(), 1000, 650);

        //Pintar Nave
        heroe = new NaveRebelde(canvas);
        canvas.dibujo((canvas.pideLimiteXMax() / 2) - 2, canvas.pideLimiteYMin() + 14, heroe.getImgSprite());

        //Mover Nave
        teclado = new Entrada();

    }

    public void mover() throws InterruptedException {
        while (true) { //Mientras que las vidas no se acaben
            //if (canvas.fuePulsadaTecla(KeyEvent.VK_A)) {
            while (heroe.getX() > (canvas.pideLimiteXMin() + 5)) {
                sleep(600);//sleep(600) para que la nave recorra la pantalla en 5s
                teclado.moverIzq(canvas, heroe);
                canvas.dibujo(heroe.getX(), heroe.getY(), heroe.getImgSprite());
            }
            //}

            //if (canvas.fuePulsadaTecla(KeyEvent.VK_D)) {
            while (heroe.getX() < (canvas.pideLimiteXMax() - 5)) {
                sleep(600);//sleep(600) para que la nave recorra la pantalla en 5s
                teclado.moverDer(canvas, heroe);
                canvas.dibujo(heroe.getX(), heroe.getY(), heroe.getImgSprite());
            }
            //}
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

}
