/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.model.shootState;

import cz.fit.adp.mvcshooter.model.factory.GameObjectFactory;
import cz.fit.adp.mvcshooter.model.gameobjects.Bullet;
import cz.fit.adp.mvcshooter.model.gameobjects.Cannon;
import static cz.fit.adp.mvcshooter.model.shootState.ShootStateEnum.DOUBLE;
import java.util.ArrayList;

/**
 *
 * @author Mikolasek
 */
public class DoubleShootState implements ShootState {
    @Override
    public ArrayList<Bullet> shoot(Cannon cannon,  GameObjectFactory objectFactory) {
        ArrayList<Bullet> bullets = new ArrayList<Bullet>();
        
        Bullet bulletOne = objectFactory.createBullet(cannon.getX(), cannon.getY(), cannon.getAngle()+10, cannon.getForce(),cannon.getGravity());
        Bullet bulletTwo = objectFactory.createBullet(cannon.getX(), cannon.getY(), cannon.getAngle()-10, cannon.getForce(),cannon.getGravity());
        
        bullets.add(bulletOne);
        bullets.add(bulletTwo);
        
        return bullets;
    }

    @Override
    public String toString(){
       return "DOUBLE SHOOTING"; 
    }

    @Override
    public ShootStateEnum toEnum() {
       return DOUBLE;
    }

    @Override
    public DoubleShootState copy() {
        return new DoubleShootState();
    }
}
