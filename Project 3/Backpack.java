import java.util.ArrayList;

public class Backpack {

	private  ArrayList <Artifact> contents = new ArrayList<Artifact>();//creates the inventory.
	
	
	public void setArtifact(Artifact anyArtifact)//allows an item to be put into the inventory.
	
	{
		contents.add(anyArtifact);
	}
	
	public void setArtifact(Map aMap, String aName) //allows an item to be put into the inventory based on the name of the file.
	
	{
		if (aName.equals("paper"))
		{
			contents.add(aMap.paper);
		}
		else
		if (aName.equals("lamp"))
		{
			contents.add(aMap.lamp);			
		}
		else
		if (aName.equals("lunch"))
		{
			contents.add(aMap.lunch);
		}
		else
		if (aName.equals("chair"))
		{
			contents.add(aMap.chair);					
		}
		else
		if (aName.equals("sign"))
		{
			contents.add(aMap.sign);
		}

		else
		if (aName.equals("fountain"))
		{
			contents.add(aMap.fountain);
		}
		else
		if (aName.equals("picture"))
		{
			contents.add(aMap.picture);					
		}
		else
		if (aName.equals("exam"))
		{
			contents.add(aMap.exam);			
		}
		else
		if (aName.equals("desk"))
		{
			contents.add(aMap.desk);
		}
		else
		if (aName.equals("radio"))
		{
			contents.add(aMap.radio);					
		}
		
	}
		public Artifact getArtifact( int index)//allows an item to be put into the inventory based on the index.
		{
			
			return contents.get(index);
		}
		
		public void clear() //emptys the inventory.
		{
			contents.clear();
		}
		
			
		
		
	
	
	public String list() //lists all artifacts in the inventory.
	{
		int i = 0;
		String contentInfo = "";
	
		if (!contents.isEmpty())
		{
			while (i<contents.size())
			{
				Artifact temp = new Artifact();
				temp = contents.get(i);
				
				contentInfo = contentInfo + (i+1)+ ". " + temp.name + " "; 
						i++;
						
			}
			return  contentInfo;
		}
		else
			return "Your pack is empty.";
	}
	public Artifact  removeArtifact(int index) //removes the artifact and returns it.
	{

		return (Artifact) contents.remove(index);
		
		
		
	}
	
	public int count()//returns how many items are in the inventory.
	{
		return contents.size();
	}
}
