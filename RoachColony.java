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
public class RoachColony 
{
    public RoachColony()
    {
        name = "";
        population = 0;
        growthRate = 0;
    }
    
    public RoachColony(String s, int p, double r)
    {
        name = s;
        population = p;
        growthRate = r;
    }
    
    @Override
    public String toString()
    {
        return name + " " + population;
    }
     
    public String getName() {return name;}
    
    public int getPopulation() {return population;}
    
    public double getGrowthRate() {return growthRate;}
    
    public void setPopulation(int p) 
    {
        population = p;
    }
    
    
    
    private String name;
    private int population;
    private double growthRate;
    
}
