/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.model;

import cz.fit.adp.mvcshooter.model.factory.GameObjectFactory;
import cz.fit.adp.mvcshooter.model.gameobjects.Bullet;
import cz.fit.adp.mvcshooter.model.gameobjects.Cannon;
import cz.fit.adp.mvcshooter.model.gameobjects.Enemy;
import cz.fit.adp.mvcshooter.model.shootState.ShootState;
import java.util.ArrayList;

/**
 *
 * @author Mikolasek
 */
public class Memento {

    public long initialTime;
    public long runTimeOnSave;

    private Cannon cannon;
    private ArrayList<Enemy> enemies;
    private ArrayList<Bullet> bullets;
    private ShootState shootState;
    private GameObjectFactory objectFactory;
    private int score;

    public Memento(Model model) {
        setState(model);
    }

    private void setState(Model model) {
        cannon = model.getCannon().copy();
        enemies = new ArrayList<Enemy>();
        bullets = new ArrayList<Bullet>();
        score = model.getScore();
        objectFactory = model.getObjectFactory();
        runTimeOnSave = System.currentTimeMillis()-model.getInitialTime();

        for (Enemy enemy : model.getEnemies()) {
            enemies.add(enemy.copy());
        }

        for (Bullet bullet : model.getBullets()) {
            bullets.add(bullet.copy());
        }
    }
    
    public Model getState(){
        Model model = new Model(objectFactory);
        model.setCannon(cannon);
        model.setEnemies(enemies);
        model.setBullets(bullets);
        model.setScore(score);
        model.setInitialTime(System.currentTimeMillis()-runTimeOnSave);
        setState(model);
        return model;
    }
}
