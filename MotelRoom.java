/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.patterns;
import java.util.*;


public abstract class MotelRoom 
{
    public MotelRoom()
    {
        colony = new RoachColony();
        roomType = "";
        ameneties = new ArrayList<String>();
    }
    
    public MotelRoom(RoachColony c, String t, ArrayList<String> a)
    {
        colony = c;
        roomType = t;
        ameneties = a;
    }
    
    public void party()
    {
        int pop = colony.getPopulation();
        int roachesDead = pop;
        pop += colony.getGrowthRate() * pop;
        
        if(ameneties.contains("shower"))
        {
            roachesDead /= 4;
            pop -= roachesDead;
            
        }
            
        else
            pop /= 2;
        
        colony.setPopulation(pop);
        
        System.out.println("\nThe " +colony.getName() + " just threw a party!!");           
    }
   
    public AmenityDecorator createAmenity(String type)
    {
        AmenityDecorator temp = null;
            
            if(type.equals("foodbar"))
                temp = new FoodBar(this);
            else if(type.equals("spa"))
                temp = new Spa(this);
            else if(type.equals("refillbar"))
                temp = new RefillBar(this);
            else if(type.equals("shower"))
                temp = new Shower(this);
            
            return temp;
    }
    
    public RoachColony getColony() {return colony;}
    
    public ArrayList getAmeneties() {return ameneties;}
    
    public void setColony(RoachColony colony)
    {
        this.colony = colony;
    }
    
    public void setAmenities(ArrayList<String> a)
    {
        for(int i = 0; i < a.size(); i++)
        {
            ameneties.add(a.get(i));
        }      
    }
    
    public void setRoomType(String r)
    {
        roomType = r;
    }
    
    
    public String getType() {return roomType;}
    
    public abstract double getCost();
    
    public double calcBaseRate()
    {       
        double baseRate = this.getCost();
         
        for(int i = 0; i < ameneties.size(); i++)
        {
            String amenety = ameneties.get(i);
            
            AmenityDecorator temp = createAmenity(amenety);
            
           
            if(!ameneties.isEmpty())
                baseRate += temp.getCost();
        }
        
        return baseRate;
    }
    
    private RoachColony         colony;
    private String              roomType;
    private ArrayList<String>   ameneties;
}
