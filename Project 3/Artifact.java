
public class Artifact
{
	String name, description;
	
	Artifact()
	{
		
	}
	
	Artifact(String aName) //creates artifact with name
	{
		this.name = aName;
	}
	
	Artifact (String aName, String aDescription) //creates artifact with name and description
	{
		this (aName);
		this.description = aDescription;
	}

	String examine() //returns the description of the artifact
	{
		return description;
	}
	String touch() //touching a non special artifact
	{
		
		return "Nothing happens";
	}
	String touch(Artifact anArtifact) //touching a non special artifact with an assigned artifact
	{
		
		return "Nothing happens";
	}

}
