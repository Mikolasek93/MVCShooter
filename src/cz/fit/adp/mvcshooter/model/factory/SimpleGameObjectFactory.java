/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.model.factory;

import cz.fit.adp.mvcshooter.model.gameobjects.Bullet;
import cz.fit.adp.mvcshooter.model.gameobjects.Enemy;
import cz.fit.adp.mvcshooter.model.gameobjects.SimpleEnemy;
import cz.fit.adp.mvcshooter.model.gameobjects.bulletStrategy.SimpleBulletMovementStrategy;

/**
 *
 * @author Mikolasek
 */
public class SimpleGameObjectFactory implements GameObjectFactory{

    @Override
    public Enemy createEnemy(int x, int y) {
        return new SimpleEnemy(x,y);
    }

    @Override
    public Bullet createBullet(int x, int y, int angle, int force, int gravity) {
        return new Bullet(x, y, angle, force, gravity, new SimpleBulletMovementStrategy());
    }
}
