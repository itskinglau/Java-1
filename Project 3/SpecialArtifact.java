
public class SpecialArtifact extends Artifact
{

	String specialDescription;
	boolean powerState;
	
	SpecialArtifact(String aName)
	{
	super(aName);	
	}
	String examine() //returns the special artifact description
	{
		if (powerState == false)
			return this.description;
		else
			return this.specialDescription;
	}
	
	String touch() //changes state of the special artifact.
	{
		powerState = !powerState;
		if (powerState == false)
			return this.description;
		else
			return this.specialDescription;
		
	}

}

