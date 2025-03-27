/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author Johnny Hoang
 */
public abstract class ship{
    
    private String name;
    private String captain;
    private int battleSkill;
    private int commissionFee;
    private ShipState state; // "reserve", "active", "resting", "sunk"
    
    
    public ship(String name, String captain, int battleSkill, int commissionFee){
        this.name = name;
        this.captain = captain;
        this.battleSkill = battleSkill;
        this.commissionFee = commissionFee;
        this.state = ShipState.RESERVE; //RESERVER by default
    }
    
    
    public String getName()
    {
        return name;
    }
    
    
    public String getCaptain()
    {
        return captain;
    }
    
    
    public int getBattleSkill()
    {
       return battleSkill;
    }
    
    
    public int getCommissionFee()
    {
        return commissionFee;
    }
    
    
    public ShipState getShipState()
    {
        return state;
    }
    
    
    public void setShipState(ShipState newState)
    {
        this.state = newState;
    }
    
    public abstract boolean canFight(EncounterType type);
    
   
}
