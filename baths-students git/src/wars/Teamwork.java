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
        
        details[1] = "hoang";
        details[2] = "johnny";
        details[3] = "SRN of member1";

        details[4] = "miah";
        details[5] = "armman";
        details[6] = "SRN of member2";

        details[7] = "fenn";
        details[8] = "lynden";
        details[9] = "SRN of member3";


        details[10] = "ali";
        details[11] = "hasnat";
        details[12] = "SRN of member4";

	
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
        
