
import edu.epromero.util.Lienzo;

/**
 *
 * @author speed
 */
public class Juego {

    //////////ATRIBUTOS//////////
    private Lienzo canvas;
    private Fondo fondo;

    //////////METODOS//////////
    //Constructor
    public Juego() {

        //Tamaño y escala lienzo
        canvas = new Lienzo();
        canvas.ponTamanioLienzo(1000, 650);
        canvas.ponEscalaX(0, 100);
        canvas.ponEscalaY(0, 100);

        //Establecer fondo
        fondo = new Fondo(canvas.pideLimiteXMax(), canvas.pideLimiteYMax());
        canvas.dibujo((canvas.pideLimiteXMax() / 2) - 2.5, canvas.pideLimiteYMax() / 2, fondo.getImgSprite());

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
