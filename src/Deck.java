/**
 * Represents a deck of cards owned by a player.
 * Extends the CardList class.
 */
public class Deck extends CardList {

    private Player player; // The player who owns the deck

    /**
     * Constructs a Deck object owned by the specified player.
     *
     * @param player the player who owns the deck
     */
    public Deck(Player player) {
        super(); // Call the constructor of the parent class
        this.player = player; // Set the player who owns the deck
    }

    /**
     * Adds a card to the deck.
     * The card is initially hidden.
     *
     * @param card the card to add to the deck
     */
    public void addCard(Card card) {
        card.setHidden(true); // Hide the card
        getCards().add(card); // Add the card to the deck
    }

    /**
     * Returns a string representation of the deck.
     * The string contains information about the size and values of the cards in the deck.
     *
     * @return a string representation of the deck
     */
    public String toString() {
        String str = "";  // Create an empty string
        str = "Size of list : " + this.sizeList() + " List : |"; // Add the size of the list
        for (Card card : getCards()) { // For each card in the list
            str += " " + card.getValue(); // Add the value of the card
        }
        str += " |\n                           ";
        for (Card card : getCards()) {
            if (card.isHidden()) {
                str += " H";
            } else {
                str += " V";
            }
        }
        return str; // Return the string
    }

    /**
     * Returns the player who owns the deck.
     *
     * @return the player who owns the deck
     */
    public Player getPlayer() {
        return this.player;
    }
}