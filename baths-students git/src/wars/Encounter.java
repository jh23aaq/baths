/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author Johnny Hoang, Lynden Fenn
 */

/**
* Constructs a new Encounter instance
 * @param number            Unique encounter ID
 * @param type          Type of encounter
 * @param location      Location of the encounter
 * @param requiredSkill Skill level required to succeed
 * @param prizeMoney    Monetary reward for winning
*/
public class Encounter implements Serializable {
    private int number;
    private EncounterType type;
    private String location;
    private int requiredSkill;
    private int prizeMoney;

    public Encounter(int number, EncounterType type, String location, int requiredSkill, int prizeMoney) {
        this.number = number;
        this.type = type;
        this.location = location;
        this.requiredSkill = requiredSkill;
        this.prizeMoney = prizeMoney;
    }

    /**
     * Gets the unique number of the encounter
     * 
     * @return the encounter number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Gets the type of the encounter
     * 
     * @return the encounter type
     */
    public EncounterType getType() {
        return type;
    }

    /**
     * Gets the location of the encounter
     * 
     * @return the location as a string
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the required skill level to succeed in this encounter
     * 
     * @return the required skill level
     */
    public int getRequiredSkill() {
        return requiredSkill;
    }

    /**
     * Gets the prize money awarded for winning the encounter
     * 
     * @return the prize money
     */
    public int getPrizeMoney() {
        return prizeMoney;
    }

    @Override
    public String toString() {
        return "Encounter No: " + number + ", Type: " + type + ", Location: " + location +
                ", Skill Required: " + requiredSkill + ", Prize: " + prizeMoney;
    }
}
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


