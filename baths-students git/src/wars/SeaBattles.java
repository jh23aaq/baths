package wars;

import java.util.*;
import java.io.*;
/**
 * This class implements the behaviour expected from the BATHS
 system as required for 5COM2007 Cwk1B BATHS - Feb 2025
 * 
 * @author A.A.Marczyk, Lynden Fenn
 * @version 16/02/25
 */

public class SeaBattles implements BATHS 
{
    // may have one HashMap and select on stat
    // TEST comment
    private String admiral;
    private double warChest = 1000;
    
    //more field
    private Map<String, ship> allShips = new HashMap<>();
    private Map<String, ship> reserveFleet = new HashMap<>();
    private Map<String, ship> squadron = new HashMap<>();
    private Map<String, ship> restingShips = new HashMap<>();
    private Map<String, ship> sunkShips = new HashMap<>();
    private Map<Integer, Encounter> encounters = new HashMap<>();


//**************** BATHS ************************** 
    /** Constructor requires the name of the admiral
     * @param adm the name of the admiral
     */  
    public SeaBattles(String adm)
    {
        
        
       setupShips();
       setupEncounters();
    }
    
    /** Constructor requires the name of the admiral and the
     * name of the file storing encounters
     * @param admir the name of the admiral
     * @param filename name of file storing encounters
     */  
    public SeaBattles(String admir, String filename)  //Task 3
    {  

       setupShips();    
       setupEncounters();
       // uncomment for testing Task 
       // readEncounters(filename);
    }
    
    
    /**Returns a String representation of the state of the game,including the name of the 
     * admiral, state of the warChest,whether defeated or not, and the ships currently in 
     * the squadron,(or, "No ships" if squadron is empty), ships in the reserve fleet
     * @return a String representation of the state of the game,including the name of the 
     * admiral, state of the warChest,whether defeated or not, and the ships currently in 
     * the squadron,(or, "No ships" if squadron is empty), ships in the reserve fleet
     **/
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Admiral: ").append(admiral).append("\n");
        sb.append("War Chest: £").append(warChest).append("\n");
        sb.append("Defeated: ").append(isDefeated() ? "Yes" : "No").append("\n\n");

        sb.append("Squadron:\n");
        if (squadron.isEmpty()) {
            sb.append("No ships\n");
        } else {
            for (ship shipp : squadron.values()) {
                sb.append("- ").append(shipp.getName()).append(" (State: ").append(shipp.getShipState()).append(")\n");
            }
        }

        sb.append("\nReserve Fleet:\n");
        if (reserveFleet.isEmpty()) {
            sb.append("No ships\n");
        } else {
            for (ship shipp : reserveFleet.values()) {
                sb.append("- ").append(shipp.getName()).append("\n");
            }
        }

        sb.append("\nSunk Ships:\n");
        if (sunkShips.isEmpty()) {
            sb.append("No ships sunk yet\n");
        } else {
            for (ship shipp : sunkShips.values()) {
                sb.append("- ").append(shipp.getName()).append("\n");
            }
        }

        return sb.toString();
    }
    
    
    /** returns true if War Chest <=0 and the admiral's squadron has no ships which 
     * can be retired. 
     * @returns true if War Chest <=0 and the admiral's fleet has no ships 
     * which can be retired. 
     */
    public boolean isDefeated()
    {
        if (warChest > 0) return false;
        for (ship shipp : squadron.values()) {
        if (shipp.getShipState() != ShipState.SUNK) return false;
        }
        return true;
    }
    
    /** returns the amount of money in the War Chest
     * @returns the amount of money in the War Chest
     */
    public double getWarChest()
    {
        return warChest;
    }
    
    
    /**Returns a String representation of all ships in the reserve fleet
     * @return a String representation of all ships in the reserve fleet
     **/
    public String getReserveFleet()
    {   //assumes reserves is a Hashmap
        if (reserveFleet.isEmpty()) return "No ships";
        StringBuilder sb = new StringBuilder();
        for (ship shipp : reserveFleet.values()) {
            sb.append(shipp.getName()).append(" (Captain: ").append(shipp.getCaptain()).append(", Fee: £")
              .append(shipp.getCommissionFee()).append(", Skill: ").append(shipp.getBattleSkill()).append(")\n");
        }
        return sb.toString();
    }
    
    /**Returns a String representation of the ships in the admiral's squadron
     * or the message "No ships commissioned"
     * @return a String representation of the ships in the admiral's fleet
     **/
    public String getSquadron()
    {
        if (squadron.isEmpty()) return "No ships commissioned";
        StringBuilder sb = new StringBuilder();
        for (ship shipp : squadron.values()) {
            sb.append(shipp.getName()).append(" (State: ").append(shipp.getShipState()).append(")\n");
        }
        return sb.toString();
    }
    
    /**Returns a String representation of the ships sunk (or "no ships sunk yet")
     * @return a String representation of the ships sunk
     **/
    public String getSunkShips()
    {
        if (sunkShips.isEmpty()) return "No ships sunk yet";
        StringBuilder sb = new StringBuilder();
        for (ship shipp : sunkShips.values()) {
            sb.append(shipp.getName()).append(" (Captain: ").append(shipp.getCaptain()).append(")\n");
        }
        return sb.toString();
    }
    
    /**Returns a String representation of the all ships in the game
     * including their status
     * @return a String representation of the ships in the game
     **/
    public String getAllShips()
    {
        StringBuilder sb = new StringBuilder();
        for (ship shipp : allShips.values()) {
            sb.append(shipp.getName()).append(" - ").append(shipp.getShipState()).append("\n");
        }
        return sb.toString();
    }
    
    
    /** Returns details of any ship with the given name
     * @return details of any ship with the given name
     **/
    public String getShipDetails(String nme)
    {
        ship shipp = allShips.get(nme);
        if (shipp == null) return "\nNo such ship";

        return nme + " (Captain: " + shipp.getCaptain() + ", Skill: " + shipp.getBattleSkill() +
               ", Fee: £" + shipp.getCommissionFee() + ", State: " + shipp.getShipState() + ")";
    }     
 
    // ***************** Fleet Ships ************************   
    /** Allows a ship to be commissioned to the admiral's squadron, if there 
     * is enough money in the War Chest for the commission fee.The ship's 
     * state is set to "active"
     * @param nme represents the name of the ship
     * @return "Ship commissioned" if ship is commissioned, "Not found" if 
     * ship not found, "Not available" if ship is not in the reserve fleet, "Not 
     * enough money" if not enough money in the warChest
     **/        
    public String commissionShip(String nme)
    {
       ship shipp = reserveFleet.get(nme);
       if (!allShips.containsKey(nme)) return "Not found";
       if (shipp == null) return "Not available";
       if (warChest < shipp.getCommissionFee()) return "Not enough money";

       warChest -= shipp.getCommissionFee();
       shipp.setShipState(ShipState.ACTIVE);
       squadron.put(nme, shipp);
       reserveFleet.remove(nme);
       return "Ship commissioned";
    }
        
    /** Returns true if the ship with the name is in the admiral's squadron, false otherwise.
     * @param nme is the name of the ship
     * @return returns true if the ship with the name is in the admiral's squadron, false otherwise.
     **/
    public boolean isInSquadron(String nme)
    {
        return squadron.containsKey(nme);
    }
    
    /** Decommissions a ship from the squadron to the reserve fleet (if they are in the squadron)
     * pre-condition: isInSquadron(nme)
     * @param nme is the name of the ship
     * @return true if ship decommissioned, else false
     **/
    public boolean decommissionShip(String nme)
    {
        ship shipp = squadron.get(nme);
        if (shipp == null || shipp.getShipState() == ShipState.SUNK) return false;
        warChest += shipp.getCommissionFee() / 2.0;
        shipp.setShipState(ShipState.RESERVE);
        reserveFleet.put(nme, shipp);
        squadron.remove(nme);
        return true;
    }
    
  
    /**Restores a ship to the squadron by setting their state to ACTIVE 
     * @param ref the name of the ship to be restored
     */
    public void restoreShip(String ref)
    {
    ship shipp = squadron.get(ref);
        if (shipp == null) 
        {
         System.out.println("No such ship in squadron.");
        } 
        else if (shipp.getShipState() != ShipState.RESTING) 
        {
         System.out.println("Cannot restore " + ref + ": Ship is not resting.");
        } 
        else 
        {
         shipp.setShipState(ShipState.ACTIVE);
         System.out.println(ref + " has been restored to active state.");
        }
    }
    
//**********************Encounters************************* 
    /** returns true if the number represents a encounter
     * @param num is the reference number of the encounter
     * @returns true if the reference number represents a encounter, else false
     **/
     public boolean isEncounter(int num)
     {
        return encounters.containsKey(num);
     }
     
     
/** Retrieves the encounter represented by the encounter 
      * number.Finds a ship from the fleet which can fight the 
      * encounter.The results of fighting an encounter will be 
      * one of the following: 
      * 0-Encounter won by...(ship reference and name)-add prize money to War 
      * Chest and set ship's state to RESTING,  
      * 1-Encounter lost as no ship available - deduct prize from the War Chest,
      * 2-Encounter lost on battle skill and (ship name) sunk" - deduct prize 
      * from War Chest and set ship state to SUNK.
      * If an encounter is lost and admiral is completely defeated because there 
      * are no ships to decommission,add "You have been defeated " to message, 
      * -1 No such encounter
      * Ensure that the state of the war chest is also included in the return message.
      * @param encNo is the number of the encounter
      * @return a String showing the result of fighting the encounter
      */ 
    public String fightEncounter(int encNo)
    {
        Encounter encounter = encounters.get(encNo);
        if (encounter == null) {
            return "-1 No such encounter";
        }

            // Look for a suitable ship
            for (ship shipp : squadron.values()) {
            if (shipp.getShipState() != ShipState.ACTIVE) continue;
            if (!shipp.canFight(encounter.getType())) continue;

            String shipName = shipp.getName();

            if (shipp.getBattleSkill() >= encounter.getRequiredSkill()) {
                warChest += encounter.getPrizeMoney();
                shipp.setShipState(ShipState.RESTING);
                return "0 Encounter won by " + shipName + ". Prize money: £" + encounter.getPrizeMoney() +
                       ". War chest now: £" + warChest;
            } 
            else 
            {
                warChest -= encounter.getPrizeMoney();
                shipp.setShipState(ShipState.SUNK);
                squadron.remove(shipName);
                sunkShips.put(shipName, shipp);
                String result = "2 Encounter lost on battle skill. Ship " + shipName + " is sunk. Prize lost: £" +
                        encounter.getPrizeMoney() + ". War chest now: £" + warChest;
                if (isDefeated()) result += "\nYou have been defeated.";
                return result;
            }
        }

        // No suitable ship found
        warChest -= encounter.getPrizeMoney();
        String result = "1 Encounter lost as no suitable ship available. Prize lost: £" +
                        encounter.getPrizeMoney() + ". War chest now: £" + warChest;
        if (isDefeated()) result += "\nYou have been defeated.";
        return result;
    }

    /** Provides a String representation of an encounter given by 
     * the encounter number
     * @param num the number of the encounter
     * @return returns a String representation of a encounter given by 
     * the encounter number
     **/
    public String getEncounter(int num)
    {
        Encounter encounter = encounters.get(num);
        if (encounter == null) return "\nNo such encounter";
        return encounter.toString();
    }
    
    /** Provides a String representation of all encounters 
     * @return returns a String representation of all encounters
     **/
    public String getAllEncounters()
    {
        if (encounters.isEmpty()) return "No encounters";
        StringBuilder sb = new StringBuilder();
        for (Encounter e : encounters.values()) {
            sb.append(e.toString()).append("\n");
        }
        return sb.toString();
    }
    

    //****************** private methods for Task 4 functionality*******************
    //*******************************************************************************
     private void setupShips()
     {
         addShip(new manOwar("Victory", "Alan Aikin", 3, 3, 30));
         addShip(new frigate("Sophie", "Ben Baggins", 8, 16, true));
         addShip(new manOwar("Endeavour", "Col Cannon", 4, 2, 20));
         addShip(new sloop("Arrow", "Dan Dare", 150, true));
         addShip(new manOwar("Belerophon", "Ed Evans", 8, 3, 50));
         addShip(new frigate("Surprise", "Fred Fox", 6, 10, false));
         addShip(new frigate("Jupiter", "Gil Gamage", 7, 20, false));
         addShip(new sloop("Paris", "Hal Henry", 200, true));
         addShip(new sloop("Beast", "Ian Idle", 400, false));
         addShip(new sloop("Athena", "John Jones", 100, true));
     }
     
    private void addShip(ship ships) 
    {
        allShips.put(ships.getName(), ships);
        reserveFleet.put(ships.getName(), ships);
    }

     
     
    private void setupEncounters()
    {
        addEncounter(1, EncounterType.BATTLE, "Trafalgar", 3, 300);
        addEncounter(2, EncounterType.SKIRMISH, "Belle Isle", 3, 120);
        addEncounter(3, EncounterType.BLOCKADE, "Brest", 3, 150);
        addEncounter(4, EncounterType.BATTLE, "St Malo", 9, 200);
        addEncounter(5, EncounterType.BLOCKADE, "Dieppe", 7, 90);
        addEncounter(6, EncounterType.SKIRMISH, "Jersey", 8, 45);
        addEncounter(7, EncounterType.BLOCKADE, "Nantes", 6, 130);
        addEncounter(8, EncounterType.BATTLE, "Finisterre", 4, 100);
        addEncounter(9, EncounterType.SKIRMISH, "Biscay", 5, 200);
        addEncounter(10, EncounterType.BATTLE, "Cadiz", 1, 250);
    }
    
    private void addEncounter(int number, EncounterType type, String location, int skill, int prize) 
    {
        encounters.put(number, new Encounter(number, type, location, skill, prize));
    }
        
    // Useful private methods to "get" objects from collections/maps

    //*******************************************************************************
    //*******************************************************************************
  
    /************************ Task 3 ************************************************/

    
    //******************************** Task 3.5 **********************************
    /** reads data about encounters from a text file and stores in collection of 
     * encounters.Data in the file is editable
     * @param filename name of the file to be read
     */
    public void readEncounters(String filename)
    { 
      
    }   

    // ***************   file write/read  *********************
    /** Writes whole game to the specified file
     * @param fname name of file storing requests
     */
    
     @Override
     public void saveGame(String fname) {
         try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname))) {
             oos.writeObject(this);
             System.out.println("Game successfully saved to " + fname);
         } catch (IOException e) {
             System.out.println("Error saving game: " + e.getMessage());
         }
     }
     
    
    /** reads all information about the game from the specified file 
     * and returns 
     * @param fname name of file storing the game
     * @return the game (as an SeaBattles object)
     * note: call it from GameUI, like SeaBattles loadedGame = myBattles.loadGame("mySaveFile.dat");
     */

     @Override
    public SeaBattles loadGame(String fname) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname))) {
            Object obj = ois.readObject();
            if (obj instanceof SeaBattles) {
                System.out.println("Game successfully loaded from " + fname);
                return (SeaBattles) obj;
            } else {
                System.out.println("Error: File does not contain a valid SeaBattles object.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading game: " + e.getMessage());
        }
        return null;
    }

    
 
}



