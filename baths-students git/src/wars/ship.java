/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author Johnny Hoang, Lynden Fenn
 */
public abstract class ship{
    
    private String name;            // Name of the ship
    private String captain;         // Name of the ship's captain
    private int battleSkill;        // Battle skill level of the ship
    private int commissionFee;      // Cost to commission the ship
    private ShipState state;        // Current state: "reserve", "active", "resting", "sunk"
    
    
    public ship(String name, String captain, int battleSkill, int commissionFee){
        this.name = name;
        this.captain = captain;
        this.battleSkill = battleSkill;
        this.commissionFee = commissionFee;
        this.state = ShipState.RESERVE; //RESERVER by default
    }
    
    /**
     * Gets the ship's name
     * 
     * @return ship name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gets the captain's name
     * 
     * @return captain name
     */
    public String getCaptain()
    {
        return captain;
    }
    
    /**
     * Gets the ship's battle skill
     * 
     * @return battle skill level
     */
    public int getBattleSkill()
    {
       return battleSkill;
    }
    
    /**
     * Gets the ship's commission fee
     * 
     * @return commission fee
     */
    public int getCommissionFee()
    {
        return commissionFee;
    }
    
    /**
     * Gets the current state of the ship
     * 
     * @return current ship state
     */
    public ShipState getShipState()
    {
        return state;
    }
    
    /**
     * Sets the ship's state
     * 
     * @param state new state to assign
     */
    public void setShipState(ShipState newState)
    {
        this.state = newState;
    }
    
    /**
     * Abstract method to determine if the ship can participate in a specific encounter type
     * Each subclass must implement this based on their specific capabilities
     * 
     * @param type the type of encounter
     * @return true if the ship can fight, false otherwise
     */
    public abstract boolean canFight(EncounterType type);
    
   
}
