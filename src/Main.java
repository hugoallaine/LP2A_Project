/**
 * The main class that contains the main method to start the game.
 */
public class Main {

    /**
     * The main method that initializes the game and displays the main window.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Game game = new Game(); // Create a new game
        GameMenu start = new GameMenu(game); // Create a new game menu
        start.mainWindow(); // Display the main window
    }
    
}