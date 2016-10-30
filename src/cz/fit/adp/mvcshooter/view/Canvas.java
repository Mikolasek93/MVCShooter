package cz.fit.adp.mvcshooter.view;

import cz.fit.adp.mvcshooter.model.gameobjects.Cannon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Canvas extends JPanel { 
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
    
    public void thisIsHowYouForceGuiToRepaint() {        
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);    
        drawer.drawCannon(g, cannon);
        System.out.println("Y : " + cannon.getY());
    }
    
}
