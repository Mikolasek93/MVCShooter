/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.model.shootState;

import cz.fit.adp.mvcshooter.model.factory.GameObjectFactory;
import cz.fit.adp.mvcshooter.model.gameobjects.Bullet;
import cz.fit.adp.mvcshooter.model.gameobjects.Cannon;
import java.util.ArrayList;

/**
 *
 * @author Mikolasek
 */
public interface ShootState {
    public ArrayList<Bullet> shoot(Cannon cannon, GameObjectFactory objectFactory);
    public ShootStateEnum toEnum();
    public ShootState copy();
}
