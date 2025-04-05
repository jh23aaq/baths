package wars; 


/**
 * Details of your team
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teamwork
{
    private String[] details = new String[12];
    
    public Teamwork()
    {   // in each line replace the contents of the String 
        // with the details of your team member
        // Please list the member details alphabetically by surname 
        // i.e. the surname of member1 should come alphabetically 
        // before the surname of member 2...etc
        details[0] = "28";
        
        details[1] = "Ali";
        details[2] = "Hasnat";
        details[3] = "21068085";

        details[4] = "Fenn";
        details[5] = "Lynden";
        details[6] = "20023139";

        details[7] = "Hoang";
        details[8] = "Johnny";
        details[9] = "22056178";


        details[10] = "Miah";
        details[11] = "Armman";
        details[12] = "22056186";

	
	   // only if applicable
        details[13] = "surname of member5";
        details[14] = "first name of member5";
        details[15] = "SRN of member5";


    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
