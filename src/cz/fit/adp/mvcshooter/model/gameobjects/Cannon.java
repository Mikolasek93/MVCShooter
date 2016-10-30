package cz.fit.adp.mvcshooter.model.gameobjects;

import cz.fit.adp.mvcshooter.model.Model;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Cannon extends GameObject {

    private MoveState moveState;

    private static final int initialXPosition = 20;
    private static final int initialYPosition = Model.MAP_HEIGHT / 2;

    public Cannon() {
        x = initialXPosition;
        y = initialYPosition;
    }

    public void move() {
        switch (moveState) {
            case MOVING_DOWN:
                if (y < (Model.MAP_HEIGHT - height)) {
                    y++;
                }
                break;
            case MOVING_UP:
                if (y > height) {
                    y--;
                }
                break;
        }
        System.out.println("Cannon Y position : " + y);
    }

    public void shoot() {
        System.out.println("Shooooooot");
    }

    public void switchShootingState() {
        System.out.println("SwitchState");
    }

    public MoveState getMoveState() {
        return moveState;
    }

    public void setMoveState(MoveState moveState) {
        this.moveState = moveState;
        move();
    }

}
