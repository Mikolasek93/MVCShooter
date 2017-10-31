/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.model.gameobjects;

import static cz.fit.adp.mvcshooter.model.gameobjects.EnemyDirection.*;
import cz.fit.adp.mvcshooter.view.Visitor;

/**
 *
 * @author Mikolasek
 */
public class HardEnemy extends Enemy{
    private static final int directionStepCountLimit = 50;
    private static final int STEP_SIZE = 2;
    
    private EnemyDirection direction = EnemyDirection.randomDirection();
    private int directionStepCount = 0;
    

    public HardEnemy(int x, int y) {
        super(x,y);
    }
    
    @Override
    public void move() {
        super.move();
        if(hit){
            return;
        }
        
        if(isOutOfMap()){
            goOppositeDirection();
        }
        
        if(directionStepCount == directionStepCountLimit){
            switchDirection();
            directionStepCount = 0;
        }
        
        switch(direction){
            case UP:
                y+=STEP_SIZE;
                break;
            case DOWN: 
                y-=STEP_SIZE;
                break;
            case LEFT: 
                x-=STEP_SIZE;
                break;
            case RIGHT:
                x+=STEP_SIZE;
                break;
        }
        

        
        directionStepCount++;
    }

    public void switchDirection(){
        direction = EnemyDirection.randomDirection();
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    public void goOppositeDirection(){
        direction = direction.getOpposite();
    }

    public void setDirection(EnemyDirection direction) {
        this.direction = direction;
    }  

    public void setDirectionStepCount(int directionStepCount) {
        this.directionStepCount = directionStepCount;
    }
    
    
    @Override
    public HardEnemy copy() {
        HardEnemy copiedEnemy = new HardEnemy(x, y);
        copiedEnemy.setHit(hit);
        copiedEnemy.setHitTime(hitTime);
        copiedEnemy.setDirection(direction);
        copiedEnemy.setDirectionStepCount(directionStepCount);
        return copiedEnemy;
    }
}
