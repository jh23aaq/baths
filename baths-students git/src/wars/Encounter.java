/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author Johnny Hoang
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

    public int getNumber() {
        return number;
    }

    public EncounterType getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public int getRequiredSkill() {
        return requiredSkill;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    @Override
    public String toString() {
        return "Encounter No: " + number + ", Type: " + type + ", Location: " + location +
                ", Skill Required: " + requiredSkill + ", Prize: £" + prizeMoney;
    }
}
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

