/**
 * Represents the discard pile of cards.
 * Extends the CardList class.
 */
public class Discard extends CardList {

    /**
     * Constructs a Discard object.
     * Calls the constructor of the CardList class.
     */
    public Discard() {
        super(); // Call the constructor of CardList
    }

    /**
     * Returns a string representation of the discard pile.
     * The string contains information about the size and values of the cards in the discard pile.
     *
     * @return a string representation of the discard pile
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
     * Adds a card to the discard pile.
     * The card is set to not hidden.
     *
     * @param card the card to add to the discard pile
     */
    public void addCard(Card card) {
        card.setHidden(false); // Set the card to not hidden
        getCards().add(card); // Add the card to the list
    }

}