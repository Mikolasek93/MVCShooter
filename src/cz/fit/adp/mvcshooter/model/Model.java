/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.model;

/**
 *
 * @author Mikolasek
 */
public class Model {
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
