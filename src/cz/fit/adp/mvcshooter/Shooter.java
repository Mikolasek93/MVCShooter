package cz.fit.adp.mvcshooter;

import cz.fit.adp.mvcshooter.controller.InputHandler;
import cz.fit.adp.mvcshooter.model.CareTaker;
import cz.fit.adp.mvcshooter.model.Model;
import cz.fit.adp.mvcshooter.model.factory.RealisticGameObjectFactory;
import cz.fit.adp.mvcshooter.view.MainWindow;
import javax.swing.SwingUtilities;

/**
 * @author Mikolasek
 */
public class Shooter {
    public static final int MS_PER_FRAME = 16;

    public static void main(String[] args) throws InterruptedException {
        Model model = new Model(new RealisticGameObjectFactory());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow testWindow = new MainWindow(model);
                testWindow.addKeyListener(new InputHandler(model,new CareTaker(model)));
                testWindow.setVisible(true);
                testWindow.repaint();
            }  
        });

        /*
        * HERNI SMYCKA
        */
        while (true) {
            if(model.getRemainingTime() < 0){
                break;
            }
            long startFrameTime = System.currentTimeMillis();
            model.update();
            long paddingTime = startFrameTime + MS_PER_FRAME - System.currentTimeMillis();
            if (paddingTime > 0) {
                Thread.sleep(paddingTime);
            }
        }
        return;
    }
}
