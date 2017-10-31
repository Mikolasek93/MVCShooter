/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.model.gameobjects;

import cz.fit.adp.mvcshooter.model.Model;
import cz.fit.adp.mvcshooter.view.Visitor;
import java.util.Observable;

/**
 *
 * @author Mikolasek
 */
public abstract class GameObject {

    /*
    Object map position and size
     */
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract void accept(Visitor visitor);

    public boolean collide(GameObject gameObject) {
        if (x >= gameObject.getX() && x <= gameObject.getX() + gameObject.getWidth()) {
            if (y >= gameObject.getY() && y <= gameObject.getY() + gameObject.getHeight()) {
                return true;
            }
        } else if (x + width >= gameObject.getX() && x + width <= gameObject.getX() + gameObject.getWidth()) {
            if (y + height >= gameObject.getY() && y + height <= gameObject.getY() + gameObject.getHeight()) {
                return true;
            }
        }
        
        return false;
    }
    
    public abstract GameObject copy();
        
    public boolean isOutOfMap(){
        if(x > Model.MAP_WIDTH || x < 0 || y > Model.MAP_HEIGHT || y < 0){
            return true;
        }
        return false;
    }
}
