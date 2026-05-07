
import edu.epromero.util.Imagen;
import edu.epromero.util.Lienzo;

/**
 * Vidas y visible aplican unicamente para naves
 *
 * @author speed
 */
public class ElementoGrafico {

    //////////ATRIBUTOS//////////
    protected int x;
    protected int y;
    protected int Vidas;
    protected boolean visible;
    protected String sprite;
    protected Imagen imgSprite;

    //////////METODOS//////////

    public ElementoGrafico(int x, int y, String sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }

    public ElementoGrafico() {
        x = 0;
        y = 0;
        Vidas = 0;
        visible = false;
        sprite = "";
        imgSprite = null;
    }

    /**
     * Convierte la direccion del setSprite a la Imagen
     */
    public void imagen(String sprite) {
        imgSprite = new Imagen(sprite);
    }

    public void aparecer(Lienzo l) {
        l.dibujo(x, y, imgSprite);
    }

    public void movimiento() {

    }

    //Getters y Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVidas() {
        return Vidas;
    }

    public void setVidas(int Vidas) {
        this.Vidas = Vidas;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public Imagen getImgSprite() {
        return imgSprite;
    }

    public void setImgSprite(Imagen imgSprite) {
        this.imgSprite = imgSprite;
    }

}
