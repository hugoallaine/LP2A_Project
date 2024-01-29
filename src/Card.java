/**
 * Represents a card in the game of Skyjo.
 * Each card has a value, can be hidden or not, and has an associated image
 * path.
 */
public class Card {

    private int value; // Value of the card
    private boolean hidden; // Whether the card is hidden or not
    private String imagePath; // Path to the image of the card
    private String hiddenImagePath; // Path to the image of the hidden card
    private String selectedImagePath; // Path to the image of the selected card

    /**
     * Constructs a new card with the specified value, hidden status, and image
     * paths.
     *
     * @param value             the value of the card
     * @param hidden            true if the card is hidden, false otherwise
     * @param imagePath         the path to the image of the card
     * @param hiddenImagePath   the path to the image of the hidden card
     * @param selectedImagePath the path to the image  in selected state
     */
    public Card(int value, boolean hidden, String imagePath, String hiddenImagePath, String selectedImagePath) {
        this.hidden = hidden;
        this.value = value;
        this.imagePath = imagePath;
        this.hiddenImagePath = hiddenImagePath;
        this.selectedImagePath = selectedImagePath;
    }

    /**
     * Checks if the card is hidden.
     *
     * @return true if the card is hidden, false otherwise
     */
    public boolean isHidden() {
        return this.hidden;
    }

    /**
     * Sets the hidden status of the card.
     *
     * @param hidden true to hide the card, false to reveal it
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * Returns the value of the card.
     *
     * @return the value of the card
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Returns the path to the image of the card.
     * If the card is hidden, returns the path to the image of the hidden card.
     *
     * @return the path to the image of the card or hidden card
     */
    public String getImagePath() {
        if (isHidden())
            return this.hiddenImagePath;
        else
            return this.imagePath;
    }

    /**
     * Returns the path to the image selected state.
     *
     * @return the path to the image selected state
     */
    public String getSelectedImagePath() {
        return this.selectedImagePath;
    }

}