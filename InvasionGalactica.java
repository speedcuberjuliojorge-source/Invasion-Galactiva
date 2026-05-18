
import static java.lang.Thread.sleep;

/**
 * Clase gestora principal de "Invasion Galactica"
 *
 * @author speed
 */
public class InvasionGalactica {

    /**
     * Metodo main(gestor) principal de la clase InvasionGalactuca
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Juego j1 = new Juego();
        while (j1.getElemento()[1].getVidas() > 0) {
            j1.limpia();
            j1.mover();
            j1.dibuja();
            sleep(50);

        }
    }
}
