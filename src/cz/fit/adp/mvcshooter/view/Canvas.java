package cz.fit.adp.mvcshooter.view;

import cz.fit.adp.mvcshooter.model.Model;
import cz.fit.adp.mvcshooter.model.gameobjects.GameObject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author Michal Mikolasek
 */
public class Canvas extends JPanel implements Observer { 
    GraphicsDrawer drawer = new GraphicsDrawer();
    Model model;
    
    public Canvas(int x, int y, int width, int height, Model model) {
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);
        this.model = model;
        model.addObserver(this);
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawer.setGraphics(g);
        
        for (GameObject gameObject : model.getAllGameObjects()){
            gameObject.accept(drawer);
        }
        g.drawString(model.infoPanelString(),10,10);
    }

    @Override
    public void update(Observable o, Object o1) {
        repaint();
    }
}
