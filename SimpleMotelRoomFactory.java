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
public class SimpleMotelRoomFactory {
    
    public MotelRoom createMotelRoom(String type)
    {
        MotelRoom motelRoom = null;
        
        switch(type)
        {
            case "Suite":  motelRoom = new SuiteMotelRoom();
                break;
            case "Deluxe": motelRoom = new DeluxeMotelRoom();
                break;
            case "Regular":motelRoom = new RegularMotelRoom();
                break;
            default: motelRoom = new RegularMotelRoom();
        }
        
        return motelRoom;
    }
    
}
