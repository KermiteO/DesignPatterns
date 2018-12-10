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
public class Shower extends AmenityDecorator{
    MotelRoom room;
    
    public Shower(MotelRoom r)
    {
        room = r;
    }
    
    @Override
    public String getDescription()
    {
        return "Shower";
    }
    
    @Override
    public double getCost()
    {
        return 25;
    }
}
