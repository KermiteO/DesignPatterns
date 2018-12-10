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
public class RegularMotelRoom extends MotelRoom{
    public RegularMotelRoom()
    {
        super();
        baseRate = 50;
    }
    
    public RegularMotelRoom(RoachColony c, String t, ArrayList<String> a)
    {
        super(c,t,a);
        
        baseRate = 50;
    }
        
    
    @Override
    public double getCost()
    {
        return baseRate;
    }
    
    private double baseRate;
    
}
