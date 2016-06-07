//Ryan Schan
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import javax.swing.JOptionPane;

public class TaskData 
{

    public static void ReadEmpolyee(ArrayList a)
    {
    
        BufferedReader in = null;
        
        try
        {
            in = new BufferedReader(new FileReader("employee.txt"));
            String line = in.readLine();
            while(line != null)
            {
                a.add(line); //assigns employee to an arrayList
                line = in.readLine();
            }
            
        }
        catch(IOException ioe)
        {
         String message = "Error with employee File:" + ioe.toString();
            String title = "Failed";
            JOptionPane.showMessageDialog(null,message ,title, JOptionPane.ERROR_MESSAGE);
        }
    //    return a;
        
    }
    public static void ReadProject(ArrayList a)
    {
 
        BufferedReader in = null;
        
        try
        {
            in = new BufferedReader(new FileReader("project.txt"));
            String line = in.readLine();
            while(line != null)
            {
                a.add(line);//adds project to an arrayList
                line = in.readLine();
            }
        }
        catch(IOException ioe)
        {
          String message = "Error with Project File:" + ioe.toString();
            String title = "Failed";
            JOptionPane.showMessageDialog(null,message ,title, JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    public static void WriteProject(ArrayList a)
    {
        PrintWriter out = null;
        try {
            File projectFile = new File("project.txt");
            out = new PrintWriter(new BufferedWriter( new FileWriter(projectFile)));
            for (int i = 0; i<a.size(); i++)
            {
                out.println(a.get(i));//loops and writes all projects from an array list
                                      // to the txt document
                
            }

        } catch (Exception ex) 
        {
         String message = "Error with project File:" + ex.toString();
            String title = "Failed";
            JOptionPane.showMessageDialog(null,message ,title, JOptionPane.ERROR_MESSAGE); 
        } finally {
            out.close();
        }

    }
     public static void WriteEmployee(ArrayList a)
    {
        PrintWriter out = null;
        try {
            File projectFile = new File("employee.txt");
            out = new PrintWriter(new BufferedWriter( new FileWriter(projectFile)));
            for (int i = 0; i<a.size(); i++)
            {
                out.println(a.get(i));//loops and writes all employees from an array list
                                      // to the txt document
                
            }

        } catch (Exception ex) 
        {
        String message = "Error with employee File:" + ex.toString();
            String title = "Failed";
            JOptionPane.showMessageDialog(null,message ,title, JOptionPane.ERROR_MESSAGE);
        } finally {
            out.close();
        }
        
        
    }
     public static void appendEmployee(String s)
     {
         PrintWriter out = null;
        try {
            File projectFile = new File("employee.txt");
            out = new PrintWriter(new BufferedWriter( new FileWriter(projectFile, true)));
            out.println(s);//takes the passed string and appends it to the employee document.
            
           

        } catch (Exception ex) 
        {
        String message = "Error with employee File:" + ex.toString();
            String title = "Failed";
            JOptionPane.showMessageDialog(null,message ,title, JOptionPane.ERROR_MESSAGE);   
        } finally {
            out.close();
        }
        
        
     }
     public static void appendProject(String s)
     {
         
         PrintWriter out = null;
        try {
            File projectFile = new File("project.txt");
            out = new PrintWriter(new BufferedWriter( new FileWriter(projectFile, true)));
            out.println(s);//takes the passed string and appends it to the project document.
            
           

        } catch (Exception ex) 
        {
            String message = "Error with Project File:" + ex.toString();
            String title = "Failed";
            JOptionPane.showMessageDialog(null,message ,title, JOptionPane.ERROR_MESSAGE);
        } finally {
            out.close();
        }
     }
     public static void readWorkOn(LinkedHashMap a)
        {
          BufferedReader in = null;
        String columns[], projectName, employees, hours ;
        
        try
        {
            in = new BufferedReader(new FileReader("workon.txt"));
            String line = in.readLine();
            while(line != null)
            {
                columns = line.split("<>");
                projectName = columns[0];
                employees = columns[1];
                hours = columns[2];
                if (a.containsKey(projectName))
                {
                   ArrayList<String> projectInfo = new ArrayList<String>();//projectInfo contains first the employee name followed by hours.
                   projectInfo = (ArrayList) a.get(projectName); //if already exists assigns new employee/hours to pervious project
                   projectInfo.add(employees);
                   projectInfo.add(hours);
                   
                }
                else
                {
                    ArrayList<String> projectInfo = new ArrayList<String>();//projectInfo contains first the employee name followed by hours.
                    projectInfo.add(columns[1]);
                    projectInfo.add(columns[2]);
                    a.put(projectName, projectInfo);
                    
                }
                line = in.readLine();
            }
        }
        catch(IOException ioe)
        {
           String message = "Error with workon File:" + ioe.toString();
            String title = "Failed";
            JOptionPane.showMessageDialog(null,message ,title, JOptionPane.ERROR_MESSAGE);
        }   
        }
        public static void writeWorkOn(LinkedHashMap h)
        {
             PrintWriter out = null;
             String projectName = null;
             String employee = null;
             String hours = null;
           try {
            File projectFile = new File("workon.txt");
            out = new PrintWriter(new BufferedWriter( new FileWriter(projectFile)));
          Iterator itr =  h.entrySet().iterator();
     
            while (itr.hasNext())//loops though hashmap
            {
              HashMap.Entry pair = (HashMap.Entry)itr.next();
              projectName= (String) pair.getKey();
              
                ArrayList<String> projectInfo = new ArrayList<String>();//projectInfo contains first the employee name followed by hours.
                   projectInfo = (ArrayList) h.get(projectName);
                   
                   for(int i = 0; i< projectInfo.size() -1; i = i + 2)//loops though arrayList
                   {
                       employee = projectInfo.get(i);
                       hours = projectInfo.get(i+1);
                            
                   
                       out.print(projectName + "<>" + employee +"<>"+ hours +  "\n");
                    }
                   
            }

        } catch (Exception ex) 
        {
        String message = "Error with workon File:" + ex.toString();
            String title = "Failed";
            JOptionPane.showMessageDialog(null,message ,title, JOptionPane.ERROR_MESSAGE);
            
        } finally {
            out.close();
        }  
        
    }
}
 
