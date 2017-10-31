/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.model.gameobjects;

import cz.fit.adp.mvcshooter.model.gameobjects.bulletStrategy.BulletMovementStrategy;
import cz.fit.adp.mvcshooter.view.Visitor;

/**
 * Trida pro projektily
 * @author Mikolasek
 */
public class Bullet extends GameObject{
   
    public static final int BULLET_STEP = 1;
    
    public static final int BULLET_WIDTH = 30;
    public static final int BULLET_HEIGHT = 30;
    
    private int angle;
    private int speed;
    private int gravity;
    
    private BulletMovementStrategy movementStrategy;

    public Bullet(int x, int y, int angle, int speed, int gravity, BulletMovementStrategy movementStrategy) {
        this.x = x;
        this.y = y;
        this.width = BULLET_WIDTH;
        this.height = BULLET_HEIGHT;
        this.angle = angle;
        this.speed = speed;
        this.gravity = gravity;
        this.movementStrategy = movementStrategy;
    }
    
    public void move() {
        movementStrategy.move(this);
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public BulletMovementStrategy getMovementStrategy() {
        return movementStrategy;
    }

    public void setMovementStrategy(BulletMovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Bullet copy() {
        return new Bullet(x, y, angle, speed, gravity, movementStrategy);
    }

    
}
