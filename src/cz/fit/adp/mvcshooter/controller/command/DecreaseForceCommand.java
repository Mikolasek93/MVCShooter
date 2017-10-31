/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.controller.command;

import cz.fit.adp.mvcshooter.model.Model;
import cz.fit.adp.mvcshooter.model.gameobjects.Cannon;

/**
 *
 * @author Mikolasek
 */
public class DecreaseForceCommand extends Command {

    @Override
    public void execute(Model model) {
        model.getCannon().decreaseForce();
    }
    
}
