/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.patterns;
import java.util.ArrayList;

/**
 *
 * @author kermi
 */
public class DeluxeMotelRoom extends MotelRoom{
     public DeluxeMotelRoom()
    {
        super();
        baseRate = 75;
    }
    
    public DeluxeMotelRoom(RoachColony c, String t, ArrayList<String> a)
    {
        super(c,t,a);
        
        baseRate = 75;
    }
    
     @Override
    public double getCost()
    {
        return baseRate;
    }
    
    private double baseRate;
    
}

