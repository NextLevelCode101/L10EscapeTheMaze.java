import edu.fcps.karel2.Display;
import javax.swing.JOptionPane;
import edu.fcps.karel2.WorldFrame;
  
public class L10EscapeTheMaze {
   
   // declare and initialize array of map choices for the dialogue drop-down options
   public static final String[] choices = {"bigmaze", "biggestmaze", "maze1", "maze2", "maze3", "maze4", "maze5"};   

   public static void main(String[] args) 
   {
      // open dialogue box and request user input of map choices
      String mapChoice = (String)JOptionPane.showInputDialog(null,"Choose an map.", "Map Choices", JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);
      // open selected map and set size and speed
      Display.openWorld("maps/"+ mapChoice +".map");
      Display.setSize(10, 10);
      Display.setSpeed(10);
      //make frame pop up in top left corner of computer screen
      WorldFrame.getCurrent().setLocation(0, 0);
      Athlete a = new Athlete(1,1, Display.EAST, 0);
      if(mapChoice.equals("bigmaze"))
      {
      Display.setSize(23, 23);
         
      }
      else if(mapChoice.equals("biggestmaze"))
      {
      Display.setSize(43, 43);
      }
      else if(mapChoice.equals("maze1") || mapChoice.equals("maze2") || mapChoice.equals("maze3") || mapChoice.equals("maze4") || mapChoice.equals("maze5"))
      {
      Display.setSize(8,8);  
      }
   
      while(!a.nextToABeeper())
      {
         if(!a.rightIsClear() && a.frontIsClear())
         {
            a.move();
         }
         else if(a.rightIsClear())
         {
            a.turnRight();
            a.move();
         }
         
         else
         {
            a.turnLeft();
         }
          
      }
   
   }

   

}