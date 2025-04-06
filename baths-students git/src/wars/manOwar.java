/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author Johnny Hoang, Lynden Fenn
 */
public class manOwar extends ship {
    
    private int numDeckOfCannons;
    private int numMarines;
          
    /**
     * Constructs a new Man O' War instance
     * 
     * @param name     Name of the ship
     * @param captain  Name of the captain
     * @param decks    Number of decks (should be 2 or 3)
     * @param marines  Number of marines aboard
     */
    public manOwar(String name, String captain, int battleSkill, int decks, int marines) 
    {       
    super(name, captain, battleSkill, (decks == 2) ? 300:500);
    this.numDeckOfCannons = decks;
    this.numMarines = marines;      
    }
    
    /**
     * Returns the number of decks on the Man O' War
     * 
     * @return the number of decks
     */
    public int getNumDeckOfCannons()
    {
        return numDeckOfCannons;
    }
    
    /**
     * Returns the number of marines on the ship
     * 
     * @return the number of marines
     */
    public int getNumMarines()
    {
        return numMarines;
    }
    
    @Override
    public boolean canFight(EncounterType type)
    {
        switch (type)
        {
            case BLOCKADE: return true;
            case BATTLE: return true;
            case SKIRMISH: return false;
            default: return false;
        }
    }
    
    
    
}
