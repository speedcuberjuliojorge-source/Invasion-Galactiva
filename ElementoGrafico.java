
import edu.epromero.util.Imagen;

/**
 * Clase pader, de esta heredan todos los elementos pintados en el lienzo
 *
 * @author speed
 */
public class ElementoGrafico {

    protected int x;
    protected int y;
    protected int Vidas;
    protected boolean visible;
    protected String sprite;
    protected Imagen imgSprite;
    protected int velocidad;

    /**
     * Constructor de clase
     */
    public ElementoGrafico() {
        x = 0;
        y = 0;
        Vidas = 0;
        visible = false;
        sprite = "";
        imgSprite = null;
        velocidad = 0;
    }

    /**
     * Se incluy este metodo para poder llamarlo en sus subclase
     *
     * @param e
     */
    public void mueve(Entrada e) {

    }

    /**
     * Convierte la direccion del setSprite a la Imagen
     */
    public void imagen(String sprite) {
        imgSprite = new Imagen(sprite);
    }

    //Getters y Setters
    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @return
     */
    public int getVidas() {
        return Vidas;
    }

    /**
     *
     * @param Vidas
     */
    public void setVidas(int Vidas) {
        this.Vidas = Vidas;
    }

    /**
     *
     * @return
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     *
     * @param visible
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     *
     * @return
     */
    public String getSprite() {
        return sprite;
    }

    /**
     *
     * @param sprite
     */
    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    /**
     *
     * @return
     */
    public Imagen getImgSprite() {
        return imgSprite;
    }

    /**
     *
     * @param imgSprite
     */
    public void setImgSprite(Imagen imgSprite) {
        this.imgSprite = imgSprite;
    }

    /**
     *
     * @return
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     *
     * @param velocidad
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

}
