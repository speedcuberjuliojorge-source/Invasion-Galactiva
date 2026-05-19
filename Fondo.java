
import edu.epromero.util.Lienzo;
import java.awt.Color;
import java.awt.Font;

/**
 * Clase Fondo, hereda de ElementoGrafico y define el fondo
 *
 * @author speed
 */
public class Fondo extends ElementoGrafico {

    private double alto;
    private double ancho;

    /**
     * Este constructor recupera valores de superclase "ElementoGrafico" Asigna
     * valores pasador como parametros Accede al metodo super.setSpritpe(para la
     * direccion de la foto) Accede al metodo super.imagen(Para asignar el
     * setSprite a la Imagen)
     *
     * @param alto
     * @param ancho
     */
    public Fondo(double alto, double ancho) {
        super();
        this.alto = alto;
        this.ancho = ancho;
        super.setSprite(".\\resources\\Fondo.png");
        super.imagen(sprite);
        super.setVisible(true);

    }

    public void pintaDatos(Lienzo canvas, Entrada entrada) {
        Font fuente = new Font("Arial", Font.BOLD, 36); //Crea una fuente con tipo de letra, tipografia y tamaño
        canvas.ponFuente(fuente); //Estableze la fuente al canvas
        canvas.ponColorLapiz(Color.RED); //Establece el color del lapiz
        canvas.texto(canvas.pideLimiteXMin() + 8, canvas.pideLimiteYMin() + 8, "Vidas: " + entrada.getHeroe().getVidas());
        canvas.texto(canvas.pideLimiteXMax() - 8, canvas.pideLimiteYMin() + 8, "Puntos: " + entrada.getHeroe().getPuntos());
    }

    //Setters y Getters
    /**
     *
     * @return
     */
    public double getAlto() {
        return alto;
    }

    /**
     *
     * @param alto
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }

    /**
     *
     * @return
     */
    public double getAncho() {
        return ancho;
    }

    /**
     *
     * @param ancho
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

}
