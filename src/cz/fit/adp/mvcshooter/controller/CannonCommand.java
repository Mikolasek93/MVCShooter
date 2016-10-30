/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.controller;

import cz.fit.adp.mvcshooter.model.Cannon;

/**
 *
 * @author Mikolasek
 */
public abstract class CannonCommand {

    Cannon cannon;
    
    public CannonCommand(Cannon cannon){
        this.cannon = cannon;
    }
    
    public abstract void execute();
}
