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
public class MotelRoomStore {
    SimpleMotelRoomFactory factory;
    
    public MotelRoomStore(SimpleMotelRoomFactory f)
    {
        factory = f;
    }
    
    public MotelRoom orderMotelRoom(String type)
    {
        MotelRoom motelRoom;
        
        motelRoom = factory.createMotelRoom(type);
        
        return motelRoom;
    }
    
}
