package cz.fit.adp.mvcshooter.model;

import cz.fit.adp.mvcshooter.model.factory.GameObjectFactory;
import cz.fit.adp.mvcshooter.model.gameobjects.Bullet;
import cz.fit.adp.mvcshooter.model.gameobjects.Cannon;
import cz.fit.adp.mvcshooter.model.gameobjects.Enemy;
import cz.fit.adp.mvcshooter.model.gameobjects.GameObject;
import cz.fit.adp.mvcshooter.model.gameobjects.MoveState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Mikolasek
 */
public class Model extends Observable {

    public static final int MAP_WIDTH = 700;
    public static final int MAP_HEIGHT = 700;
    public static final int ENEMY_COUNT = 10;
    public static final int GAME_TIME_MILLISECS = 120000;

    private Cannon cannon;
    private ArrayList<Enemy> enemies;
    private ArrayList<Bullet> bullets;
    private GameObjectFactory objectFactory;
    private int score;

    public long initialTime;
    public long remainingTime;

    public Model(GameObjectFactory objectFactory) {
        cannon = new Cannon();
        enemies = generateEnemies(objectFactory);
        bullets = new ArrayList<Bullet>();
        this.objectFactory = objectFactory;
        initialTime = System.currentTimeMillis();
    }

    public void update() {
        updateCannon();
        updateEnemies();
        updateBullets();
        updateRemainingTime();

        setChanged();
        notifyObservers();
    }

    private void updateEnemies() {
        for (Enemy enemy : enemies) {
            enemy.move();
        }
    }

    private void updateBullets() {
        Iterator<Bullet> bulletIterator = bullets.iterator();
        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            bullet.move();
            if (bullet.isOutOfMap()) {
                bulletIterator.remove();
                continue;
            }
            for (Enemy enemy : enemies) {
                if (!enemy.isShot() && bullet.collide(enemy)) {
                    bulletIterator.remove();
                    enemy.hit();
                    score++;
                }
            }
        }

    }

    private void updateRemainingTime() {
        remainingTime = GAME_TIME_MILLISECS - (System.currentTimeMillis() - initialTime);
    }

    private void updateCannon() {
        cannon.move();
    }

    public Cannon getCannon() {
        return cannon;
    }

    public void setCannon(Cannon cannon) {
        this.cannon = cannon;
    }

    public void createBullet() {
        bullets.addAll(cannon.shoot(objectFactory));
    }

    public String infoPanelString() {
        String formattedTime = String.format("%d:%d",
                TimeUnit.MILLISECONDS.toMinutes(remainingTime),
                TimeUnit.MILLISECONDS.toSeconds(remainingTime)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(remainingTime))
        );

        return "SCORE: " + score + " ANGLE: " + cannon.getAngle() + " FORCE: " + cannon.getForce() + " SHOOT MODE: " + cannon.getShootState().toString() + " REMAINING TIME: " + formattedTime + " GRAVITY: " + cannon.getGravity();
    }

    public ArrayList<GameObject> getAllGameObjects() {
        ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
        gameObjects.addAll(bullets);
        gameObjects.addAll(enemies);
        gameObjects.add(cannon);
        return gameObjects;
    }

    public GameObjectFactory getObjectFactory() {
        return objectFactory;
    }

    public static ArrayList<Enemy> generateEnemies(GameObjectFactory objectFactory) {
        ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        for (int i = 0; i < ENEMY_COUNT; i++) {
            Enemy enemy = objectFactory.createEnemy(0, 0);
            enemy.respawn();
            enemies.add(enemy);
        }
        return enemies;
    }

    public long getRemainingTime() {
        return remainingTime;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    public int getScore() {
        return score;
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }

    public void setBullets(ArrayList<Bullet> bullets) {
        this.bullets = bullets;
    }

    public void setObjectFactory(GameObjectFactory objectFactory) {
        this.objectFactory = objectFactory;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }

    public void setRemainingTime(long remainingTime) {
        this.remainingTime = remainingTime;
    }

    public void setMemento(Memento memento) {
        Model mementoModel = memento.getState();
        setCannon(mementoModel.getCannon());
        setEnemies(mementoModel.getEnemies());
        setBullets(mementoModel.getBullets());
        setScore(mementoModel.getScore());
        setInitialTime(mementoModel.getInitialTime());
        System.out.println("NACITAM DO MODELU");
    }

    public Memento createMemento() {
        return new Memento(this);
    }

}
