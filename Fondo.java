
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
