package gameObjects;

import cz.fit.adp.mvcshooter.model.gameobjects.Bullet;
import cz.fit.adp.mvcshooter.model.gameobjects.HardEnemy;
import cz.fit.adp.mvcshooter.model.gameobjects.bulletStrategy.RealisticBulletMovementStrategy;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.mockito.Mock;

/**
 *
 * @author Mikolasek
 */
public class BulletTest {

    @Mock
    private RealisticBulletMovementStrategy bulletStrategy;

    @Test
    public void testOutOfMap() {
        Bullet testedBullet = new Bullet(0, 10, 5, 5, 10, bulletStrategy);
        assertEquals(testedBullet.isOutOfMap(), false);
        testedBullet.setX(9999999);
        assertEquals(testedBullet.isOutOfMap(), true);
    }

    @Test
    public void testCollision() {
        Bullet testedBullet = new Bullet(0, 16, 0, 0, 10, bulletStrategy);
        HardEnemy enemy = new HardEnemy(0, 14);

        assertEquals(testedBullet.collide(enemy), true);
        
        enemy.setX(99);
        
        assertEquals(testedBullet.collide(enemy), false);
    }
}
