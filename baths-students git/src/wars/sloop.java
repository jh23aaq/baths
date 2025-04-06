/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author Johnny Hoang, Lynden Fenn
 */
public class sloop extends ship {
    
    private boolean hasDoctor;  // Whether the ship has a doctor on board
    
    /**
     * Constructs a new Sloop instance
     * 
     * @param name         Name of the ship
     * @param captain      Name of the captain
     * @param fee          Commission fee to hire the ship
     * @param hasDoctor    Whether the ship includes a doctor
     */
    public sloop(String name, String captain, int chosenFee, boolean hasDoctor)
    {
        super(name, captain, 5, chosenFee);
        this.hasDoctor = hasDoctor; 
    }
    
    /**
     * Checks whether the ship has a doctor on board
     * 
     * @return true if the ship has a doctor, false otherwise
     */
    public boolean isHasDoctor()
    {
        return hasDoctor;
    }
    
    
    @Override
    public boolean canFight(EncounterType type)
    {
        switch(type)
        {
            case BLOCKADE: return false;
            case BATTLE: return true;
            case SKIRMISH: return true;
            default: return false;
        }
    }
    
    
    
}
