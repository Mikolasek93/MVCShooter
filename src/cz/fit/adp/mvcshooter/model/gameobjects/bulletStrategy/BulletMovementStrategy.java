/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.model.gameobjects.bulletStrategy;

import cz.fit.adp.mvcshooter.model.gameobjects.Bullet;

/**
 *
 * @author Mikolasek
 */
public interface BulletMovementStrategy {
    public void move(Bullet bullet);
}
