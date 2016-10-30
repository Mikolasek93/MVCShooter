/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.controller.command;

import cz.fit.adp.mvcshooter.controller.command.CannonCommand;
import cz.fit.adp.mvcshooter.model.gameobjects.Cannon;
import cz.fit.adp.mvcshooter.model.gameobjects.MoveState;

/**
 *
 * @author Mikolasek
 */
public class MoveUpCommand extends CannonCommand {

    public MoveUpCommand(Cannon cannon) {
        super(cannon);
    }

    @Override
    public void execute() {
        cannon.setMoveState(MoveState.MOVING_UP);
    }

}
