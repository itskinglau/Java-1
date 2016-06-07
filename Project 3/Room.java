import java.util.ArrayList;


public class Room
{
	String name, description, exits[];
	
	public ArrayList<Artifact> contentList = new ArrayList<> ();
	
	boolean isValidExit(String anExit) //checks to see if the exit is valid
	{
		boolean result = false;
		
		int index = 0;
		while (result==false && index < exits.length)
		{
			if (exits[index].equals(anExit))
				result = true;

			index++;
		}
	
		return result;
	}
	String look() //returns the list of artifacts in the room.
	{
		int i = 0;
		String content = "";
		if (!contentList.isEmpty())
		{
			while (i<contentList.size())
			{
				Artifact temp = new Artifact();
				temp = contentList.get(i);
				
				content = content + (i+1)+ ". " + temp.name + " "; 
						i++;
						
			}
		return "You see " + content;
		}
		else
			return "There is nothing here.";
		
	}
	
	String examine(int aInt) //checks to see if the content list is empty and returns the description if it is not
	{
		
		
		if (!contentList.isEmpty())
		{
				Artifact temp = new Artifact();
				temp = contentList.get(aInt);
			
						return temp.description;
						
		}
		
			
		else
			return "There is nothing here.";
	
		}
	

	String getExits() // returns the list of all exits in full word form.
	{
		String anExit[] = {" ", " ", " "};
		String fullExits = "";
	
		int i = 0;
		while ( i < exits.length)
		{
			
			if (exits[i].equals("d"))
			{
			
				anExit[i] = "Down";
				fullExits =  fullExits + anExit[i];
			
			}
			else if (exits[i].equals("n"))
			{
			
				anExit[i] = "North";
				fullExits =  fullExits + anExit[i];
			
			}
			else if (exits[i].equals("u"))
			{
			
				anExit[i] = "up";
				fullExits =  fullExits + anExit[i];
			
			}
			else if (exits[i].equals("s"))
			{
				anExit[i] = "South";
				fullExits =  fullExits + anExit[i];
			
			}
			else if (exits[i].equals("e"))
			{
				anExit[i] = "East";
				fullExits =  fullExits + anExit[i];
		
			}
			else if (exits[i].equals("w"))
			{
				anExit[i] = "West";
				fullExits =  fullExits + anExit[i];
			
			}
			else if (exits[i].equals("ne"))
			{
				anExit[i] = "Northeast";
				fullExits =  fullExits + anExit[i];
			
			}
			else if (exits[i].equals("??"))
			{
				anExit[i] = "??";
				fullExits =  fullExits + anExit[i];
			
			}
			i++;
			if (i == exits.length)
			{
				
					fullExits = fullExits + ".";
			}
			else
				fullExits =  fullExits + " and ";
			
		}
		
		
		return fullExits;
	}
}

