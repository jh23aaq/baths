/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author Johnny Hoang, Lynden Fenn
 */
public class frigate extends ship {
    
    private int cannons;        // Number of cannons on the frigate
    private boolean hasPinnace; // Whether the frigate is equipped with a pinnace
    
    /**
     * Constructs a new Frigate instance
     * 
     * @param name       Name of the ship
     * @param captain    Name of the captain
     * @param cannons    Number of cannons
     * @param hasPinnace Whether it has a pinnace
     */
    public frigate (String name, String captain, int battleSkill, int cannons, boolean hasPinnace) 
    {
    super(name, captain, battleSkill, cannons * 10);
    this.cannons = cannons;
    this.hasPinnace = hasPinnace;
    }
    
    /**
     * Returns the number of cannons on the frigate
     * 
     * @return the number of cannons
     */
    public int getCannons()
    {
        return cannons;
    }
    
    /**
     * Indicates whether the frigate has a pinnace
     * 
     * @return true if it has a pinnace, false otherwise
     */
    public boolean isHasPinnace()
    {
        return hasPinnace;
    }
    
    @Override
    public boolean canFight(EncounterType type)
    {
        switch(type)
        {
            case BLOCKADE: return hasPinnace;
            case BATTLE: return true;
            case SKIRMISH: return true;
            default: return false;
        }
    }
    
    
    
}
