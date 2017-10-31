/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.model.shootState;

import cz.fit.adp.mvcshooter.model.factory.GameObjectFactory;
import cz.fit.adp.mvcshooter.model.gameobjects.Bullet;
import cz.fit.adp.mvcshooter.model.gameobjects.Cannon;
import cz.fit.adp.mvcshooter.model.gameobjects.bulletStrategy.SimpleBulletMovementStrategy;
import static cz.fit.adp.mvcshooter.model.shootState.ShootStateEnum.SINGLE;
import java.util.ArrayList;

/**
 *
 * @author Mikolasek
 */
public class SingleShootState implements ShootState {

    @Override
    public ArrayList<Bullet> shoot(Cannon cannon, GameObjectFactory objectFactory) {
        ArrayList<Bullet> bullets = new ArrayList<Bullet>();
        Bullet bullet = objectFactory.createBullet(cannon.getX(), cannon.getY(), cannon.getAngle(), cannon.getForce(),cannon.getGravity());
        bullets.add(bullet);
        return bullets;
    }

    @Override
    public String toString() {
        return "SINGLE SHOOTING";
    }

    @Override
    public ShootStateEnum toEnum() {
        return SINGLE;
    }

    @Override
    public SingleShootState copy() {
        return new SingleShootState();
    }
}
