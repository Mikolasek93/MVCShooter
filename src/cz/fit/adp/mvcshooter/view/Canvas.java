package cz.fit.adp.mvcshooter.view;

import cz.fit.adp.mvcshooter.model.gameobjects.Cannon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Canvas extends JPanel implements Observer { 
    GraphicsDrawer drawer = new GraphicsDrawer();

    Cannon cannon;
    
    public Canvas(int x, int y, int width, int height, Cannon cannon) {
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);
    this.cannon = cannon;        
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);    
        drawer.drawCannon(g, cannon);
    }

    @Override
    public void update(Observable o, Object o1) {
        repaint();
    }
}
