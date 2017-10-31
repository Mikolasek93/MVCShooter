package cz.fit.adp.mvcshooter.view;

import cz.fit.adp.mvcshooter.model.Model;
import cz.fit.adp.mvcshooter.model.gameobjects.Bullet;
import cz.fit.adp.mvcshooter.model.gameobjects.Cannon;
import cz.fit.adp.mvcshooter.model.gameobjects.Enemy;
import cz.fit.adp.mvcshooter.model.gameobjects.HardEnemy;
import cz.fit.adp.mvcshooter.model.gameobjects.SimpleEnemy;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author 
 */
public class GraphicsDrawer implements Visitor{
    private static final int INFO_X = 5;
    private static final int INFO_Y = 15;
    
    private BufferedImage cannonImage;
    private BufferedImage enemyImage1;
    private BufferedImage enemyImage2;
    private BufferedImage missileImage;
    private BufferedImage collisionImage;
    private Graphics graphics;
 

    public GraphicsDrawer() {
        try {
            cannonImage = ImageIO.read(getClass().getResourceAsStream("/resources/images/cannon.png"));
            enemyImage1 = ImageIO.read(getClass().getResourceAsStream("/resources/images/enemy1.png"));
            enemyImage2 = ImageIO.read(getClass().getResourceAsStream("/resources/images/enemy2.png"));
            missileImage = ImageIO.read(getClass().getResourceAsStream("/resources/images/missile.png"));
            collisionImage = ImageIO.read(getClass().getResourceAsStream("/resources/images/collision.png"));
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
        
    
    public void drawCannon(Graphics g, Cannon cannon) {
        g.drawImage(cannonImage, 
              cannon.getX() - cannonImage.getWidth()/2, 
              (int)((double)cannon.getY()/Model.MAP_HEIGHT*MainWindow.SCREEN_HEIGHT) - cannonImage.getHeight()/2, null);
    }
    
    public void drawBullet(Graphics g, Bullet bullet) {
         g.drawImage(missileImage, 
              bullet.getX() - missileImage.getWidth()/2, 
              (int)((double)bullet.getY()/Model.MAP_HEIGHT*MainWindow.SCREEN_HEIGHT) - missileImage.getHeight()/2, null);
    }
    
    public void drawEnemy(Graphics g, Enemy enemy) {
        BufferedImage enemyImage = enemy.isShot() ? collisionImage : enemyImage1;
        
          g.drawImage(enemyImage, 
              enemy.getX() - enemyImage.getWidth()/2, 
              (int)((double)enemy.getY()/Model.MAP_HEIGHT*MainWindow.SCREEN_HEIGHT) - enemyImage.getHeight()/2, null);
    }
    

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    @Override
    public void visit(Bullet bullet) {
          drawBullet(graphics, bullet);
        //drawCannon(graphics, cannon);//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Cannon cannon) {
          drawCannon(graphics, cannon);
                  //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void visit(SimpleEnemy enemy) {
        drawEnemy(graphics, enemy);
    }

    @Override
    public void visit(HardEnemy enemy) {
        drawEnemy(graphics, enemy);
    }
}
