/**
 * Represents a player in the game.
 * Each player has a name, a score, a deck, and a round score.
 */
public class Player {

    private String name; // Player's name
    private int score; // Player's score
    private Deck deck; // Player's deck
    private int roundScore; // Player's score for the current round

    /**
     * Constructs a new player with the specified name.
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name; // Set name
        this.score = 0; // Set score to 0
        this.deck = new Deck(this); // Create new deck with player in parameter
        this.roundScore = 0; // Set round score to 0
    }

    /**
     * Get the player's name.
     *
     * @return The player's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the player's score.
     *
     * @return The player's score.
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Get the player's deck.
     *
     * @return The player's deck.
     */
    public Deck getDeck() {
        return this.deck;
    }

    /**
     * Set the player's score.
     *
     * @param score The score to set.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Set the player's deck.
     *
     * @param deck The deck to set.
     */
    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    /**
     * Set the player's round score.
     *
     * @param roundScore The round score to set.
     */

    public void setScoreRound(int roundScore) {
        this.roundScore = roundScore;
    }

    /**
     * Get the player's round score.
     *
     * @return The player's round score.
     */
    public int getScoreRound() {
        return this.roundScore;
    }   
}
