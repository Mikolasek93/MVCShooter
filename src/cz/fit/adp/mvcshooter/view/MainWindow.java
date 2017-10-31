package cz.fit.adp.mvcshooter.view;

import cz.fit.adp.mvcshooter.controller.InputHandler;
import cz.fit.adp.mvcshooter.model.Model;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class MainWindow extends JFrame {
    public static final int SCREEN_WIDTH = 700;
    public static final int SCREEN_HEIGHT = 700;
    public static final String WINDOW_TITLE = "MVC Shooter - mikolmic@fit.cvut.cz";
    
    private Model model;
    private Canvas view;

    public MainWindow(Model model) {
        try {
            view = new Canvas(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, model);
            //model.getCannon().addObserver(view);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle(WINDOW_TITLE);
            this.setResizable(false);

            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(
                  (int) (screen.getWidth() / 2 - 250),
                  (int) (screen.getHeight() / 2 - 250));

            this.add(view);
            this.pack();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
    
    public void showHelp() {
        JOptionPane.showMessageDialog(this, 
              "Controls: \n"
              + "here goes some description...");
    }
}
