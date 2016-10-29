package cz.fit.adp.mvcshooter;

import cz.fit.adp.mvcshooter.view.MainWindow;
import javax.swing.SwingUtilities;

/**
 *
 * @author stue
 */
public class Shooter {
    
    public static void main(String[] args) {        
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
               new MainWindow().setVisible(true);
            }
        });
    }
}
