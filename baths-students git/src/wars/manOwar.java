/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author Johnny Hoang
 */
public class manOwar extends ship {
    
    private int numDeckOfCannons;
    private int numMarines;
          
    
    public manOwar(String name, String captain, int battleSkill, int decks, int marines) 
    {       
    super(name, captain, battleSkill, (decks == 2) ? 300:500);
    this.numDeckOfCannons = decks;
    this.numMarines = marines;      
    }
    
    
    public int getNumDeckofCannons()
    {
        return numDeckOfCannons;
    }
    
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
