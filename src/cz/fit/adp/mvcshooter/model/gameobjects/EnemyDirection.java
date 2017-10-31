/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.model.gameobjects;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Mikolasek
 */
public enum EnemyDirection {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    private EnemyDirection opposite;

    static {
        UP.opposite = DOWN;
        DOWN.opposite = UP;
        LEFT.opposite = RIGHT;
        RIGHT.opposite = LEFT;
    }

    private static final List<EnemyDirection> VALUES = Collections.unmodifiableList(Arrays.asList(values()));     
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static EnemyDirection randomDirection() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public EnemyDirection getOpposite() {
        return opposite;
    }
}
