/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.model;

import cz.fit.adp.mvcshooter.model.gameobjects.Cannon;

/**
 *
 * @author Mikolasek
 */
public class Model {
    public static final int MAP_WIDTH = 2000;
    public static final int MAP_HEIGHT = 1000;
    
    Cannon cannon;
    
    
    public Model(){
        cannon = new Cannon();
    }

    public Cannon getCannon() {
        return cannon;
    }

    public void setCannon(Cannon cannon) {
        this.cannon = cannon;
    }
    
    
}
