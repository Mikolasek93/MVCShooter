package cz.fit.adp.mvcshooter.model.gameobjects;

import cz.fit.adp.mvcshooter.model.Model;
import cz.fit.adp.mvcshooter.model.factory.GameObjectFactory;
import cz.fit.adp.mvcshooter.model.shootState.DoubleShootState;
import cz.fit.adp.mvcshooter.model.shootState.ShootState;
import static cz.fit.adp.mvcshooter.model.shootState.ShootStateEnum.*;
import cz.fit.adp.mvcshooter.model.shootState.SingleShootState;
import cz.fit.adp.mvcshooter.view.Visitor;
import java.util.ArrayList;

/**
 *
 * @author Michal Mikolasek */
public class Cannon extends GameObject {
    private MoveState moveState = MoveState.STOPPED;
    private ShootState shootState;

    private static final int initialXPosition = 20;
    private static final int initialYPosition = Model.MAP_HEIGHT / 2;

    private static final int stepSize = 10;

    private static final int maxAngle = 80;
    private static final int minAngle = -80;

    private static final int minForce = 1;
    private static final int maxForce = 100;
    
    private static final int minGravity = 0;
    private static final int maxGravity = 10;

    private int gravity = 10;
    private int angle = 0;
    private int force = 10;
    

    public Cannon() {
        shootState = new SingleShootState();

        x = initialXPosition;
        y = initialYPosition;
    }

    public void move() {
        switch (moveState) {
            case MOVING_DOWN:
                if (y < (Model.MAP_HEIGHT - height)) {
                    y += stepSize;
                }
                break;
            case MOVING_UP:
                if (y > height) {
                    y -= stepSize;
                }
                break;
        }
    }

    public ArrayList<Bullet> shoot(GameObjectFactory objectFactory) {
        return shootState.shoot(this, objectFactory);
    }
    
    public void switchShootingState() {
        if (shootState.toEnum().equals(DOUBLE)) {
            setShootState(new SingleShootState());
        } else {
            setShootState(new DoubleShootState());
        }
    }

    public MoveState getMoveState() {
        return moveState;
    }

    public void setMoveState(MoveState moveState) {
        this.moveState = moveState;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public ShootState getShootState() {
        return shootState;
    }

    public void setShootState(ShootState shootState) {
        this.shootState = shootState;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void increaseAngle() {
        if (angle < maxAngle) {
            angle++;
        }
    }

    public void decreaseAngle() {
        if (angle > minAngle) {
            angle--;
        }
    }

    public void increaseForce() {
        if (force < maxForce) {
            force++;
        }
    }

    public void decreaseForce() {
        if (force > minForce) {
            force--;
        }
    }

    public void increaseGravity() {
        if (gravity < maxGravity) {
            gravity++;
        }
    }

    public void decreaseGravity() {
        if (gravity > minGravity) {
            gravity--;
        }
    }

    @Override
    public Cannon copy() {
        Cannon copiedCannon = new Cannon();
        copiedCannon.setAngle(angle);
        copiedCannon.setForce(force);
        copiedCannon.setX(x);
        copiedCannon.setY(y);
        copiedCannon.setGravity(gravity);
        copiedCannon.setShootState(shootState.copy());
        return copiedCannon;
    }
}
