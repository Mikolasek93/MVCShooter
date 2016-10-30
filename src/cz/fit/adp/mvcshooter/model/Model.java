/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.model;

import cz.fit.adp.mvcshooter.model.gameobjects.Bullet;
import cz.fit.adp.mvcshooter.model.gameobjects.Cannon;
import cz.fit.adp.mvcshooter.model.gameobjects.Enemy;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Mikolasek
 */
public class Model {
    public static final int MAP_WIDTH = 2000;
    public static final int MAP_HEIGHT = 1000;
    
    private Cannon cannon;
    private Vector<Enemy> enemies;
    private Vector<Bullet> bullets;
    
    
    public Model(){
        cannon = new Cannon();
        enemies = new Vector<Enemy>();
        bullets = new Vector<Bullet>();
    }

    
    
    public Cannon getCannon() {
        return cannon;
    }

    public void setCannon(Cannon cannon) {
        this.cannon = cannon;
    }
    
    
}
