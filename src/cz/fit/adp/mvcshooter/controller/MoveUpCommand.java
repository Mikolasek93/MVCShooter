/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.controller;

import cz.fit.adp.mvcshooter.model.Cannon;
import cz.fit.adp.mvcshooter.model.MoveState;

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
