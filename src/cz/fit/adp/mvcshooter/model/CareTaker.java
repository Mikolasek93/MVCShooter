/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.adp.mvcshooter.model;

/**
 *
 * @author Mikolasek
 */
public class CareTaker {

    private Model originator;
    private Memento memento;

    public CareTaker(Model originator) {
        this.originator = originator;
    }

    public void save() {
        memento = originator.createMemento();
        System.out.println("MODEL SAVED");
    }

    public void load() {
        if (memento != null) {
            originator.setMemento(memento);
        }
    }
}
