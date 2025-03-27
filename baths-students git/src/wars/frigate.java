/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author Johnny Hoang
 */
public class frigate extends ship {
    
    private int cannons;
    private boolean hasPinnace;
    
    
    public frigate (String name, String captain, int battleSkill, int cannons, boolean hasPinnace) 
    {
    super(name, captain, battleSkill, cannons * 10);
    this.cannons = cannons;
    this.hasPinnace = hasPinnace;
    }
    
    public int getCannons()
    {
        return cannons;
    }
    
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
