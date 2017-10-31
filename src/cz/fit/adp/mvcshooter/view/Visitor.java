/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.view;

import cz.fit.adp.mvcshooter.model.gameobjects.Bullet;
import cz.fit.adp.mvcshooter.model.gameobjects.Cannon;
import cz.fit.adp.mvcshooter.model.gameobjects.HardEnemy;
import cz.fit.adp.mvcshooter.model.gameobjects.SimpleEnemy;

/**
 *
 * @author Mikolasek
 */
public interface Visitor {
    public void visit(Bullet bullet);
    public void visit(Cannon cannon);
    public void visit(SimpleEnemy enemy);
    public void visit(HardEnemy enemy);
}
