

package gameObjects;

import cz.fit.adp.mvcshooter.model.gameobjects.EnemyDirection;
import cz.fit.adp.mvcshooter.model.gameobjects.HardEnemy;
import cz.fit.adp.mvcshooter.model.gameobjects.SimpleEnemy;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

/**
 *
 * @author Mikolasek
 */
public class EnemyTest {
    @Test
    public void testHardEnemyMove(){
        HardEnemy hardEnemy = new HardEnemy(50,50);
        SimpleEnemy simpleEnemy = new SimpleEnemy(50,50);
        
        int hardEnemyXPos = 50;
        int hardEnemyYPos = 50;
        
        hardEnemy.setDirection(EnemyDirection.LEFT);
        hardEnemy.move();
        
        assertNotEquals(hardEnemyXPos, hardEnemy.getX());
        
        hardEnemy.setDirection(EnemyDirection.DOWN);
        hardEnemy.move();
        
        assertNotEquals(hardEnemyYPos, hardEnemy.getY());
    }
    
    @Test
    public void testSimpleEnemyMove(){
        SimpleEnemy hardEnemy = new SimpleEnemy(50,50);
        
        int simpleEnemyXPos = 50;
        int simpleEnemyYPos = 50;
        
        hardEnemy.move();
        
        assertEquals(simpleEnemyXPos, hardEnemy.getX());
        assertEquals(simpleEnemyYPos, hardEnemy.getY());
    }
}
