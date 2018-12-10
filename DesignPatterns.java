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
public class DesignPatterns {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("*****************************************");
        System.out.println("*      WELCOME TO THE ROACH MOTEL       *");
        System.out.println("*****************************************");
        
        RoachMotel rm = RoachMotel.getInstance();
        rm.createRooms();
        System.out.println(rm);
        
        
        RoachColony rc1 = new  RoachColony("first colony",100,0.1);
        ArrayList amenities = new ArrayList();
        amenities.add("foodbar");
        amenities.add("spa");
        amenities.add("refillbar");
        amenities.add("shower");
        MotelRoom r1 = rm.checkIn(rc1,"Suite",amenities);
        System.out.println(rc1);
        System.out.println(rm);
        
        //party with/without shower
        //different nights
        //more descriptions
        //different combo of amenities
        //multiple observers
        
       RoachColony rc2 = new RoachColony("Second colony",1000,0.2);
        ArrayList amenities2 = new ArrayList();
        amenities2.add("foodbar");
        MotelRoom r2 = rm.checkIn(rc2,"Suite",amenities2);
        
        System.out.println(rc2);
        System.out.println(rm);
        r2.party();
        System.out.print("(Name Population) --> ");
        System.out.println(rc2);
        Double cost = rm.checkOut(r2,3);
        System.out.println("cost:" + cost);
        System.out.println(rm);
        ArrayList amenities3 = new ArrayList();
        amenities3.add("foodbar");
        amenities3.add("spa");
        amenities3.add("refillbar");
        ArrayList amenities4 = new ArrayList();
        amenities4.add("spa");
        amenities4.add("shower");
        ArrayList amenities5 = new ArrayList();
        amenities5.add("refillbar");
        ArrayList amenities6 = new ArrayList();
        amenities6.add("spa");
        RoachColony rc3 = new RoachColony("third colony",300,0.3);
        
        MotelRoom r3 = rm.checkIn(rc3,"Suite",amenities3);
        r1.party();
        System.out.print("(Name Population) --> ");
        System.out.println(rc1);
        RoachColony rc4 = new RoachColony("fourth colony",400,0.4);
        
        MotelRoom r4 = rm.checkIn(rc4,"Regular",amenities4);
        RoachColony rc5 = new RoachColony("fifth colony",500,0.5);
        MotelRoom r5 = rm.checkIn(rc5,"Deluxe",amenities5);
        RoachColony rc6 = new RoachColony("sixth colony",600,0.6);
        MotelRoom r6 = rm.checkIn(rc6,"Deluxe",amenities6);
        RoachColony rc7 = new RoachColony("Seventh colony",700,0.7);
        MotelRoom r7 = rm.checkIn(rc7,"Suite",amenities);
        RoachColony rc8 = new RoachColony("eigth colony",800,0.8);
        MotelRoom r8 = rm.checkIn(rc8,"Suite",amenities2);
        RoachColony rc9 = new RoachColony("ninth colony",900,0.9);
        cost = rm.checkOut(r3,3);
        System.out.println("cost:" + cost);
        MotelRoom r9 = rm.checkIn(rc9,"Regular",amenities2);
        RoachColony rc11 = new RoachColony("Tenth colony",1100,1.1);
        MotelRoom r11 = rm.checkIn(rc11,"Suite",amenities);
        RoachColony rc12 = new RoachColony("Eleventh colony",1200,1.2);
        MotelRoom r12 = rm.checkIn(rc12,"Suite",amenities);
        RoachColony rc13 = new RoachColony("twelve colony",1300,1.3);
        MotelRoom r13 = rm.checkIn(rc13,"Suite",amenities);
        
        cost = rm.checkOut(r1, 7);
        System.out.println("cost:" + cost);
        
        MotelRoom r14 = rm.checkIn(rc8,"Suite",amenities2);
        
        cost = rm.checkOut(r6, 14);
        System.out.println("cost:" + cost);
        
        cost = rm.checkOut(r5, 30);
        System.out.println("cost:" + cost);
        
        cost = rm.checkOut(r9, 5);
        System.out.println("cost:" + cost);
        
        cost = rm.checkOut(r7, 1000);
        if(cost != 0)
            System.out.println("cost:" + cost);

    }
    
}
