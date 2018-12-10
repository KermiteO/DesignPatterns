/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.patterns;


public class RoachColonyObserver implements Observer{
    private Subject waitlist;
        
    public RoachColonyObserver(Subject waitlist)
    {
        this.waitlist = waitlist;
        
        waitlist.registerObserver(this);
    }
    
    public void update(Object newState)
    {
        RoachColony latestColony = (RoachColony)newState;
        display(latestColony);
    }
    
    public void display(RoachColony latestColony)
    {
        System.out.println("The " + latestColony.getName() + " colony received the notification from The only motel in town");
    }
        
    
}
