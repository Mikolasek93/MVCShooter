/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.model.factory;

import cz.fit.adp.mvcshooter.model.gameobjects.Bullet;
import cz.fit.adp.mvcshooter.model.gameobjects.Enemy;
import cz.fit.adp.mvcshooter.model.gameobjects.HardEnemy;
import cz.fit.adp.mvcshooter.model.gameobjects.bulletStrategy.RealisticBulletMovementStrategy;

/**
 *
 * @author Mikolasek
 */
public class RealisticGameObjectFactory implements GameObjectFactory{

    @Override
    public Enemy createEnemy(int x, int y) {
        return new HardEnemy(x,y);
    }

    @Override
    public Bullet createBullet(int x, int y, int angle, int force, int gravity) {
        return new Bullet(x, y, angle, force, gravity, new RealisticBulletMovementStrategy());
    }
    
}
