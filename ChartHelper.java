import java.util.*;
public class ChartHelper{

  public static char printMenu(){
    System.out.println("\n Menu Options\n");
    System.out.println(" Enter I to Insert Song into Chart");
    System.out.println(" Enter M to Move Song");
    System.out.println(" Enter D to Delete Song");
    System.out.println(" Enter S to Get Song Title");
    System.out.println(" Enter N to Get Position Number of Song");
    System.out.println(" Enter P to Print the  Top Ten Chart");
    System.out.println(" Enter Q to Quit");
    System.out.print("  \n Please enter your choice ");
    Scanner console = new Scanner (System.in);
    char ch=' ';
    if (console.hasNext())
      ch=Character.toUpperCase(console.next().charAt(0));
    return ch;
  }
  public static int getPosition(){
    Scanner console = new Scanner (System.in);
    int p=0;
    System.out.print(" Please enter the song position ");
    if (console.hasNextInt())
     p= console.nextInt();
    return p;
  }
  public static String getSong(){
    Scanner console = new Scanner (System.in);
    String s="";
    System.out.print(" Please enter the song name ");
    if (console.hasNextLine())
     s= console.nextLine().trim();
    return s;
  }
  
}