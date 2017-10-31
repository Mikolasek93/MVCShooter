/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.model.factory;

import cz.fit.adp.mvcshooter.model.gameobjects.Bullet;
import cz.fit.adp.mvcshooter.model.gameobjects.Enemy;

/**
 *
 * @author Mikolasek
 */
public interface GameObjectFactory {
    public Enemy createEnemy (int x, int y);
    public Bullet createBullet (int x, int y, int angle, int force, int gravity);
}
