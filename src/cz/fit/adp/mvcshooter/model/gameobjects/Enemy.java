/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.model.gameobjects;

import cz.fit.adp.mvcshooter.model.Model;
import java.util.Random;

/**
 *
 * @author Mikolasek
 */
public abstract class Enemy extends GameObject {
    public static final int ENEMY_WIDTH = 30;
    public static final int ENEMY_HEIGHT = 30;
    public static final int HIT_REMAIN_TIME = 100;
    protected int hitTime = 0;
    protected boolean hit = false;
    
    public Enemy(int x, int y){
        super();
        this.x = x;
        this.y = y;
        width = ENEMY_WIDTH;
        height = ENEMY_HEIGHT;
    }
    public void move(){
        if(hit){
            hitTime++;
        }
        if(hitTime == HIT_REMAIN_TIME){
            hitTime = 0;
            hit = false;
            respawn();
        }
    }
    
    public void respawn(){
        Random random = new Random();
        y=random.nextInt(Model.MAP_HEIGHT - 30) + 30;
        x=random.nextInt(Model.MAP_WIDTH - 30) + 30;
    }
    
    public void hit(){
        hit = true;
    }
    
    public boolean isShot(){
        return hit;
    }
    
    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public void setHitTime(int hitTime) {
        this.hitTime = hitTime;
    }
    @Override
    public abstract Enemy copy();
}
