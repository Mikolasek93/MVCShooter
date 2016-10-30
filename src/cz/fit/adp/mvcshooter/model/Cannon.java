package cz.fit.adp.mvcshooter.model;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Cannon {

    private MoveState moveState;

    public int getX() {
        return 50;
    }

    public int getY() {
        return 100;
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

        if (moveState == MoveState.STOPPED) {
            System.out.println("stop");
        } else {
            System.out.println("move");
        }
    }

}
