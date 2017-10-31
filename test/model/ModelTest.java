
package model;

import cz.fit.adp.mvcshooter.model.Memento;
import cz.fit.adp.mvcshooter.model.Model;
import cz.fit.adp.mvcshooter.model.factory.SimpleGameObjectFactory;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

/**
 *
 * @author Mikolasek
 */
public class ModelTest {
    
    @Test
    public void testMementoSavedStats() throws InterruptedException{
    Model model = new Model(new SimpleGameObjectFactory());
    
    model.update();
    
    Memento savedMemento = model.createMemento();
    long timeBeforeSave = model.getRemainingTime();
    model.setScore(999);
    
    Thread.sleep(2000);
    model.update();
    model.update();
    
    assertNotEquals(model.getRemainingTime(),timeBeforeSave);
    assertNotEquals(model.getScore(),savedMemento.getState().getScore());
    
    model.setMemento(savedMemento);
    model.update();
    
    assertEquals((model.getRemainingTime()+99)/100*100,(timeBeforeSave+99)/100*100);
    assertEquals(model.getScore(),savedMemento.getState().getScore());
    
    }
    
}
