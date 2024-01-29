import java.util.ArrayList;

/**
 *
 * Abstract class representing a list of cards.
 * 
 * Provides common functionality for managing a list of cards.
 */
public abstract class CardList {

    private ArrayList<Card> cards; // List of cards

    /**
     * 
     * Constructs a new CardList object.
     * Initializes an empty list of cards.
     */
    public CardList() {
        this.cards = new ArrayList<Card>();
    }

    /**
     *
     * Adds a card to the list.
     * 
     * @param card the card to be added
     */
    public abstract void addCard(Card card);

    /**
     * 
     * Removes a card from the list based on the card itself.
     * 
     * @param card the card to be removed
     */
    public void removeCardByCard(Card card) {
        this.cards.remove(card);
    }

    /**
     * 
     * Removes a card from the list based on its index.
     * 
     * @param index the index of the card to be removed
     */
    public void removeCardByIndex(int index) {
        this.cards.remove(index);
    }

    /**
     * 
     * Retrieves a card from the list based on its index.
     * 
     * @param index the index of the card to retrieve
     * @return the card at the specified index
     */
    public Card getCard(int index) {
        return this.cards.get(index);
    }

    /**
     * 
     * Returns the number of cards in the list.
     * 
     * @return the size of the list
     */
    public int sizeList() {
        return this.cards.size();
    }

    /**
     * 
     * Clears the list, removing all cards.
     */
    public void clear() {
        this.cards.clear();
    }

    /**
     * 
     * Retrieves the list of cards.
     * 
     * @return the list of cards
     */
    public ArrayList<Card> getCards() {
        return this.cards;
    }

    /**
     * 
     * Returns a string representation of the list.
     * The string includes the size of the list and the values of the cards.
     * 
     * @return a string representation of the list
     */
    public String toString() {
        String str = "Size of list: " + this.sizeList() + " List: |";
        for (Card card : this.cards) {
            str += " " + card.getValue();
        }
        str += "|";
        return str;
    }

    /**
     * 
     * Draws a card from the list.
     * Removes the card from the list and returns it.
     * 
     * @return the drawn card
     */
    public Card draw() {
        Card card = this.getCard(0);
        this.removeCardByIndex(0);
        return card;
    }
}