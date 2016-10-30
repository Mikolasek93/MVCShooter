/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.controller.command;

import cz.fit.adp.mvcshooter.model.gameobjects.Cannon;

/**
 *
 * @author Mikolasek
 */

public class IncreaseForceCommand extends CannonCommand {

    public IncreaseForceCommand(Cannon cannon) {
        super(cannon);
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
