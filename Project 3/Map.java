


public class Map
{
	Room[][][] rooms = new Room[4][4][2];
	Artifact lamp;
	Artifact lunch;
	Artifact chair;
	Artifact sign;
	Artifact exam;
	Artifact fountain;
	Artifact picture;
	SpecialArtifact paper;
	Artifact desk;
	SpecialArtifact radio;
	SpecialArtifact tv;
	
	Map()
	{
		// Create rooms and artifacts
		
		//room 2,0,0 
		Room lgRoom = new Room();
		lgRoom.name = "Lecture Hall";
		lgRoom.description = "A picture of the University President adorns the north wall.";
		lgRoom.exits = new String[] {"e"};
		
		
		picture = new Artifact("picture", "The picture bears an inscription that reads: President of Cal Poly Pomona.");
		lgRoom.contentList.add(picture);
		
				
		//room 2,1,0 
		Room draftyRoom = new Room();
		draftyRoom.name = "Drafty Room";
		draftyRoom.exits = new String[] {"w", "n", "e"};
		draftyRoom.description = "The smell of hamburgers wafts though the air.";
		
		lunch = new Artifact("lunch", "The lunch appears to be a hamburger, French fries, and some kind of soda.");
		draftyRoom.contentList.add(lunch);
		
		
		
		//room 0,1,0
		Room starBucks = new Room();
		starBucks.name = "Starbucks";
		starBucks.exits = new String[] {"w", "s"};
		starBucks.description = "You enter Starbucks, no one is in here.";
		
		chair = new Artifact("chair","A leather chair.");
		starBucks.contentList.add(chair);

		
		//room 1,0,0
		Room lobby = new Room();
		lobby.name = "Lobby";
		lobby.exits = new String [] {"n","s", "e"};
		lobby.description = "Sunlight is streaming though the glass door.";
		sign = new Artifact("sign", "this way to the rose garden.");
		lobby.contentList.add(sign);
				
		
		//room 1,1,0
		Room classRoom = new Room();
		classRoom.name = "Class Room";
		classRoom.exits = new String[] {"n", "s", "w"};
		classRoom.description = " An old exam lies on the table in the center of the room.";
		
		exam = new Artifact("exam", "CIS 234 Final Exam, the rest appears unreadable to to a lack of printer toner.");
		classRoom.contentList.add(exam);
		
				
		//room 0,0,0 
		Room garden = new Room();
		garden.name ="Garden Area";
		garden.exits = new String[] {"s", "e", "u"};
		garden.description = "You are standing at the entrance to a beautiful rose garden.";
		
		fountain = new Artifact("fountain", "the small place on the fountain reads: Enjoy the garden!");
		garden.contentList.add(fountain);
		
		
		//room 3,0,0 
		Room clear = new Room();
		clear.name = "Clearing";
		clear.exits  = new String[] {"n"};
		clear.description = "A dark cavernous opening in the nearby cliffs lies just north of you.";
		
		paper = new SpecialArtifact("paper");
		paper.description = "The paper is blank.";
		paper.specialDescription =  "The paper reads: Welcome to the Great Cal Poly Underground!";
		clear.contentList.add(paper);
		
		//room 2,2,0 
		Room dungeon = new Room();
		dungeon.name = "Dungeon"; 
		dungeon.exits = new String[] {"w","ne", "e"};
		dungeon.description = "You have fallen into a dungeon!";
		
		lamp = new Artifact();
		lamp.name = "lamp";
		lamp.description = "A dusty lamp of great antiquity.";

		
		//room 2,3,0 
		Room library = new Room();
		library.name = "Library"; 
		library.exits= new String[] {"w", "n", "s"};
		library.description ="The library looks like it has not been entered in some time.";
		
		desk = new Artifact("desk");
		desk.description = "A large oak desk that is covered in dust.";
		library.contentList.add(desk);
		
		
		//room 1,3,0
		Room lounge = new Room();
		lounge.name = "Student Lounge";
		lounge.exits = new String[] {"s"};
		lounge.description = "You have entered the student lounge, there is no one here.";
	
		radio = new SpecialArtifact("radio");
		radio.description= "the radio is silent.";
		radio.specialDescription = " the radio is playing music.";
		lounge.contentList.add(radio);
		
		//room 3,3,0 
		Room cellar = new Room();
		cellar.name = "Cellar"; 
		cellar.exits = new String[] {"n"};
		cellar.description ="the cellar is very musky.";
		tv = new SpecialArtifact("tv");
		tv.description = "the tv is off.";
		tv.specialDescription = "The tv is on.";
		cellar.contentList.add(tv);
		
		//room 0,0,1
		Room quad = new Room();
		quad.name = "quad";
		quad.exits = new String [] {"s", "d"};
		quad.description = "The quad is overgrown and hard to navagate.";
		
		//room 1,0,1
		Room admin = new Room();
		admin.name = "Administration";
		admin.exits = new String [] {"s", "n"};
		admin.description = "The administration room is empty, they must all be at lunch";
	
		
		//room 2,0,1
		Room trophy = new Room();
		trophy.name = "Trophy Room";
		trophy.exits = new String []{"s", "e"};
		trophy.description = "The room is filled with prizes and antiquities";
		trophy.contentList.add(lamp);
		
		//room 2,1,1
		Room mystery = new Room();
		mystery.name= "Mystery";
		mystery.exits = new String [] {"??"};
		mystery.description ="You have teleported to a random room!";
		
		
		
		
		// Place rooms on map
		rooms[0][0][0] = garden;
		rooms[0][1][0] = starBucks;
		rooms[1][0][0] = lobby;
		rooms[1][1][0] = classRoom;
		rooms[1][3][0] = lounge;
		rooms[2][1][0] = draftyRoom;
		rooms[2][2][0] = dungeon;
		rooms[2][3][0] = library;
		rooms[2][0][0]= lgRoom;
		rooms[3][0][0] = clear;
		rooms[3][3][0] = cellar;
		rooms[0][0][1] = quad;
		rooms[1][0][1] = admin;
		rooms[2][0][1] = trophy;
		rooms[2][1][1] = mystery;
		
	}
	void clear()
	{
		rooms[0][0][0].contentList.clear();
		rooms[0][1][0].contentList.clear();
		rooms[1][0][0].contentList.clear();
		rooms[1][1][0].contentList.clear();
		rooms[1][3][0].contentList.clear();
		rooms[2][1][0].contentList.clear();
		rooms[2][2][0].contentList.clear();
		rooms[2][3][0].contentList.clear();
		rooms[2][0][0].contentList.clear();
		rooms[3][0][0].contentList.clear();
		rooms[3][3][0].contentList.clear();
		rooms[0][0][1].contentList.clear();
		rooms[1][0][1].contentList.clear();
		rooms[2][0][1].contentList.clear();
		rooms[2][1][1].contentList.clear();
		
	}
	
	void setArtifact(String aName, int row, int col, int floor)
	{	
		if (aName.equals("lamp"))
			rooms[row][col][floor].contentList.add(lamp);
		else
		if (aName.equals("chair"))
			rooms[row][col][floor].contentList.add(chair);
		else
		if (aName.equals("lunch"))
			rooms[row][col][floor].contentList.add(lunch);
		else
		if (aName.equals("sign"))
			rooms[row][col][floor].contentList.add(sign);
		else
		if (aName.equals("exam"))
			rooms[row][col][floor].contentList.add(exam);
		else
		if (aName.equals("fountain"))
			rooms[row][col][floor].contentList.add(fountain);
		else
		if (aName.equals("paper"))
			rooms[row][col][floor].contentList.add(paper);
		else
		if (aName.equals("desk"))
			rooms[row][col][floor].contentList.add(desk);
		else
		if (aName.equals("tv"))
			rooms[row][col][floor].contentList.add(tv);
		else
		if (aName.equals("radio"))
			rooms[row][col][floor].contentList.add(radio);
		else
		if (aName.equals("picture"))
			rooms[row][col][floor].contentList.add(picture);
		
	}

}
