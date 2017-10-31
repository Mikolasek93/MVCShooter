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
public class RealisticBulletMovementStrategy implements BulletMovementStrategy {

    @Override
    public void move(Bullet bullet) {
        int speed = bullet.getSpeed();
        int angle = bullet.getAngle();

        bullet.setX((int) (bullet.getX() + speed * Bullet.BULLET_STEP * Math.cos(Math.toRadians(bullet.getAngle()))));
        bullet.setY((int) (bullet.getY() + speed * Bullet.BULLET_STEP * Math.sin(Math.toRadians(bullet.getAngle()))));

        if (angle < 90) {
            bullet.setAngle(angle + bullet.getGravity()/5);
        }
    }
}
