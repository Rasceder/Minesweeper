import com.javacourse.minesweeper.MineGenerator;
import java.util.Scanner;
public class MineSweeper {
	
	static int[][] boardCount = new int[10][10];
	static String[][] board = new String[12][12];
	
	enum Command {
		f, // Flag position
		r, // Sweep position
		q, // quit game
		UNKNOWN, //Unknown command
		}
	// Prints board
	public static void printGame(String[][] str) {
	    
		str[0][0] = " ";
	    str[0][1] = " ";	    
	    str[1][1] = "+";
	    str[1][0] = " ";

	    for (int r = 2; r<str.length;r++){
	        for (int c = 2; c <str.length;c++){
	            str[r][c] = "–";
	        }
	    }
	    for (int r = 2; r<str.length;r++){
	        int c = 1;
	        str[r][c] = "|";
	        }
	    for (int r = 2; r<str.length;r++){
	        int c = 0;
	        str[r][c] = Integer.toString(r - 2);
	        }
	    for (int c = 2; c<str.length;c++){
            int r = 1;
            str[r][c] = "=";
        }
	    for (int c = 2; c<str.length;c++){
            int r = 0;
            str[r][c] = Character.toString(c + 63);
        }
	    
	    // Prints board
	    
	    for (int r = 0; r<str.length;r++){
	        for (int c = 0; c <str.length;c++){
	            System.out.print (str[r][c] + " ");
	        }
	        System.out.println();

	    }
	}
	// Updates console
	public static void update(){
		    printGame(board);
		    System.out.println("");
	}
	// Parses commands from userInput and returns them
	public static Command parseCommand(String userInput) {
		String commandString = userInput.split(" ")[0];
		switch(commandString) {
		case "f":
		return Command.f;
		case "r":
		return Command.r;
		case "q":
		return Command.q;
		default:
		return Command.UNKNOWN;
		}
		}
	// Parses arguments from userInput and returns them
	public static String[] parseArguments(String userInput) {
		String[] commandAndArguments = userInput.split(" ");
		String[] arguments = new String[commandAndArguments.length - 1];
		for (int i=1; i<commandAndArguments.length; i++) {
		arguments[i-1] = commandAndArguments[i];
		}
		return arguments; 
	}
	
	public static void handleFCommand() {

		}
	
	public static void handleRCommand(String[] args) {

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Generates mines
	    String[] coordinates = MineGenerator.sampleMineCoordinates(10, 15);
	    	    System.out.println(java.util.Arrays.toString(coordinates));
	    // Generates board

	    // Next turn, handles command and argument
	    while (true) {
	    	update();
	    	System.out.print("> ");
	    	String userInput = scanner.nextLine();
	    	Command command = parseCommand(userInput);
	    	if (command == Command.UNKNOWN) {
	    	System.out.println("Unknown command");
	    	continue;
	    	}
	    	String[] arguments = parseArguments(userInput);
	    	if (command == Command.f) {
	    	handleFCommand(); 
	    	} else if (command == Command.r) {
	    	handleRCommand(arguments); 
	    	}
	    	}
       

	}

}
