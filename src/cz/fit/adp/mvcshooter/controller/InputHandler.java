/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.controller;

import cz.fit.adp.mvcshooter.model.Cannon;
import cz.fit.adp.mvcshooter.model.Model;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener;

/**
 *
 * @author Mikolasek
 */
public class InputHandler implements KeyListener{

    public static final int MOVE_UP_KEY = VK_UP;
    public static final int MOVE_DOWN_KEY = VK_DOWN;
    public static final int SHOOT_KEY = VK_SPACE;
    public static final int SWITCH_STATE_KEY = VK_SHIFT;
    
    CannonCommand moveUpCommand;
    CannonCommand moveDownCommand;
    CannonCommand shootCommand;
    CannonCommand switchCannonStateCommand;
            
    
    Model model;
    private final StopCommand stopCommand;
    
    public InputHandler(Model model){
        this.model = model;
        Cannon cannon = model.getCannon();
        
        moveUpCommand = new MoveUpCommand(cannon);
        moveDownCommand = new MoveDownCommand(cannon);
        stopCommand = new StopCommand(cannon);
        shootCommand = new ShootCommand(cannon);
        switchCannonStateCommand = new SwitchCannonStateCommand(cannon);
        
    }
    

    @Override
    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode()){
            case MOVE_UP_KEY: moveUpCommand.execute(); break;
            case MOVE_DOWN_KEY: moveDownCommand.execute(); break;
            case SHOOT_KEY: shootCommand.execute(); break;
            case SWITCH_STATE_KEY: switchCannonStateCommand.execute(); break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        switch(ke.getKeyCode()){
            case MOVE_UP_KEY: stopCommand.execute(); break;
            case MOVE_DOWN_KEY: stopCommand.execute(); break;
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
