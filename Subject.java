/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.patterns;

/**
 *
 * @author kermi
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObservers(Observer o);
    public void notifyObserver();
    
}
