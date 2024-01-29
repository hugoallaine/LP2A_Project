import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.util.Comparator;

/**
 * Represents the graphic interface for the Skyjo Enhanced: UTBM Edition.
 * Extends the Window class.
 */
public class GameMenu extends Window {
    private final int cardWeight = 50; // Card weight
    private final int cardHeight = 100; // Card height
    private int gameMode = 0; // Game mode
    private int round = 1;  // Round number
    private Game game; // Game
    private ArrayList<JPanel> jeux; // Panels
    private JLabel turnLabel; // Turn number label
    private JLabel currentPlayerLabel; // Current player label
    private JLabel cardsNumberDrawLabel; // Card's number in draw pile
    private JLabel drawCard; // Draw label
    private JLabel discardCard; // Discard label
    private JLabel roundLabel;

    /**
     * Creates a new GameMenu object.
     * Calls the constructor of the Window class.
     *
     * @param game The Game object associated with the menu.
     */
    public GameMenu(Game game) {
        super();
        this.game = game;
        this.jeux = new ArrayList<JPanel>();
    }

    /**
     * Returns the weight of a card.
     *
     * @return The weight of a card.
     */
    public int getCardWeight() {
        return this.cardWeight;
    }

    /**
     * Returns the height of a card.
     *
     * @return The height of a card.
     */
    public int getCardHeight() {
        return this.cardHeight;
    }

    /**
     * Returns the turn number label.
     * 
     * @return The turn number label.
     */
    public JLabel getTurnLabel() {
        return this.turnLabel;
    }

    /**
     * Returns the current player label.
     * 
     * @return The current player label.
     */
    public JLabel getCurrentPlayerLabel() {
        return this.currentPlayerLabel;
    }

    /**
     * Returns the cards number of draw pile label.
     * 
     * @return The cards number of draw pile label.
     */
    public JLabel getCardsNumberDrawLabel() {
        return this.cardsNumberDrawLabel;
    }

    /**
     * Returns the round number label.
     * 
     * @return The round number label.
     */
    public JLabel getRoundLabel() {
        return this.roundLabel;
    }

    /**
     * Returns the gamemode number.
     * 
     * @return The gamemode number.
     */
    public int getGameMode() {
        return this.gameMode;
    }

    /**
     * Set the round number.
     * 
     * @param round The round number.
     */
    public void setRound(int round) {
        this.round = round;
    }

    /**
     * Get the round number.
     * 
     * @return The round number.
     */
    public int getRound() {
        return this.round;
    }

    /**
     * Displays the main game window
     */
    public void mainWindow() {
        System.out.println("[mainWindow]");
        Border border = new EmptyBorder(0, 600, 150, 600);
        JPanel selection = new JPanel();
        selection.setBorder(border);
        selection.setLayout(new GridLayout(3, 1, 0, 15));
        selection.setOpaque(false);
        MyButton newGame = new MyButton("New Game");
        MyButton rules = new MyButton("Rules");
        MyButton exit = new MyButton("Exit");
        this.window.setContentPane(new JLabel(new ImageIcon("src/resources/images/backgroundmenu.png")));
        ((JLabel) this.window.getContentPane()).setPreferredSize(window.getSize());
        selection.add(newGame);
        selection.add(rules);
        selection.add(exit);
        this.window.setLayout(new BorderLayout());
        this.window.add(selection, BorderLayout.SOUTH);
        updateWindow();
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                askForGameMode();
            }
        });
        rules.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayRules();
            }
        });
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * Displays rules.
     */
    public void displayRules() {
        try {
            File myFile = new File(ConfigLoader.getString("rules_path"));
            if (myFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(myFile);
                } else {
                    JOptionPane.showMessageDialog(null, "isn't supported ", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rules not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // no application registered for PDFs
        }
    }

    /**
     * Displays a dialog box to ask for the game mode (duration) of the game.
     */
    public void askForGameMode() {
        System.out.println("[AskForGameMode]");
        JFrame frame = new JFrame("Select the game mode");
        String[] options = { "DEUTEC", "Engineering degree", "UTBM Enjoyer"};
        int response = JOptionPane.showOptionDialog(frame,
                "Select duration of the game:\nDEUTEC = " + GameModeEnum.QUICK.getValue() + " ECTS,\nEngineering degree = " +
                        GameModeEnum.NORMAL.getValue() + " ECTS,\nUTBM Enjoyer = " + GameModeEnum.LONG.getValue() + " ECTS.",
                "Game mode",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (response == 0) {
            this.gameMode = GameModeEnum.QUICK.getValue();
        } else if (response == 1) {
            this.gameMode = GameModeEnum.NORMAL.getValue();
        } else if (response == 2) {
            this.gameMode = GameModeEnum.LONG.getValue();
        }
        if (response >= 0 && response <= 2) {
            askForTheNumberOfPlayers();
        }
    }

    /**
     * Displays a dialog box to ask for the number of players.
     */
    public void askForTheNumberOfPlayers() {
        System.out.println("[AskForTheNumberOfPlayers]");
        JFrame frame = new JFrame("Select number of players");
        boolean isValidNbPlayers = false;
        JSpinner selection = new JSpinner(new SpinnerNumberModel(2, 2, 6, 1));
        if (JOptionPane.showOptionDialog(frame, selection, "Enter number of players", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null) == JOptionPane.OK_OPTION) {
            game.setNbPlayer((int) selection.getValue());

            if (this.game.getNbPlayer() >= 2 && this.game.getNbPlayer() <= 6) {
                isValidNbPlayers = true;
            }

            if (!isValidNbPlayers) {
                JOptionPane.showMessageDialog(frame, "You have to choose between 2 and 6 players",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            askForPlayersNames();
        }
    }

    /**
     * Displays a dialog box to ask for the names of the players.
     */
    public void askForPlayersNames() { // Ask for the names of the players
        System.out.println("[askForPlayersNames]");
        JFrame enterName = new JFrame("Select names of players"); // Create a new frame
        enterName.setSize(300, 50 + this.game.getNbPlayer() * 65); // Set the size of the frame
        enterName.setLocationRelativeTo(null); // Set the location of the frame
        JPanel panel = new JPanel(new FlowLayout()); // Create a new panel
        for (int i = 1; i <= this.game.getNbPlayer(); i++) { // For each player
            JTextField textField = new JTextField(20); // Create a new text field
            panel.add(new JLabel("Player " + i + " : ")); // Add a label to the panel
            panel.add(textField); // Add the text field to the panel
        }
        JButton btnOk = new JButton("OK"); // Create a new button
        panel.add(btnOk); // Add the button to the panel
        enterName.add(panel); // Add the panel to the frame
        enterName.setVisible(true); // Set the frame visible
        btnOk.addActionListener(new ActionListener() { // Add an action listener to the button
            @Override
            public void actionPerformed(ActionEvent e) { // When the button is clicked
                Boolean isValidPlayerName = false; // Check if the name of the player is valid
                String[] playerNames = new String[game.getNbPlayer()]; // Create a new table of the names of the players
                Component[] components = panel.getComponents(); // Get the components of the panel
                int count = 0; // Create a counter
                for (Component component : components) { // For each component
                    if (component instanceof JTextField) { // If the component is a text field
                        JTextField textField = (JTextField) component; // Get the text field
                        JFrame error = new JFrame("Error"); // Create a new frame
                        if (textField.getText().equals("")) { // If the text field is empty
                            isValidPlayerName = false; // The name is not valid
                            JOptionPane.showMessageDialog(error, "Incorrect name for player " + (count + 1),
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            break;

                        } else if (Arrays.asList(playerNames).contains(textField.getText())) { // If the name is already
                                                                                               // taken
                            isValidPlayerName = false; // The name is not valid
                            JOptionPane.showMessageDialog(error, "Name already taken for player " + (count + 1));
                            break;
                        }

                        else {
                            isValidPlayerName = true; // The name is valid
                            playerNames[count] = textField.getText(); // Get the name of the player
                            game.setPlayers(count, new Player(playerNames[count])); // Create a new player
                            count++; // Increment the counter
                        }
                    }
                }
                if (isValidPlayerName) { // If the name is valid
                    String message = "Players are :\n"; // Create a new message
                    for (String name : playerNames) { // For each name
                        message += "- " + name + "\n"; // Add the name to the message
                    }
                    JOptionPane.showMessageDialog(enterName, message, "New game", JOptionPane.INFORMATION_MESSAGE);
                    enterName.dispose(); // Close the frame
                    startParty(); // Start the party
                }
            }
        });
    }

    /**
     * Starts the game.
     */
    public void startParty() {
        System.out.println("[startParty]");
        System.out.println("Game starting...");
        this.window.getContentPane().removeAll();
        this.window.repaint();
        updateWindow(); // Update the window
        this.game.initializeGame(this.game.getPlayers()); // Initialize the game
        showBoard();
    }

    /**
     * Starts a new round.
     */
    public void startNewRound() {
        System.out.println("[startNewRound]");
        this.window.getContentPane().removeAll();
        this.window.repaint();
        this.game.initializeNewRound();
        setRound(this.round + 1);
        this.jeux.clear();
        this.drawCard = null;
        this.discardCard = null;
        this.turnLabel = null;
        this.currentPlayerLabel = null;
        this.cardsNumberDrawLabel = null;
        this.roundLabel = null;
        showBoard();
    }
    
    /**
     * Returns an image resized to the specified width and height.
     *
     * @param path   The path of the image.
     * @param width  The width of the image.
     * @param height The height of the image.
     * @return The resized image.
     */
    public Image getImageResized(String path, int width, int height) {
        System.out.println("[getImageResize]");
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage();
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return image;
    }

    /**
     * Initializes the deck of a player.
     *
     * @param player The player whose deck is initialized.
     */
    public void initPlayersDeck(Player player) {
        System.out.println("[initPlayersDeck]");
        JPanel playerCards = new JPanel();
        playerCards.setLayout(new BorderLayout());
        JLabel playerInfo = new JLabel(player.getName() + "    score : " + player.getScore());
        playerCards.add(playerInfo, BorderLayout.NORTH);
        JPanel jeu = new JPanel();
        jeu.setLayout(new GridLayout(3, 4));

        JLabel[][] cartesLabels = new JLabel[3][4];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                Image image = getImageResized(player.getDeck().getCard(count).getImagePath(), cardWeight, cardHeight);
                cartesLabels[i][j] = new JLabel(new ImageIcon(image));
                cartesLabels[i][j].addMouseListener(
                        new CardMouseListener(count, player, game, this, playerInfo));
                jeu.add(cartesLabels[i][j]);
                count++;
            }
        }
        playerCards.add(jeu);
        jeux.add(playerCards);
    }

    /**
     * Displays the board.
     */
    public void showBoard() {
        System.out.println("[showBoard]");
        this.window.getContentPane().removeAll();
        this.window.setBackground(Color.RED);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1)); // Create main panel with 3 rows and 3 columns
        // Display draw
        JPanel draw = new JPanel();
        draw.setLayout(new BorderLayout());
        JLabel drawLabel = new JLabel("Draw : ");
        drawLabel.setHorizontalAlignment(SwingConstants.CENTER);
        draw.add(drawLabel, BorderLayout.NORTH);
        this.drawCard = new JLabel();
        updateDraw();
        drawCard.addMouseListener(new CardMouseListener(game, this, 1));
        drawCard.setHorizontalAlignment(SwingConstants.CENTER);
        draw.add(drawCard, BorderLayout.CENTER);

        // Display discard
        JPanel discard = new JPanel();
        discard.setLayout(new BorderLayout());
        JLabel discardLabel = new JLabel("Discard : ");
        discardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        discard.add(discardLabel, BorderLayout.NORTH);
        this.discardCard = new JLabel();
        updateDiscard();
        discardCard.addMouseListener(new CardMouseListener(game, this, 2));
        discardCard.setHorizontalAlignment(SwingConstants.CENTER);
        discard.add(discardCard, BorderLayout.CENTER);

        // Game info
        JPanel gameInfo = new JPanel();
        gameInfo.setLayout(new GridLayout(4, 1));
        this.currentPlayerLabel = new JLabel("Current player : " + game.getCurrentPlayer().getName());
        this.currentPlayerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gameInfo.add(currentPlayerLabel);
        this.turnLabel = new JLabel("Number of turn : " + game.getTurn());
        this.turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gameInfo.add(turnLabel);
        this.roundLabel = new JLabel("Current Round : " + getRound());
        this.roundLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gameInfo.add(roundLabel);
        this.cardsNumberDrawLabel = new JLabel("Number of cards in draw : " + game.getDraw().sizeList());
        this.cardsNumberDrawLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gameInfo.add(cardsNumberDrawLabel);

        // Display players deck
        JPanel decks = new JPanel();
        JPanel decks2 = new JPanel();
        for (int h = 0; h < game.getNbPlayer(); h++) {
            initPlayersDeck(game.getPlayers(h));
            if (h < game.getNbPlayer() / 2) {
                decks.add(jeux.get(h));
            } else {
                decks2.add(jeux.get(h));
            }
        }
    
        // Mid Panel
        JPanel midPanel = new JPanel();
        midPanel.setLayout(new GridLayout(1, 3));
        midPanel.add(draw);
        midPanel.add(gameInfo);
        midPanel.add(discard);

        // Add all panels to main panel
        panel.add(decks);
        panel.add(midPanel);
        panel.add(decks2);
        this.window.add(panel);
        this.window.pack();
        this.window.setLocationRelativeTo(null);
        updateWindow();
    }

    /**
     * Updates the draw label to match with the
     * first card of the draw.
     */
    public void updateDraw() {
        this.drawCard.setIcon(
                new ImageIcon(getImageResized(game.getDraw().getCard(0).getImagePath(), cardWeight, cardHeight)));
    }

    /**
     * Updates the discard label to match with the
     * last card of the draw.
     */
    public void updateDiscard() {
        this.discardCard.setIcon(new ImageIcon(getImageResized(game.getDiscard().getCard(
                game.getDiscard().sizeList() - 1).getImagePath(), cardWeight, cardHeight)));
    }

    /**
     * Updates the window.
     */
    public void displayFinalScore() {
        System.out.println("[displayFinalScore]");
        String[] playerName = new String[game.getNbPlayer()]; // Array of player name

        //setting the frame
        JFrame finalScore = new JFrame(); // Create a new frame for the final score to see who won 
        finalScore.setTitle("Final score"); // Set the title of the frame
        finalScore.setSize(200, 50 + this.game.getNbPlayer() * 65); // Set the size of the frame
        finalScore.setLocationRelativeTo(null); // Set the location of the frame

        JPanel panel = new JPanel(); // Create a new panel
        JLabel playerInfo = new JLabel(); // Create a new label win players informations
        panel.setLayout(new GridLayout(game.getNbPlayer() + 1, 1)); // Set the layout of the panel
        Arrays.sort(game.getPlayers(), Comparator.comparingInt(Player::getScore)); // Sort the players by score
        Player winner = game.getPlayers(0); // Get the winner
        
        JLabel winnerLabel = new JLabel("Winner : " + winner.getName() + " with " + winner.getScore() + " ECTS"); // Create a new label to display the winner
        winnerLabel.setHorizontalAlignment(JLabel.CENTER); // Set the alignment of the label
        panel.add(winnerLabel); // Add the label to the panel

        //setting the panel for all players informations
        for (int i = 0; i < game.getNbPlayer(); i++) { // For each player
            playerName[i] = game.getPlayers(i).getName() + " : " + game.getPlayers(i).getScore() + " ECTS"; // Get the player name and score
            playerInfo = new JLabel(playerName[i]); // Create a new label with the player name and score
            playerInfo.setHorizontalAlignment(JLabel.CENTER); // Set the alignment of the label
            panel.add(playerInfo); // Add the label to the panel
        }
        
        finalScore.add(panel); // Add the panel to the frame
        finalScore.setVisible(true); // Set the frame visible
        finalScore.addWindowListener(new WindowAdapter() { // Add a window listener to the frame
            public void windowClosing(WindowEvent e) { // If the frame is closing
                int reponse = JOptionPane.showConfirmDialog(finalScore,
                        "Do you want to do a new game ?",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE); // Ask the user if he wants to do a new game
                if (reponse == JOptionPane.YES_OPTION) { // If the user wants to do a new game

                    finalScore.dispose(); // Dispose the frame
                    window.getContentPane().removeAll(); // Remove all the components of the window of the game
                    window.repaint(); // Repaint the window of the game
                    updateWindow(); // Update the window of the game

                    // Reset the game parameters
                    jeux.clear(); // Clear the list of players deck 
                    game.setFinalRound(false); // Set the final round to false
                    game.setFreeCard(false); // Set the free card to false
                    game.setDrawSelected(false); // Set the draw selected to false
                    game.setDiscardSelected(false); // Set the discard selected to false
                    game.getDraw().clear(); // Clear the draw
                    game.getDiscard().clear(); // Clear the discard
                    game.setPlayers(null); // Set the players to null
                    setRound(1); // Set the round to 1
                    mainWindow(); // Display the menu window
                } else { // If the user doesn't want to do a new game
                    finalScore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the frame
                    System.exit(0); // Exit the program
                }
            }
        });

    }

    /**
     * Updates the deck.
     */
    public void updateDeck() {
        JPanel deck = jeux.get(game.getCurrentPlayerNumber());
        JPanel jeu = (JPanel) deck.getComponent(1);
        jeu.removeAll();
        int column = game.getCurrentPlayer().getDeck().sizeList()/3;
        jeu.setLayout(new GridLayout(3, column));

        // Create labels for each card
        JLabel[][] cartesLabels = new JLabel[3][column];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < column; j++) {
                Image image = getImageResized(game.getCurrentPlayer().getDeck().getCard(count).getImagePath(), cardWeight, cardHeight);
                cartesLabels[i][j] = new JLabel(new ImageIcon(image));
                cartesLabels[i][j].addMouseListener(
                        new CardMouseListener(count, game.getCurrentPlayer(), game, this, (JLabel) deck.getComponent(0)));
                jeu.add(cartesLabels[i][j]);
                count++;
            }
        }
        updateWindow();
    }
}