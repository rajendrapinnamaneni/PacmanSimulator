import java.util.*;
import java.lang.*;
import java.io.*;
class Packman
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner scanner = new Scanner(System.in);
		int xStartingPoint=0;
		int yStartingPoint=0;
		int yEndingingPoint=4;
		int xEndingingPoint=4;
		           
            int posX = 0;// starting point westMost
            int posY = 0;//Staring point southmost
            String posFacing = "E";
            Boolean flag = true;
            Boolean startPlace = false; //To check if already place command is executed
            while(scanner.hasNextLine())
            {
            
        		 String inputLine = scanner.nextLine().toUpperCase();
        		 inputLine=inputLine.toUpperCase();
            	System.out.println(inputLine);
                String[] ArrInput = inputLine.split("\\s+");
                if (ArrInput.length > 0)
                {
                    //Intial declaration of x and y axis positions and direction in which bot is facing.
                    if (ArrInput[0].equals("PLACE") )
                    {
                        startPlace = false; ;
                        if (ArrInput.length < 2)
                        {
                            System.out.println("Please mention the cordinates to place and direction to face");
                        }
                        else
                        {
                            String[] inputArr = ArrInput[1].split(",");
                            if (inputArr.length < 3)
                            {
                                System.out.println("Please mention the cordinates to place and direction to face");
                            }
                            else
                            {
                                posX = Integer.parseInt(inputArr[0]);
                                posY = Integer.parseInt(inputArr[1]);
                                switch (inputArr[2])
                                {
                                    case "WEST":
                                        posFacing = "W";
                                        startPlace = true;
                                        break;
                                    case "EAST":
                                        posFacing = "E";
                                        startPlace = true;
                                        break;
                                    case "SOUTH":
                                        posFacing = "S";
                                        startPlace = true;
                                        break;
                                    case "NORTH":
                                        posFacing = "N";
                                        startPlace = true;
                                        break;
                                    default:
                                        System.out.println("Please provide valid directions");
                                        break;
                                }

                            }
                        }
                    }
                    else
                    {
                        if (startPlace)
                        {
                            //condition to check the commands user has provided other than place.
                            switch (ArrInput[0])
                            {
                                case "LEFT":
                                    switch (posFacing)
                                    {
                                        case "W":
                                            posFacing = "S";
                                            break;
                                        case "E":
                                            posFacing = "N";
                                            break;
                                        case "N":
                                            posFacing = "W";
                                            break;
                                        case "S":
                                            posFacing = "E";
                                            break;
                                    }
                                    break;
                                case "RIGHT":
                                    switch (posFacing)
                                    {
                                        case "W":
                                            posFacing = "N";
                                            break;
                                        case "E":
                                            posFacing = "S";
                                            break;
                                        case "N":
                                            posFacing = "E";
                                            break;
                                        case "S":
                                            posFacing = "W";
                                            break;
                                    }
                                    break;
                                case "MOVE":
                                    switch (posFacing)
                                    {
                                        case "W":
                                            if (posX == xStartingPoint)
                                            {
                                                System.out.println("Moving Forward not possible Please change direction");
                                            }
                                            else
                                            {
                                                posX = posX - 1;
                                            }

                                            break;
                                        case "E":
                                            if (posX == xEndingingPoint)
                                            {
                                                System.out.println("Moving Forward not possible Please change direction");
                                            }
                                            else
                                            {
                                                posX = posX + 1;
                                            }
                                            break;
                                        case "N":
                                            if (posY == yEndingingPoint)
                                            {
                                                System.out.println("Moving Forward not possible Please change direction");
                                            }
                                            else
                                            {
                                                posY = posY + 1;
                                            }
                                            break;
                                        case "S":
                                            if (posY == yStartingPoint)
                                            {
                                                System.out.println("Moving Forward not possible Please change direction");
                                            }
                                            else
                                            {
                                                posY = posY - 1;
                                            }
                                            break;


                                    }
                                    break;
                                case "REPORT":
                                    String outputPosFacting = "";
                                    switch (posFacing)
                                    {

                                        case "W":
                                            outputPosFacting = "WEST";
                                            break;
                                        case "E":
                                            outputPosFacting = "EAST";
                                            break;
                                        case "S":
                                            outputPosFacting = "SOUTH";
                                            break;
                                        case "N":
                                            outputPosFacting = "NORTH";
                                            break;
                                        default:
                                            System.out.println("Please provide valid directions");
                                            break;
                                    }
                                    System.out.println("OUTPUT: " + posX + "," + posY + "," + outputPosFacting + "");
                                    System.out.println();
                                    break;
                            }
                        }
                        else
                        {
                            System.out.println("Allowed commands are PLACE,LEFT,RIGHT,MOVE,REPORT and command to start application is PLACE.");
                        }
                    }

                }
                else
                {
                    System.out.println("Please enter pacman command");
                }
            }
            scanner.close();
	}
}
