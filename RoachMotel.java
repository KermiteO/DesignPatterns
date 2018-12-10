/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.patterns;
import java.util.*;

public class RoachMotel 
{
    private RoachMotel() {};
    
    private static RoachMotel instance;
    
    private ArrayList<Integer> roomNumbers = new ArrayList<Integer>();
    private ArrayList<MotelRoom> roomsTaken = new ArrayList<MotelRoom>();
    private ArrayList<RoachColony> priorityColony = new ArrayList<RoachColony>();
    private ArrayList<String> priorityRoomType = new ArrayList<String>();
    private ArrayList<ArrayList<String>> priorityAmenities = new ArrayList<ArrayList<String>>();
    private ArrayList<Integer> roomNumbersTaken = new ArrayList<Integer>();
    private static boolean justCreated;
    private Waitlist waitlist = new Waitlist();
    private ArrayList<RoachColony> w = new ArrayList<RoachColony>();
    
    public static RoachMotel getInstance()
    {
        synchronized(RoachMotel.class)
        {
            if(instance == null)
            {
                instance = new RoachMotel();
                justCreated = true;
            }
            else
                justCreated = false;
        }
        
        return instance;
    }
    
    public void createRooms()
    {
        if(justCreated)
        {
            for(int count = 101; count <= 105; count++)
            {
                roomNumbers.add(count);
            }
        }          
    }
    
     public MotelRoom checkIn(RoachColony colony,
                              String      roomType,
                              ArrayList   ameneties)
     {
         MotelRoom room = null;
         SimpleMotelRoomFactory factory = new SimpleMotelRoomFactory();
         RoachColony copyColony = null;
         String copyRoomType = null;
         ArrayList copyAmeneties = null;
         boolean sendToWaitlist = false;
               
        System.out.println("\nThe " + colony.getName() + " is checking in...");

         System.out.print("available Rooms: [");
         
         for(int i = 0; i < roomNumbers.size(); i++)
         {
             System.out.print(roomNumbers.get(i));
             
             if(i < roomNumbers.size() - 1)
                System.out.print(", ");
         }
         
        System.out.println("]");
     
         if(!roomNumbers.isEmpty())
         { 
            room = factory.createMotelRoom(roomType);
            room.setAmenities(ameneties);
            room.setColony(colony);
            room.setRoomType(roomType);
             
            roomNumbersTaken.add(roomNumbers.remove(0));

            roomsTaken.add(room);
            

                    
            System.out.print("in set amenities: [");
            
            for(int i = 0; i < ameneties.size(); i++)
            {
                System.out.print(ameneties.get(i));
                
                if(i < ameneties.size() - 1)
                    System.out.print(", ");
            }
            
            System.out.println("]");
            
            System.out.println(print("",roomsTaken.size() - 1));               
         }
         else
         {
             if(w.contains(colony))
                System.out.println("The " + colony + " colony is already on the waitlist!!");
            else
             {                
                System.out.println("\nThere are no more vacancies left!!!");
                System.out.println("The " + colony.getName() + " got sent to the waitlist...");
                sendToWaitlist(colony,roomType,ameneties);
             }
         }
                
         return room;
     }
     
     public void sendToWaitlist(RoachColony colony, String roomType, ArrayList<String> ameneties)
     {
        RoachColonyObserver r = new RoachColonyObserver(waitlist);
        w.add(colony);

        System.out.print("Observers: [");

        for(int i = 0; i < w.size(); i++)
        {
            System.out.print(w.get(i));

            if(i < w.size() - 1)
                System.out.print(", ");
        }

        System.out.println("]");
     }
     
     public double checkOut(MotelRoom r, int days)
     {
        double totalCost = 0;
        if(roomsTaken.contains(r))
        {
            System.out.println("\nThe " + r.getColony().getName() + " is checking out...");

        
            System.out.print("available Rooms: [");

            for(int i = 0; i < roomNumbers.size(); i++)
            {
                System.out.print(roomNumbers.get(i));

                if(i < roomNumbers.size() - 1)
                    System.out.print(", ");
            }

            System.out.println("]");

            if(roomNumbers.isEmpty())
            {  
                if(!w.isEmpty())
                {

                    //the observers get notified in the checkOut method when a room
                    //becomes available. After a colony checks out, THEN do this -->

                    for(int i = 0; i < w.size(); i++)
                    {
                        waitlist.newRoomAvailable(w.get(i));                          
                    }

                    waitlist.removeObservers(waitlist.getObservers().get(0));               


                    w.clear();
                }

            }

            int index = roomsTaken.indexOf(r);

            System.out.println("room number is: " + roomNumbersTaken.get(index));
            System.out.println("The number of days spent is: " + days);

            roomsTaken.remove(index);
            roomNumbers.add(roomNumbersTaken.get(index));
            roomNumbersTaken.remove(index);

            totalCost = r.calcBaseRate() * days;

            
        }
        else
        {
            System.out.println("\n*** ERROR - THIS COLONY NEVER CHECKED IN! ***\n");
        }
        
        return totalCost;
        
     }
    
    public String print(String output, int i)
    {
        ArrayList<String> copyAmn = new ArrayList<String>();

        copyAmn         = roomsTaken.get(i).getAmeneties();
        double bill     = roomsTaken.get(i).calcBaseRate();

        output += roomsTaken.get(i).getType() + ", ";


        for(int j = 0; j < copyAmn.size(); j++)
        {
            AmenityDecorator temp = roomsTaken.get(i).createAmenity(copyAmn.get(j));

            output += temp.getDescription();

            if(j < copyAmn.size() - 1)
                output += ", ";
        }

        output += " " + bill;
       
        return output;
    }
    @Override
    public String toString()
    {
        System.out.println("\nCurrent Motel Status...");

        String output = "";
        
        output = "motel: {";
        
        if(roomNumbers.size() == 5)
            output += "} ";
        else
        {
            for(int i = 0; i < roomsTaken.size(); i++)
            {
                String roachCol = roomsTaken.get(i).getColony().toString();

                output = print(output, i);
                
                output += "=" + roachCol;
          
                if(i < roomsTaken.size() - 1)
                    output += ", ";
            }
            
            output += "} ";
        }
        
        output += ("available : [");
         
         for(int i = 0; i < roomNumbers.size(); i++)
         {
             output += roomNumbers.get(i);
             
             if(i < roomNumbers.size() - 1)
                 output += ", ";
         }
         
        output += "]";
                  
        return output;
    }   
}
