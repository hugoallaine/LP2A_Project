import java.util.Collections;

/**
 * Represents the draw pile of cards.
 * Extends the CardList class.
 */
public class Draw extends CardList {

    /**
     * Constructs a Draw object.
     * Calls the constructor of the CardList class.
     */
    public Draw() {
        super(); // Call the constructor of CardList
    }

    /**
     * Adds a card to the draw pile.
     * The card is set to hidden.
     *
     * @param card the card to add to the draw pile
     */
    public void addCard(Card card) {
        card.setHidden(true); // Set the card to hidden
        getCards().add(card); // Add the card to the draw pile
    }

    /**
     * Returns a string representation of the draw pile.
     * The string contains information about the size and values of the cards in the draw pile.
     *
     * @return a string representation of the draw pile
     */
    public String toString() {
        String str = ""; // Initialize an empty string
        str = "Size of list : " + this.sizeList() + " List : |"; // Add the size of the list to the string
        for (Card card : getCards()) { // For each card in the list
            str += " " + card.getValue(); // Add the value of the card to the string
        }
        str += "|"; // Add a "|" to the string
        return str; // Return the string
    }

    /**
     * Shuffles the draw pile.
     * Uses the Collections.shuffle() method to randomly reorder the cards in the draw pile.
     */
    public void shuffle() {
        Collections.shuffle(getCards()); // Shuffle the draw pile
    }
    
    public void addDeck(Deck deck) {
        for (Card card : deck.getCards()) { // For each card in the deck
            addCard(card); // Add the card to the draw pile
        }
    }

    public void addDiscard(Discard discard) {
        for (Card card : discard.getCards()) { // For each card in the discard pile
            addCard(card); // Add the card to the draw pile
        }
    }
}