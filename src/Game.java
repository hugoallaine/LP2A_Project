import java.lang.reflect.Array;

/**
 * 
 * The Game class represents a game.
 * It keeps track of the number of players, draw pile, discard pile, players,
 * current player, first player, turn, starting selection, and a counter.
 */

public class Game {
    private int nbPlayer; // Number of players
    private Draw draw; // Draw pile
    private Discard discard; // Discard pile
    private Player[] players; // Players
    private int currentPlayer; // Current player
    private int firstPlayer; // First player
    private int turn; // Turn
    private boolean startingSelection; // Selection of two cards at the beginning of the game
    private int counter = 0; // Counter
    private boolean isDrawSelected = false; // Draw pile selection
    private boolean isDiscardSelected = false; // Discard pile selection
    private boolean finalRound = false; // End of round
    private boolean freeCard = false; // Free card

    /**
     * Constructs a new Game object.
     * The number of players is set to 0 and starting selection is set to true.
     */
    public Game() {
        this.nbPlayer = 0; // Set the number of players to 0
    }

    /**
     * Gets the number of players in the game.
     *
     * @return The number of players.
     */
    public int getNbPlayer() {
        return this.nbPlayer; // Return the number of players
    }

    /**
     * Gets the current player.
     *
     * @return The current player.
     */
    public Player getCurrentPlayer() {
        return this.players[currentPlayer]; // Return the current player
    }

    /**
     * Gets the current player number.
     *
     * @return The current player number.
     */
    public int getCurrentPlayerNumber() {
        return this.currentPlayer; //Return the number of the current player
    }

    /**
     * Gets the first player.
     *
     * @return The first player.
     */
    public int getFirstPlayer() {
        return this.firstPlayer; // Return the first player
    }

    /**
     * Gets the current turn number.
     *
     * @return The turn number.
     */
    public int getTurn() {
        return this.turn; // Return the turn number
    }

    /**
     * Gets the draw pile.
     *
     * @return The draw pile.
     */
    public Draw getDraw() {
        return this.draw; // Return the draw pile
    }

    /**
     * Gets the discard pile.
     *
     * @return The discard pile.
     */
    public Discard getDiscard() {
        return this.discard; // Return the discard pile
    }

    /**
     * Gets a player at a specific index.
     *
     * @param index The index of the player.
     * @return The player at the specified index.
     */
    public Player getPlayers(int index) {
        return ((Player) Array.get(this.players, index));
    }

    /**
     * Gets all the players in the game.
     *
     * @return An array of players.
     */
    public Player[] getPlayers() {
        return this.players; // Return the players
    }

    /**
     * Gets the counter value.
     *
     * @return The counter value.
     */
    public int getCounter() {
        return this.counter; // Return the counter value
    }

    /**
     * Gets the final round value.
     *
     * @return The final round value.
     */
    public boolean isFinalRound() {
        return this.finalRound; // Return the final round value
    }

    /**
     * Checks if the draw pile is selected.
     *
     * @return True if the draw pile is selected, false otherwise.
     */
    public boolean isDrawSelected() {
        return this.isDrawSelected; // Return the value of isDrawSelected
    }

    /**
     * Checks if the discard pile is selected.
     *
     * @return True if the discard pile is selected, false otherwise.
     */
    public boolean isDiscardSelected() {
        return this.isDiscardSelected; // Return the value of isDiscardSelected
    }

    /**
     * Checks if the starting selection is enabled.
     *
     * @return True if starting selection is enabled, false otherwise.
     */
    public boolean isStartingSelection() {
        return this.startingSelection; // Return the value of startingSelection
    }

    /**
     * Checks if the player can flip a card
     *
     * @return True if the player can flip a card, false otherwise.
     */
    public boolean isFreeCard() {
        return this.freeCard; // Return the value of freeCard
    }

    /**
     * Sets the players in the game.
     *
     * @param players An array of Player objects representing the players.
     */
    public void setPlayers(Player[] players) {
        this.players = players; // Set the players
    }

    /**
     * Sets a player at a specific index.
     *
     * @param index  The index of the player.
     * @param player The Player object to set.
     */
    public void setPlayers(int index, Player player) {
        Array.set(this.players, index, player); // Set the player at the specified index
    }

    /**
     * Sets the draw pile.
     *
     * @param draw The Draw object representing the draw pile.
     */
    public void setDraw(Draw draw) {
        this.draw = draw; // Set the draw pile
    }

    /**
     * Sets the discard pile.
     *
     * @param discard The Discard object representing the discard pile.
     */
    public void setDiscard(Discard discard) {
        this.discard = discard; // Set the discard pile
    }

    /**
     * Sets the number of players in the game.
     * Also initializes the players array.
     *
     * @param nbPlayer The number of players.
     */
    public void setNbPlayer(int nbPlayer) {
        this.nbPlayer = nbPlayer; // Set the number of players
        initializePlayersArray(); // Initialize the players array
    }

    /**
     * Sets the current player number.
     *
     * @param currentPlayer The current player number.
     */
    public void setCurrentPlayerNumber(int currentPlayer) {
        this.currentPlayer = currentPlayer; // Set the current player number
    }

    /**
     * Sets the first player.
     *
     * @param firstPlayer The first player.
     */
    public void setFirstPlayer(int firstPlayer) {
        this.firstPlayer = firstPlayer; // Set the first player
    }

    /**
     * Sets the turn number.
     *
     * @param turn The turn number.
     */
    public void setTurn(int turn) {
        this.turn = turn; // Set the turn number
    }

    /**
     * Sets the starting selection.
     *
     * @param startingSelection The starting selection value.
     */
    public void setStartingSelection(boolean startingSelection) { 
        this.startingSelection = startingSelection; // Set the starting selection value
    }

    /**
     * Sets the counter value.
     *
     * @param nb The counter value to set.
     */
    public void setCounter(int nb) {
        this.counter = nb; // Set the counter value
    }

    /**
     * Sets the draw pile selection.
     *
     * @param isDrawSelected The draw pile selection value.
     */
    public void setDrawSelected(boolean isDrawSelected) {
        this.isDrawSelected = isDrawSelected; // Set the draw pile selection value
    }

    /**
     * Sets the discard pile selection.
     *
     * @param isDiscardSelected The discard pile selection value.
     */
    public void setDiscardSelected(boolean isDiscardSelected) {
        this.isDiscardSelected = isDiscardSelected; // Set the discard pile selection value
    }

    /**
     * Sets the free card value.
     *
     * @param freeCard The free card value.
     */
    public void setFreeCard(boolean freeCard) {
        this.freeCard = freeCard; // Set the free card value
    }

    /**
     * Sets the final round value.
     *
     * @param finalRound The final round value.
     */
    public void setFinalRound(boolean finalRound) {
        this.finalRound = finalRound;   // Set the final round value
    }

    /**
     * Initializes the players array with the specified number of players.
     * Creates an array of Player objects and sets it as the players array.
     */
    private void initializePlayersArray() {
        Player[] players = new Player[this.nbPlayer]; // Create an array of players
        setPlayers(players); // Set the players
    }

    /**
     * Initializes the game with the specified players.
     *
     * @param players An array of Player objects representing the players.
     */
    public void initializeGame(Player[] players) {
        System.out.println("[initializeGame]");
        this.draw = initializeDrawPile(); // Create Draw pile
        setPlayers(players); // Set the players
        // Create a CardList for each player with the number of cards specified in the
        // config file
        for (Player player : players) {
            cardDistribution(player); // Create a deck for each player
            // Print the cards of each player
            //System.out.println("Cartes du joueur " + player.getName() + " : " + player.getDeck().toString()); 
        }
        this.discard = new Discard(); // Create Discard pile
        discard.addCard(drawCard()); // Add a card to the discard pile
        setDraw(draw); // Set the draw pile
        setDiscard(discard); // Set the discard pile
        // Set the current player to random player
        setCurrentPlayerNumber(0);
        setFirstPlayer(getCurrentPlayerNumber());
        setStartingSelection(true); // Set the starting selection to true
        setTurn(1);
    }
    /**
     * Initializes the new round.
     */
    public void initializeNewRound() {
        System.out.println("[initializeNewRound]"); 
        int isNotLastPlayer = 0; // Check if the player is not the last one (about the score)
        for (Player player : getPlayers()) { // For each player
            player.setScoreRound(computeFinalPlayerScoreRound(player)); // Compute the score of the player
            if (player.getScoreRound() < players[getFirstPlayer()].getScoreRound() && player != players[getFirstPlayer()] && isNotLastPlayer == 0) { // If the player is not the last one AND 
                                                                                                                                                     // his score is lower than the 
                                                                                                                                                     // first player who turned all his cards
                players[getFirstPlayer()].setScoreRound(players[getFirstPlayer()].getScoreRound()*2); // The first player who turned all his cards gets his score doubled 
                                                                                                      //if he doesn't have the smallest score
                break;
            }
        }
        for (Player player : getPlayers()) {
            draw.addDeck(player.getDeck()); // Add the deck of the player to the draw pile
            player.getDeck().clear(); // Clear the deck of the player
            player.setScore(player.getScoreRound()+player.getScore()); // Add the score of the player to his total score
            player.setScoreRound(0); // Reset the score of the player
        }
        draw.addDiscard(discard); // Add the discard pile to the draw pile
        discard.clear(); // Clear the discard pile
        draw.shuffle(); // Shuffle the draw pile
        for (Player player : players) {
            cardDistribution(player); // Create a deck for each player
            // Print the cards of each player
            //System.out.println("Cartes du joueur " + player.getName() + " : " + player.getDeck().toString());
        }
        discard.addCard(drawCard()); // Add a card to the discard pile
        setDraw(draw); // Set the draw pile
        setDiscard(discard); // Set the discard pile
        setFinalRound(false); // Set the final round to false
        setFreeCard(false); // Set the free card to false
        setDrawSelected(false); // Set the draw pile selection to false
        setDiscardSelected(false); // Set the discard pile selection to false
        setCurrentPlayerNumber(0); // Set the current player to random player
        setFirstPlayer(getCurrentPlayerNumber()); // Set the first player to the current player
        setTurn(1); // Set the turn to 1 
        setStartingSelection(true); // Set the starting selection to true
    }

    /**
     * Initializes the draw pile.
     *
     * @return The initialized Draw object representing the draw pile.
     */
    public Draw initializeDrawPile() {
        System.out.println("[initializeDrawPile]");
        Draw draw = new Draw();
        // Create a draw with the number of cards specified in the config file
        String[] keys = { "A", "B", "C", "D", "E", "FX", "F" }; // Keys of the config file
        int[] values = { ConfigLoader.getInt("A"), ConfigLoader.getInt("B"), ConfigLoader.getInt("C"), // Values of the config file
                ConfigLoader.getInt("D"), ConfigLoader.getInt("E"), // Values of the config file
                ConfigLoader.getInt("FX"), ConfigLoader.getInt("F") }; // Values of the config file
        // Iterate through the number of keys
        for (int j = 0; j < keys.length; j++) {
            String key = keys[j]; // Get the key
            int value = values[j]; // Get the value
            for (int i = 0; i < value; i++) {
                // Use key and value to create a card
                draw.addCard(new Card(ConfigLoader.getInt(key + "_value"), true, ConfigLoader.getString(key + "_path"),
                        ConfigLoader.getString("hiddenCard"), ConfigLoader.getString(key + "_selected")));
            }
        }
        draw.shuffle(); // Shuffle the draw
        setDraw(draw); // Set the draw
        return draw; // Return the draw
    }

    /**
     * Distributes cards to the specified player.
     *
     * @param player The Player object to distribute cards to.
     */
    public void cardDistribution(Player player) {
        System.out.println("[cardDistribution]");
        Deck hand = new Deck(player); // Create a CardList for the player
        for (int i = 0; i < ConfigLoader.getInt("playerDeckSize"); i++) {
            hand.addCard(drawCard()); // Add the first card of the draw to the player's CardList
        }
        player.setDeck(hand); // Set the player's CardList
    }

    /**
     * Gets the next player in the game.
     *
     * @return The next player in the game.
     */
    public int getNextPlayer() {
        System.out.println("[getNextPlayer]");
        // If the current player is the last player, we go back to the first player
        if (getCurrentPlayerNumber() == getNbPlayer() - 1) { //if the current player is the last player
            return 0; //return the first player
        } else { //if the current player is not the last player
            return getCurrentPlayerNumber() + 1; //return the next player
        }
    }

    /**
     * Moves the game to the next player.
     */
    public void nextPlayer() {
        System.out.println("[nextPlayer]");
        setCurrentPlayerNumber(getNextPlayer()); // Set the current player to the next player
    }

    /**
     * Checks the turn and updates game state if necessary.
     */
    public void checkTurn() {
        System.out.println("[checkTurn]");
        if (getCurrentPlayerNumber() == getFirstPlayer()) { // If the current player is the first player
            setTurn(getTurn() + 1); // Increment the turn
        }
        if (isStartingSelection()) { // If it's the first turn (Players flip 2 cards)
            if (getTurn() > 1) { // If it's the second turn
                int counter = 0; // Counter to get the first player
                int highestScore = 0; // Highest score of the round
                setStartingSelection(false); // Set the starting selection to false
                for (Player player : getPlayers()) { // For each player
                    if (player.getScoreRound() > highestScore) { // If the score of the player is higher than the highest score
                        highestScore = player.getScoreRound(); // Set the highest score to the score of the player
                    }
                    if (player.getScoreRound() == highestScore) { // If the score of the player is equal to the highest score
                        setFirstPlayer(counter); // Set the first player to the player
                    }
                    counter++; // Increment the counter
                }
                setCurrentPlayerNumber(getFirstPlayer()); // Set the current player to the first player
            }
        }
    }

    /**
     * Draws a card from the draw pile.
     *
     * @return The Card object drawn from the draw pile.
     */
    public Card drawCard() {
        System.out.println("[drawCard]");
        // Get the first card of the draw
        Card card = draw.getCard(0);
        // Remove the first card of the draw
        draw.removeCardByIndex(0);
        return card;
    }

    /**
     * Draws a card from the discard pile.
     *
     * @return The Card object drawn from the discard pile.
     */
    public Card drawDiscardedCard() {
        System.out.println("[drawDiscardedCard]");
        Card card = this.discard.getCard(this.discard.sizeList() - 1); // Get the last card of the discard pile
        this.discard.removeCardByIndex(this.discard.sizeList() - 1); // Remove the last card of the discard pile
        return card;
    }

    /**
     * Discards a card by adding it to the discard pile.
     *
     * @param card The Card object to discard.
     */
    public void discardCard(Card card) {
        System.out.println("[discardCard]");
        this.discard.addCard(card); // Add the card to the discard pile
    }

    /**
     * Discards a column of the hand.
     *
     * @param player The Player object representing the player.
     * @return The updated hand after discarding the column.
     */
    public boolean discardColomnHand(Player player) {
        System.out.println("[discardColomnHand]");
        //System.out.println("Avant :\n" + player.getDeck().toString());
        int counter = 0; // Initialize a counter
        for (int i = 0; i < player.getDeck().sizeList() / 3; i++) {
            // Iterate through the number of columns
            for (int j = i; j < player.getDeck().sizeList(); j += player.getDeck().sizeList() / 3) {
                // Iterate through the number of cards in the hand
                if ((counter == 0) && (!player.getDeck().getCard(j).isHidden())) {
                    // If the counter is 0 and the card of the hand is not hidden
                    counter++; // Increment the counter
                } else {
                    if (!player.getDeck().getCard(j).isHidden()) { // If the card of the hand is not hidden
                        if (player.getDeck().getCard(i).getValue() == player.getDeck().getCard(j).getValue()) {
                            // If the card of the hand has the same value as the first card of the hand
                            counter++; // Increment the counter
                            if (counter == 3) { // If the counter is 3
                                int size = player.getDeck().sizeList() / 3;
                                for (int k = j; k >= 0; k -= size) {
                                    // Iterate through the number of cards in the hand
                                    discardCard(player.getDeck().getCard(k)); // Discard the card of the hand
                                    player.getDeck().removeCardByIndex(k); // Remove the card of the hand
                                }
                                System.out.println("Après :\n" + player.getDeck().toString());
                                return true;
                            }
                        } else {
                            counter = 0; // Reset the counter
                            break;
                        }
                    } else {
                        counter = 0; // Reset the counter
                        break;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Swaps a card from the draw pile with a card in the specified deck at the
     * given index.
     * 
     * @param player The Player object representing the player.
     * @param index  The index of the card in the deck to be swapped.
     */
    public void swapCardFromDraw(Player player, int index) {
        Card drawedCard = drawCard(); // Draw a card from the draw pile
        drawedCard.setHidden(false); // Set the drawn card to visible
        Card swappedCard = player.getDeck().getCards().set(index, drawedCard); // Replace the card at the specified
                                                                               // index with the drawn
        swappedCard.setHidden(false); // Set the replaced card to visible
        discardCard(swappedCard); // Add the replaced card to the discard pile
    }

    /**
     * Swaps a card from the discard pile with a card in the specified deck at the
     * given index.
     *
     * @param player The Player object representing the player.
     * @param index  The index of the card in the deck to be swapped.
     */
    public void swapCardFromDiscard(Player player, int index) {
        Card drawedCard = drawDiscardedCard(); // Draw a card from the discard pile
        Card swappedCard = player.getDeck().getCards().set(index, drawedCard); // Replace the card at the specified
                                                                               // index with the drawn
        // card
        swappedCard.setHidden(false); // Set the replaced card to visible
        discardCard(swappedCard); // Add the replaced card to the discard pile
    }

    /**
     * Computes the score of the specified player based on the visible cards in
     * their deck.
     *
     * @param player The Player object for which to compute the score.
     * @return The computed score for the player.
     */
    public int computePlayerScoreRound(Player player) {
        int score = 0;
        for (int i = 0; i < player.getDeck().sizeList(); i++) { // Iterate through the number of cards in the deck
            if (!player.getDeck().getCard(i).isHidden()) { // If the card is not hidden
                score += player.getDeck().getCard(i).getValue(); // Add the value of the card to the score
            }
        }
        return score;
    }

    /**
     * Computes the final score of the specified player based on all the cards in
     * their deck.
     *
     * @param player The Player object for which to compute the score.
     * @return The computed score for the player.
     */
    public int computeFinalPlayerScoreRound(Player player) {
        int score = 0;
        for (int i = 0; i < player.getDeck().sizeList(); i++) { // Iterate through the number of cards in the deck
            score += player.getDeck().getCard(i).getValue(); // Add the value of the card to the score
        }
        return score;
    }

    /**
     * Verifies if the current round has ended for the specified player.
     * If all cards in the player's deck are visible, it marks the final round and
     * sets the first player for the next round.
     *
     * @param player The player for whom to verify the end of the round.
     */
    public void verifEndRound(Player player) {
        int counter = 0; // Initialize a counter

        // Count the number of visible cards in the player's deck
        for (Card card : player.getDeck().getCards()) { // Iterate through the cards in the deck
            if (!card.isHidden()) { // If the card is not hidden
                counter++; // Increment the counter
            } else { // If the card is hidden
                break;
            }
        }

        // If all cards in the player's deck are visible, mark it as the final round and
        // set the first player for the next round
        if (counter == player.getDeck().sizeList()) { // If the counter is equal to the number of cards in the deck
            finalRound = true; // Mark the final round
            setFirstPlayer(getCurrentPlayerNumber()); // Set the first player for the next round
        }
    }

    /**
     * Recharges the draw pile by transferring all cards from the discard pile to
     * the draw pile.
     * After transferring the cards, the discard pile is cleared and the draw pile
     * is shuffled.
     */
    public void rechargeDraw() {
        // Transfer cards from the discard pile to the draw pile
        for (Card card : discard.getCards()) { // Iterate through the cards in the discard pile
            draw.addCard(card); // Add the card to the draw pile
        }

        // Clear the discard pile
        discard.clear(); // Clear the discard pile

        // Shuffle the draw pile
        draw.shuffle(); // Shuffle the draw pile
    }
}