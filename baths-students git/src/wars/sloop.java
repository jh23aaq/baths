/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author Johnny Hoang
 */
public class sloop extends ship {
    
    private boolean hasDoctor;
    
    
    public sloop(String name, String captain, int chosenFee, boolean hasDoctor)
    {
        super(name, captain, 5, chosenFee);
        this.hasDoctor = hasDoctor; 
    }
    
    
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
