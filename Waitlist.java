/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.patterns;
import java.util.*;
/**
 *
 * @author kermi
 */
public class Waitlist implements Subject{
    private ArrayList<Observer> observers;
    private RoachColony latestColony;
    
    public Waitlist()
    {
        observers = new ArrayList<Observer>();
    }
    
    public ArrayList<Observer> getObservers() {return observers;}
    
    public void registerObserver(Observer o)
    {
        observers.add(o);
    }
    
    public void removeObservers(Observer o)
    {
        observers.clear();
    }
    
    public void notifyObserver()
    {
        for(int j = 0; j < observers.size(); j++)
        {
            Observer observer = (Observer)observers.get(j);
            
            if(j == 0)
                observer.update(latestColony);
        }
    }
    
    public void newRoomAvailable(RoachColony latestColony)
    {
        this.latestColony = latestColony;
        
        notifyObserver();
    }   
}
