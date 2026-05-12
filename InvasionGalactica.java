
import static java.lang.Thread.sleep;

/**
 *
 * @author speed
 */
public class InvasionGalactica {

    public static void main(String[] args) throws InterruptedException {
        Juego j1 = new Juego();
        while (true) {
            j1.dibuja();
            sleep(500);
            j1.limpia();
            j1.mover();
        }
        // j1.dibuja();
    }
}
