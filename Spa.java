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
public class Spa extends AmenityDecorator{
    MotelRoom room;
    
    public Spa(MotelRoom r)
    {
        room = r;
    }
    
    @Override
    public String getDescription()
    {
        return "Spa";
    }
    
    @Override
    public double getCost()
    {
        return 20;
    }
    
}
