
import edu.epromero.util.Lienzo;

//import java.awt.event.KeyEvent;
public class Entrada {

    public void moverIzq(Lienzo canvas, ElementoGrafico elemento, int avance) {

        if (canvas.existenMasTeclasPulsadas()) {
            //if (canvas.fuePulsadaTecla(KeyEvent.VK_A)) {
            if (elemento.getX() > (canvas.pideLimiteXMin() + 5))/*Se suma el 5 para obtener el
            limite del canvas 0*/ {
                System.out.println("x = " + elemento.getX());
                elemento.setX(elemento.getX() - avance);
                System.out.println("new x = " + elemento.getX());
            }

            //}
        }
    }

    public void moverDer(Lienzo canvas, ElementoGrafico elemento, int avance) {

        if (canvas.existenMasTeclasPulsadas()) {
            //if (canvas.fuePulsadaTecla(KeyEvent.VK_D)) {
            if (elemento.getX() < (canvas.pideLimiteXMax() - 5))/*Se suma el 5 para obtener el
            limite del canvas 0*/ {
                elemento.setX(elemento.getX() + avance);
            }

            //}
        }
    }
}
