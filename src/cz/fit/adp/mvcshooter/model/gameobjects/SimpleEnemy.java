/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.model.gameobjects;

import cz.fit.adp.mvcshooter.view.Visitor;

/**
 *
 * @author Mikolasek
 */
public class SimpleEnemy extends Enemy{
    public SimpleEnemy(int x, int y) {
        super(x,y);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void move() {
        super.move();
    }
    
    
    @Override
    public SimpleEnemy copy() {
        SimpleEnemy copiedEnemy = new SimpleEnemy(x, y);
        copiedEnemy.setHit(hit);
        copiedEnemy.setHitTime(hitTime);
        System.out.println("KOPIRUJU NEPRITELE");
        return copiedEnemy;
    }
    
}
