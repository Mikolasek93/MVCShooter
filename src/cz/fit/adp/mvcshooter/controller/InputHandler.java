/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.controller;

import cz.fit.adp.mvcshooter.controller.command.SwitchCannonStateCommand;
import cz.fit.adp.mvcshooter.controller.command.StopCommand;
import cz.fit.adp.mvcshooter.controller.command.MoveUpCommand;
import cz.fit.adp.mvcshooter.controller.command.MoveDownCommand;
import cz.fit.adp.mvcshooter.controller.command.Command;
import cz.fit.adp.mvcshooter.controller.command.DecreaseAngleCommand;
import cz.fit.adp.mvcshooter.controller.command.DecreaseForceCommand;
import cz.fit.adp.mvcshooter.controller.command.DecreaseGravityCommand;
import cz.fit.adp.mvcshooter.controller.command.IncreaseAngleCommand;
import cz.fit.adp.mvcshooter.controller.command.IncreaseForceCommand;
import cz.fit.adp.mvcshooter.controller.command.IncreaseGravityCommand;
import cz.fit.adp.mvcshooter.model.CareTaker;
import cz.fit.adp.mvcshooter.model.gameobjects.Cannon;
import cz.fit.adp.mvcshooter.model.Model;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener;

/**
 *
 * @author Mikolasek
 */
public class InputHandler implements KeyListener{
    private static final int MOVE_UP_KEY = VK_UP;
    private static final int MOVE_DOWN_KEY = VK_DOWN;
    
    private static final int INCREASE_ANGLE_KEY = VK_RIGHT;
    private static final int DECREASE_ANGLE_KEY = VK_LEFT;
    
    private static final int DECREASE_FORCE_KEY = VK_SUBTRACT;
    private static final int INCREASE_FORCE_KEY = VK_ADD;
    
    private static final int SHOOT_KEY = VK_SPACE;
    private static final int SWITCH_STATE_KEY = VK_SHIFT;
    
    private static final int SAVE_MODEL_KEY = VK_S;
    private static final int LOAD_MODEL_KEY = VK_L;
    
    private static final int INCREASE_GRAVITY_KEY = VK_D;
    private static final int DECREASE_GRAVITY_KEY = VK_A;
    
    private final Command moveUpCommand;
    private final Command moveDownCommand;
    private final Command increaseAngleCommand;
    private final Command increaseForceCommand;
    private final Command decreaseAngleCommand;
    private final Command decreaseForceCommand;
    private final Command switchCannonStateCommand;
    private final Command stopCommand;
    private final Command increaseGravityCommand;
    private final Command decreaseGravityCommand;
            
    
    private Model model;
    private final CareTaker careTaker;
    
    public InputHandler(Model model, CareTaker careTaker){
        this.model = model;
        this.careTaker = careTaker;
        
        moveUpCommand = new MoveUpCommand();
        moveDownCommand = new MoveDownCommand();
        stopCommand = new StopCommand();
        switchCannonStateCommand = new SwitchCannonStateCommand();
        increaseAngleCommand = new IncreaseAngleCommand();
        decreaseAngleCommand = new DecreaseAngleCommand();
        increaseForceCommand = new IncreaseForceCommand();
        decreaseForceCommand = new DecreaseForceCommand();
        increaseGravityCommand = new IncreaseGravityCommand();
        decreaseGravityCommand = new DecreaseGravityCommand();
    }
    

    @Override
    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode()){
            case MOVE_UP_KEY: moveUpCommand.execute(model); break;
            case MOVE_DOWN_KEY: moveDownCommand.execute(model); break;
            case SHOOT_KEY: model.createBullet(); break;
            case SWITCH_STATE_KEY: switchCannonStateCommand.execute(model); break;
            case INCREASE_ANGLE_KEY: increaseAngleCommand.execute(model); break;
            case DECREASE_ANGLE_KEY: decreaseAngleCommand.execute(model); break;
            case INCREASE_FORCE_KEY: increaseForceCommand.execute(model); break;
            case DECREASE_FORCE_KEY: decreaseForceCommand.execute(model); break;
            case INCREASE_GRAVITY_KEY: increaseGravityCommand.execute(model); break;
            case DECREASE_GRAVITY_KEY: decreaseGravityCommand.execute(model); break;       
            case SAVE_MODEL_KEY: careTaker.save(); break;
            case LOAD_MODEL_KEY: careTaker.load(); break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        switch(ke.getKeyCode()){
            case MOVE_UP_KEY: stopCommand.execute(model); break;
            case MOVE_DOWN_KEY: stopCommand.execute(model); break;
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}