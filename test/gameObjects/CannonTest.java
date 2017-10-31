package gameObjects;

import static org.mockito.Mockito.mock;


import cz.fit.adp.mvcshooter.model.Model;
import cz.fit.adp.mvcshooter.model.factory.RealisticGameObjectFactory;
import cz.fit.adp.mvcshooter.model.factory.SimpleGameObjectFactory;
import cz.fit.adp.mvcshooter.model.gameobjects.Cannon;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Mikolasek
 */
public class CannonTest {
    
    /*
    * Otestovani vymeny shootStates
    */
    @Test
    public void testShootState(){
        int expected;
        Cannon cannon = new Cannon();
        
        int firstShooting = cannon.shoot(new SimpleGameObjectFactory()).size();
        expected = 1;
        assertEquals(expected, firstShooting);
       
        cannon.switchShootingState();
        
        int secondShooting = cannon.shoot(new SimpleGameObjectFactory()).size();
        expected = 2;
        assertEquals(expected, secondShooting);
        
        cannon.switchShootingState();
        
        int thirdShooting = cannon.shoot(new SimpleGameObjectFactory()).size();
        expected = 1;
        assertEquals(expected, thirdShooting);
     }    
}
