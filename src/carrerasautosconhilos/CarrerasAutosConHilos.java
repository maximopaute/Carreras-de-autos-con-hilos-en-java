package carrerasautosconhilos;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class CarrerasAutosConHilos extends Thread {

    private JLabel eti;
    private PistaCarreraAutosHilos p;

    public CarrerasAutosConHilos(JLabel eti, PistaCarreraAutosHilos p) {
        this.eti = eti;
        this.p = p;
    }

    @Override
    public void run() {
        int auto1 = 0, auto2 = 0, auto3 = 0, auto4 = 0;
        while (true) {
            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(CarrerasAutosConHilos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //getLocation() Se utiliza para ubicar en el jframe cada carrito
            auto1 = p.getlbl1().getLocation().x;
            auto2 = p.getlbl2().getLocation().x;
            auto3 = p.getlbl3().getLocation().x;
            auto4 = p.getlbl3().getLocation().x;
            
            //Mientras auto1 sea menor
            if (auto1 < p.getlbl_Llegada().getLocation().x - 10 && auto2 < p.getlbl_Llegada().getLocation().x - 10
                    && auto3 < p.getlbl_Llegada().getLocation().x - 10 && auto4 < p.getlbl_Llegada().getLocation().x - 10) {

                eti.setLocation(eti.getLocation().x + 10, eti.getLocation().y);
                p.repaint();
            } else {
                break;
            }
        }
        if (eti.getLocation().x >= p.getlbl_Llegada().getLocation().x - 10) {
            if (auto1 > auto2 && auto1 > auto3) {
                JOptionPane.showMessageDialog(null, "Gano el auto 1");
            } else if (auto2 > auto1 && auto2 > auto3) {
                JOptionPane.showMessageDialog(null, "Gano el auto 2");
            } else if (auto3 > auto1 && auto3 > auto2) {
                JOptionPane.showMessageDialog(null, "Gano el auto 3");
            } else if (auto4 > auto1 && auto4 > auto3) {
                JOptionPane.showMessageDialog(null, "Gano el auto 4");
            } else {
                JOptionPane.showMessageDialog(null, "Empate");
            }

        }
    }
}























