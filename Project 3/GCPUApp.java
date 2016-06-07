import java.io.*;
import java.util.Random;
import java.util.Scanner;

// The Great Cal Poly Underground (version 8.0)
// Includes saving, restoring, inventory, dropping, and taking. 

public class GCPUApp
{
	public static void main(String[] args)
	{
		// Declare and initialize variables
		Scanner scan = new Scanner(System.in);
		
		// Starting location
		int row = 3;
		int col = 0;
		int floor = 0;
		// Create an instance of a map
		Map map = new Map();
		Backpack pack = new Backpack(); //create an instance of a backpack
		// Begin user dialog
		System.out.println("Welcome to The Great Cal Poly Underground!");
		String input = "";
		boolean quit = false;
		System.out.println(map.rooms[row][col][floor].name);
		System.out.println(map.rooms[row][col][floor].description);
		System.out.println("There are exits to the " + map.rooms[row][col][floor].getExits());	
		
		mainLoop:
		
		while(quit == false)
		{
			
			if (map.rooms[row][col][floor].name.equals("Mystery")) //extra credit # 3 checks to see if it is the mystery room
			{
				boolean valid = false;
				while (valid == false)
				{
				Random rng = new Random();
				row = rng.nextInt(4);
				col = rng.nextInt(4);
				floor = rng.nextInt(1); //assigns new random coordinates to go to
				if (map.rooms[row][col][floor] != null) //checks to see if valid room
				{
					System.out.println("You are now in: " + map.rooms[row][col][floor].name);
					valid = true;
				}
				else
				{
					continue;
				}
				continue mainLoop;
				}
				
			}
			
			System.out.print("> ");
			input = scan.nextLine();
			
			
			
			
			if (input.equals("d"))
				if (map.rooms[row][col][floor].isValidExit("d")) //moves down to the next floor if valid
				{
					floor--;
					System.out.println(map.rooms[row][col][floor].name);
					System.out.println(map.rooms[row][col][floor].description);
					System.out.println("There are exits to the " + map.rooms[row][col][floor].getExits());
					continue mainLoop;
				}
				else
				{
					System.out.println("You can't go that way.");
										continue mainLoop;
				}
			if (input.equals("u"))
				if (map.rooms[row][col][floor].isValidExit("u")) //moves up to the next floor if valid
				{
					floor++;
					System.out.println(map.rooms[row][col][floor].name);
					System.out.println(map.rooms[row][col][floor].description);
					System.out.println("There are exits to the " + map.rooms[row][col][floor].getExits());
					continue mainLoop;
				}
				else
				{
					System.out.println("You can't go that way.");
					continue mainLoop;
				}
			
			if (input.equals("e"))
				if (map.rooms[row][col][floor].isValidExit("e")) //moves east if valid
				{
					col++;
					System.out.println(map.rooms[row][col][floor].name);
					System.out.println(map.rooms[row][col][floor].description);
					System.out.println("There are exits to the " + map.rooms[row][col][floor].getExits());
					continue mainLoop;
				}
				else
				{
					System.out.println("You can't go that way.");
										continue mainLoop;
				}
			else
			if (input.equals("w"))
				if (map.rooms[row][col][floor].isValidExit("w")) //moves west if valid
				{
					col--;
					System.out.println(map.rooms[row][col][floor].name);
					System.out.println(map.rooms[row][col][floor].description);
					System.out.println("There are exits to the " + map.rooms[row][col][floor].getExits());
					continue mainLoop;
				}
			
				else
				{
					System.out.println("You can't go that way.");
					continue mainLoop;
				}
			else
				if (input.equals("n"))
					if (map.rooms[row][col][floor].isValidExit("n")) //moves north if valid
					{
						row--;
						System.out.println(map.rooms[row][col][floor].name);
						System.out.println(map.rooms[row][col][floor].description);
						System.out.println("There are exits to the " + map.rooms[row][col][floor].getExits());
						continue mainLoop;
					}
					else
					{
						System.out.println("You can't go that way.");
						continue mainLoop;
					}
				else	
					if (input.equals("s"))
						if (map.rooms[row][col][floor].isValidExit("s")) //moves south if valid
						{
							row++;
							System.out.println(map.rooms[row][col][floor].name);
							System.out.println(map.rooms[row][col][floor].description);
							System.out.println("There are exits to the " + map.rooms[row][col][floor].getExits());
							continue mainLoop;
						}
						else
						{
							System.out.println("You can't go that way.");
							continue mainLoop;
						}
					else
						if (input.equals("sw")) 
							if (map.rooms[row][col][floor].isValidExit("sw")) //moves southwest if valid
							{
								col--;
								row++;
								System.out.println(map.rooms[row][col][floor].name);
								System.out.println(map.rooms[row][col][floor].description);
								System.out.println("There are exits to the " + map.rooms[row][col][floor].getExits());
								continue mainLoop;
								
							}
							else
							{
								System.out.println("You can't go that way.");
								continue mainLoop;
							}
						if (input.equals("ne")) 
							if (map.rooms[row][col][floor].isValidExit("ne")) //moves northeast if valid
							{
								col++;
								row--;
								System.out.println(map.rooms[row][col][floor].name);
								System.out.println(map.rooms[row][col][floor].description);
								System.out.println("There are exits to the " + map.rooms[row][col][floor].getExits());
								continue mainLoop;
							}
							else
							{
								System.out.println("You can't go that way.");
								continue mainLoop;
							}
						else
						if (input.equals("se"))
							if (map.rooms[row][col][floor].isValidExit("se")) //moves southeast if valid
								{
									col++;
									row++;
									System.out.println(map.rooms[row][col][floor].name);
									System.out.println(map.rooms[row][col][floor].description);
									System.out.println("There are exits to the " + map.rooms[row][col][floor].getExits());
									continue mainLoop;
								}
							else
							{
								System.out.println("You can't go that way.");
								continue mainLoop;
							}
						
									else
						if (input.equals("nw"))
							if (map.rooms[row][col][floor].isValidExit("nw")) //moves northwest if valid
							{
								col--;
								row--;
								System.out.println(map.rooms[row][col][floor].name);
								System.out.println(map.rooms[row][col][floor].description);
								System.out.println("There are exits to the " + map.rooms[row][col][floor].getExits());
								continue mainLoop;
							}
							else
							{
								System.out.println("You can't go that way.");
								continue mainLoop;
							}
					if (input.equals("look")) //prints the room exits and all artifacts in the room.
						{
						System.out.println(map.rooms[row][col][floor].name);
						System.out.println("There are exits to the " + map.rooms[row][col][floor].getExits());
						System.out.println(map.rooms[row][col][floor].look());
						continue mainLoop;
					
						}
					else
					if (input.equals("touch")) //true if user did not specify what to touch.
					{
						System.out.println("Touch what? " + map.rooms[row][col][floor].look());
						continue mainLoop;
					}
					if (input.equals("examine")) //true if user did not specify what to examine.
					{
				
						System.out.println("Examine what? " + map.rooms[row][col][floor].look());
						continue mainLoop;
			
					}
					if (input.equals("examine 1")) //examines the first artifact in the room
					{
						if (!map.rooms[row][col][floor].contentList.isEmpty())
						{
						Artifact temp = new Artifact();
						temp = map.rooms[row][col][floor].contentList.get(0);
						System.out.println(temp.examine());
				
						continue mainLoop;
						}
						else
						{
							System.out.println("There is nothing in here to examine.");
							continue mainLoop;
						}
					}
					else		
						if (input.equals("examine 2")) //examines the second artifact in the room
							if  (!map.rooms[row][col][floor].contentList.isEmpty() && 1 > map.rooms[row][col][floor].contentList.size())
							{
							Artifact temp = new Artifact();
							temp = map.rooms[row][col][floor].contentList.get(1);
							System.out.println(temp.examine());
					
							continue mainLoop;
							}
							else
							{
								System.out.println("There is nothing in here to examine.");
								continue mainLoop;
							}
						else
				
					if (input.equals("touch 1")) //touches the first artifact in the room.
						if (!map.rooms[row][col][floor].contentList.isEmpty())
						{
						Artifact temp = new Artifact();
						temp = map.rooms[row][col][floor].contentList.get(0);
						System.out.println(temp.touch());
				
						continue mainLoop;
						}
						else
						{
							System.out.println("There is nothing in here to touch.");
							continue mainLoop;
						}
					else	
						if (input.equals("touch 2")) //touches the second artifact in the room.
							if (!map.rooms[row][col][floor].contentList.isEmpty() && 1 > map.rooms[row][col][floor].contentList.size())
							{
							Artifact temp = new Artifact();
							temp = map.rooms[row][col][floor].contentList.get(2);
							System.out.println(temp.touch());
							continue mainLoop;
							}
							else
							{
								System.out.println("There is nothing in here to touch.");
								continue mainLoop;
							}
						else
							if (input.equals("drop")) //if no item is specified.
							{
								System.out.println("Drop what "+ pack.list());
								continue mainLoop;
							}
					
							else
								if(input.equals("drop 1")) //removes item from pack and puts in room
								{
									if (pack.count() > 0)
									{
										if (map.rooms[row][col][floor].contentList.size() < 2)
										{
									Artifact temp = new Artifact();
									temp = pack.removeArtifact(0);
									
									map.rooms[row][col][floor].contentList.add(temp); 
									System.out.println(temp.name + " has been dropped.");
								
									continue mainLoop;
										}
										else
										{
											System.out.println("This room is full."); //if room already contains 2 items.
											continue mainLoop;
										}
									}
									else
									{
									System.out.println("You have nothing to drop."); //if pack is empty
									continue  mainLoop;
									}
								}
								else
									if(input.equals("drop 2"))//removes item from pack and puts in room
									{
										if (pack.count() > 0)
										{
											
											if (map.rooms[row][col][floor].contentList.size() < 2)
											{
											Artifact temp = new Artifact();
											temp = pack.removeArtifact(1);
										
											map.rooms[row][col][floor].contentList.add(temp); 
											System.out.println(temp.name + " has been dropped.");
											continue mainLoop;
											}
												else
												{
												System.out.println("This room is full.");
												continue mainLoop;
												}
											}	
										else
										{
										System.out.println("You have nothing to drop.");
										continue  mainLoop;
										}
									}
									else
										if(input.equals("drop 3"))//removes item from pack and puts in room
										{
											if (pack.count() > 0)
											{
												if (map.rooms[row][col][floor].contentList.size() < 2)
												{
											Artifact temp = new Artifact();
											temp = pack.removeArtifact(2);
											
											
											map.rooms[row][col][floor].contentList.add(temp); 
											System.out.print(temp.name + " has been dropped.");
												continue mainLoop;
												}	
												else
												{
													System.out.println("This room is full.");
													continue mainLoop;
												}
											}
												else
												{
													System.out.println("You have nothing to drop.");
													continue  mainLoop;
												}
											
										}
					
						else
							if(input.equals("take")) //if no item is specified to take
							{
								System.out.println("take what? " + map.rooms[row][col][floor].look());
								continue mainLoop;
							}
							else
								
						if (input.equals("take 1")) //takes the first item from the room and puts it into pack
						{
							if (pack.count() < 3)
							{
							Artifact temp = new Artifact();
							if (!map.rooms[row][col][floor].contentList.isEmpty())
								{
								temp = map.rooms[row][col][floor].contentList.get(0);
								pack.setArtifact(temp);
								map.rooms[row][col][floor].contentList.remove(0);
								System.out.println("Your pack now contains " + pack.list());
								continue mainLoop;
								}
								else
								{
								System.out.println("there is nothing here to take.");// if room is empty
								continue mainLoop;
								}
							
							}
							else
							{
								System.out.println("Your pack is full."); //if pack is empty
								continue mainLoop;
							}
						}
							else
							if (input.equals("take 2")) //takes the first item from the room and puts it into pack
							{
								if (pack.count() < 3)
								{
								Artifact temp = new Artifact();
								if (!map.rooms[row][col][floor].contentList.isEmpty())
									{
									temp = map.rooms[row][col][floor].contentList.get(1);
									pack.setArtifact(temp);
									map.rooms[row][col][floor].contentList.remove(1);
									System.out.println("Your pack now contains " + pack.list());
									continue mainLoop;
									}
									else
									{
									System.out.println("there is nothing here to take.");// if room is empty
									continue mainLoop;
									}
								}
							
							else
							{
								System.out.println("Your pack is full."); //if pack is empty
								continue mainLoop;
							}
							
						}
						else
							if (input.equals("inventory")) //displays the list of items in the pack.
							{
								System.out.println(pack.list());
								continue mainLoop;
							}
						
							else
							if (input.equals("restore"))//restores from file
							{
								System.out.print("Enter file name to restore: ");
								input = scan.nextLine();
								
								File file = new File("c:/files/"+ input);
								try (	FileReader reader = new FileReader(file);
										BufferedReader buffer = new BufferedReader(reader);)
								{			
									
									map.clear();
									pack.clear();
									String line = buffer.readLine();
									while (line != null)
									{
										String[] data = new String[4];
										data[1] = null;
										data[2] = null;
										data[3] = null;
										data = line.split(",");
										String key = data[0];
										if (key.equals("StartLocation"))//restores starting location
										{
											row = Integer.parseInt(data[1]);
											col = Integer.parseInt(data[2]);
											floor = Integer.parseInt(data[3]);
										}
										else
										if (key.equals("Artifact")) //restores all artifacts
										{
											String name = data[1];
											int artifactRow = Integer.parseInt(data[2]);
											int artifactCol = Integer.parseInt(data[3]);
											int artifactFloor = Integer.parseInt(data[4]);
											map.setArtifact(name, artifactRow, artifactCol, artifactFloor);
										}
										if (key.equals("Inventory")) //restores the inventory.
										{
											for (int i = 1; i<data.length; i++)
											{
												String name = data[i];
												pack.setArtifact(map,name);
											}
											
							
									}
										line = buffer.readLine();
									}
									System.out.println("Your progress has been restored.");
									System.out.println("You are now in the "+map.rooms[row][col][floor].name); 
									continue mainLoop;
									
								
								}
								catch (IOException e)
								{
									System.out.println("The file name you have entered was not found.");
									continue mainLoop;
								}
							}
							else
							if (input.equals("save")) //saves the file
							{
								System.out.print("Enter file name to save: ");
								input = scan.nextLine();
								
								try
								{
									File file = new File("c:/files/" + input);
									boolean override = false;
									if (file.exists())
										{
											System.out.print("This file already exists do you want to override this file?(Y/Cancel): "); //prompts use to over ride
											input = scan.nextLine();
												if (input.equalsIgnoreCase("y"))
												{
												override = true;
												}
												else
												{
													System.out.println("File not saved.");
													continue mainLoop;
												}
										}
												
												if (!file.exists() | override == true)//checks to see if its ok to override or if the file does not exist.
												{
													FileWriter writer = new FileWriter(file);
													BufferedWriter buffer = new BufferedWriter(writer);
													PrintWriter pw = new PrintWriter(buffer);
											
													pw.println("StartLocation" + "," + row + "," + col + "," + floor); //saves starting location
													
													
												
												
													for (int in = 0; in < map.rooms[0][0][0].contentList.size(); in++) //saves all artifacts that are currently in a room.
													{
														
														pw.println("Artifact" + "," + map.rooms[0][0][0].contentList.get(in).name + ",0,0,0");
														
													}
													for (int in = 0; in < map.rooms[0][1][0].contentList.size(); in++)
													{
														
														pw.println("Artifact" + "," + map.rooms[0][1][0].contentList.get(in).name+ ",0,1,0");
														
													}
													for (int in = 0; in < map.rooms[1][1][0].contentList.size(); in++)
													{
														
														pw.println("Artifact" + "," + map.rooms[1][1][0].contentList.get(in).name+ ",1,1,0");
														
													}
													for (int in = 0; in < map.rooms[1][3][0].contentList.size(); in++)
													{
														
														pw.println("Artifact" + "," + map.rooms[1][3][0].contentList.get(in).name+ ",1,3,0");
														
													}
													for (int in = 0; in < map.rooms[2][1][0].contentList.size(); in++)
													{
														
														pw.println("Artifact" + "," + map.rooms[2][1][0].contentList.get(in).name+ ",2,1,0");
														
													}
													for (int in = 0; in < map.rooms[2][2][0].contentList.size(); in++)
													{
														
														pw.println("Artifact" + "," + map.rooms[2][2][0].contentList.get(in).name+ ",2,2,0");
														
													}
													for (int in = 0; in < map.rooms[2][3][0].contentList.size(); in++)
													{
														
														pw.println("Artifact" + "," + map.rooms[2][3][0].contentList.get(in).name+ ",2,3,0");
														
													}
													for (int in = 0; in < map.rooms[2][0][0].contentList.size(); in++)
													{
														
														pw.println("Artifact" + "," + map.rooms[2][0][0].contentList.get(in).name+ ",2,0,0");
														
													}
													for (int in = 0; in < map.rooms[3][0][0].contentList.size(); in++)
													{
														
														pw.println("Artifact" + "," + map.rooms[3][0][0].contentList.get(in).name+ ",3,0,0");
														
													}
													for (int in = 0; in < map.rooms[3][3][0].contentList.size(); in++)
													{
														
														pw.println("Artifact" + "," + map.rooms[3][3][0].contentList.get(in).name+ ",3,3,0");
														
													}
													for (int in = 0; in < map.rooms[0][0][1].contentList.size(); in++)
													{
														
														pw.println("Artifact" + "," + map.rooms[0][0][1].contentList.get(in).name+ ",0,0,1");
														
													}
													for (int in = 0; in < map.rooms[1][0][1].contentList.size(); in++)
													{
														
														pw.println("Artifact" + "," + map.rooms[1][0][1].contentList.get(in).name+ ",1,0,1");
														
													}
													for (int in = 0; in < map.rooms[2][0][1].contentList.size(); in++)
													{
														
														pw.println("Artifact" + "," + map.rooms[2][0][1].contentList.get(in).name+ ",2,0,1");
														
													}
													for (int in = 0; in < map.rooms[2][1][1].contentList.size(); in++)
													{
														
														pw.println("Artifact" + "," + map.rooms[2][1][1].contentList.get(in).name+ ",2,1,1");
														
													}
													
													
													if (pack.count() > 0) //saves the inventory.
													{
														pw.print("Inventory");
														int i = 0;
														while  (i<pack.count())
														{
														pw.print("," + pack.getArtifact(i).name);
														i++;
														}
													}
													
													buffer.close();
													pw.close();
													System.out.println("Your progress has been saved.");
													continue mainLoop;
												}
																			
										
									
								
								}
								catch (IOException e)
								{
									System.out.println(e.getMessage());
									continue mainLoop;
								}
							}
			if (input.equals("quit")) //checks to see if user wants to quit
			{
				System.out.print("Are you sure you wish to quit(Y/N): ");//final prompt to see if user wants to quit
				String response = scan.nextLine();
				if (response.equalsIgnoreCase("y"))
				{ 
					quit = true;
				continue mainLoop;
				}
				else
				 quit = false;			
			}
			else
			{
				System.out.println("I do not understand " + "\""+input+"\"."); //catches all non valid inputs.
			}
		}
			
				
			
		
		System.out.println("Thank you for visiting The Great Cal Poly Underground.");
		
		scan.close();
	}
}

