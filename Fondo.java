
public class Fondo extends ElementoGrafico {

    //////////ATRIBUTOS//////////
    private double alto;
    private double ancho;

    //////////METODOS//////////

    /**
     * Este constructor recupera valores de superclase "ElementoGrafico"
     * Asigna valores pasador como parametros
     * Accede al metodo super.setSpritpe(para la direccion de la foto)
     * Accede al metodo super.imagen(Para asignar el setSprite a la Imagen)
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
    public double getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

}
