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
public class RefillBar extends AmenityDecorator{
    MotelRoom room;
    
    public RefillBar(MotelRoom r)
    {
        room = r;
    }
    
    @Override
    public String getDescription()
    {
        return "RefillBar";
    }
    
    @Override
    public double getCost()
    {
        return 5;
    }
    
}
