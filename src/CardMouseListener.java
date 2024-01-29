import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 * Mouse listener class for handling mouse events on a card.
 * Implements the MouseListener interface.
 */
class CardMouseListener implements MouseListener {

    private int index; // The index of the card
    private Player player; // The player associated with the card
    private GameMenu window; // The game window
    private Game game; // The game instance
    private JLabel scoreLabel; // The score label
    private int pileCategory; // The pile category

    /**
     * Constructs a CardMouseListener with the specified game, game
     * window and the pile category.
     *
     * @param game          the game instance
     * @param window        the game window
     * @param pileCategory  the pile category
     */
    public CardMouseListener(Game game, GameMenu window, int pileCategory) {
        this.game = game;
        this.window = window;
        this.pileCategory = pileCategory;
    }

    /**
     * Constructs a CardMouseListener with the specified card, index, player, game,
     * game window, and score label.
     *
     * @param index     the index of the card
     * @param player    the player associated with the card
     * @param game      the game instance
     * @param window    the game window
     * @param score     the score label
     */
    public CardMouseListener(int index, Player player, Game game, GameMenu window, JLabel score) {
        this.index = index;
        this.player = player;
        this.game = game;
        this.window = window;
        this.scoreLabel = score;
        this.pileCategory = 0;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.player != null) {   // If the card is in a player's hand
            System.out.println("Carte cliquée : " + this.player.getDeck().getCard(this.index).getValue());
            if (this.player == this.game.getCurrentPlayer()) {    // If it's the current player's turn
                if (this.game.isDrawSelected()) {    // If the player has selected the draw pile at the beginning of his turn
                    this.game.swapCardFromDraw(this.player, this.index);   // Swap the card from the draw pile to the player's hand and send card to discard pile
                    this.game.setDrawSelected(false);    // Reset the draw pile selection
                    this.window.updateDraw();    // Update the draw pile
                    this.window.updateDiscard(); // Update the discard pile
                    JLabel carteLabel = (JLabel) e.getSource();
                    changeImage(carteLabel); // update the card image
                    updateScore();
                    updateChanges();
                } else if (this.game.isDiscardSelected()) {  // If the player has selected the discard pile at the beginning of his turn
                    this.game.swapCardFromDiscard(this.player, this.index);    // Swap the card between the discard pile and the player's hand
                    this.player.getDeck().getCard(this.index).setHidden(false);
                    this.game.setDiscardSelected(false);   // Reset the discard pile selection
                    this.window.updateDiscard(); // Update the discard pile
                    JLabel carteLabel = (JLabel) e.getSource();
                    changeImage(carteLabel); // update the card image
                    updateScore();
                    updateChanges();
                } else if (this.game.isFreeCard()) {
                    this.game.setFreeCard(false);
                    JLabel carteLabel = (JLabel) e.getSource();
                    flipImage(carteLabel);
                    updateScore();
                    updateChanges();
                    System.out.println("Current player : " + this.game.getCurrentPlayer().getName());
                } else {    // If the player has selected a card in his hand
                    if (this.game.isStartingSelection() && this.player.getDeck().getCard(this.index).isHidden()) {  // If the card is hidden
                        JLabel carteLabel = (JLabel) e.getSource();
                        flipImage(carteLabel);
                        updateScore();
                        System.out.println("Select a second card.");
                        if (this.game.getCounter() == 0) {   // If it's the first card
                            this.game.setCounter(this.game.getCounter() + 1);
                        } else {    // If it's the second card
                            this.game.setCounter(0);
                            updateChanges();
                        }
                        System.out.println("Current player : " + this.game.getCurrentPlayer().getName());
                    } else {    // If the card is visible
                        System.out.println("You can't flip this card !");
                    }
                }
            } else {    // If it's not the current player's turn
                System.out.println("This is not your turn !");
            }
        } else if (this.pileCategory != 0) { // If the card is in a pile
            if (!this.game.isStartingSelection()) {  // If the player has already selected his first card
                if (!this.game.isDrawSelected() && !this.game.isDiscardSelected()) {  // If the player has not selected a pile yet
                    if (this.pileCategory == 1) {    // If the card is in the draw pile
                        System.out.println("Carte cliquée : " + this.game.getDraw().getCard(0).getValue());
                        this.game.setDrawSelected(true);
                        JLabel carteLabel = (JLabel) e.getSource();
                        this.game.getDraw().getCard(0).setHidden(false);
                        selectImage(carteLabel);
                    } else if (this.pileCategory == 2) { // If the card is in the discard pile
                        System.out.println("Carte cliquée : " + this.game.getDiscard().getCard(this.game.getDiscard().sizeList()-1).getValue());
                        this.game.setDiscardSelected(true);
                        JLabel carteLabel = (JLabel) e.getSource();
                        selectImage(carteLabel);
                    } else {    // If the pile category is not valid
                        System.out.println("Error : pileCategory is not valid !");
                    }
                } else if (this.game.isDrawSelected()) {    // If the player has already selected the draw pile
                    if (this.pileCategory == 2) {    // If the card is in the discard pile
                        System.out.println("Carte cliquée : " + this.game.getDiscard().getCard(this.game.getDiscard().sizeList()-1).getValue());
                        this.game.discardCard(this.game.drawCard());   // Send the drawed card to the discard pile
                        this.game.setDrawSelected(false);    // Reset the draw pile selection
                        this.game.setFreeCard(true);   // Set the free card to true
                        this.window.updateDraw();    // Update the draw pile
                        this.window.updateDiscard(); // Update the discard pile
                    } else {
                        System.out.println("Error : you can't select the draw pile 2 times !");
                    }
                } else if (this.game.isDiscardSelected()) { // If the player has already selected the discard pile
                    this.game.setDiscardSelected(false);
                    this.window.updateDiscard(); // Update the discard pile
                } else {    // If the player has already selected a pile
                    System.out.println("Error");
                }
            } else {    // If the player has not selected his first card yet
                System.out.println("You can't draw a card now !");
            }       
        }
        if (!this.game.isStartingSelection()) {  // If the player has already selected his first card
            if (this.game.getCurrentPlayer().getScore()+this.game.getCurrentPlayer().getScoreRound() >= this.window.getGameMode()){
                for (Player player : game.getPlayers()) {
                    player.setScoreRound(game.computePlayerScoreRound(player));
                    player.setScore(player.getScoreRound()+player.getScore());
                    player.setScoreRound(0);
                }
                this.window.displayFinalScore();
            }
            if (this.game.getDraw().sizeList() == 0) {
                this.game.rechargeDraw();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    /**
     * Updates the changes in the game between each player turn.
     */
    public void updateChanges() {
        System.out.println("[updateChanges]");
        if (this.player != null) {
            boolean isColumnDiscarded = this.game.discardColomnHand(this.player);
            if (isColumnDiscarded) {
                this.window.updateDeck();
                updateScore();
            }
        }
        if (game.getNextPlayer() == game.getFirstPlayer() && game.isFinalRound() == true) {
            game.setFinalRound(false);
            System.out.println("bonne nouvelle checkturn = 1");
            this.window.startNewRound();
            return;
        }
        if (game.isFinalRound() == false) {
            game.verifEndRound(game.getCurrentPlayer());
        }
        this.game.nextPlayer();
        this.game.checkTurn();

        this.window.getTurnLabel().setText("Number of turn : " + this.game.getTurn());
        this.window.getRoundLabel().setText("Current Round : " + this.window.getRound());
        this.window.getCurrentPlayerLabel().setText("Current player : " + this.game.getCurrentPlayer().getName());
        this.window.getCardsNumberDrawLabel().setText("Number of cards in draw : " + this.game.getDraw().sizeList());
    }

    /**
     * Updates the player's score.
     */
    public void updateScore() {
        this.player.setScoreRound(this.game.computePlayerScoreRound(this.player));
        int totalScore = this.player.getScore() + this.player.getScoreRound(); // Compute the player's total score (the score of his previous rounds + the score of the current round)
        this.scoreLabel.setText(this.player.getName() + "    Score : " + totalScore); //display the player's score with his name above his hand
    }

    /**
     * Flips the card image in the player deck.
     *
     * @param carteLabel the card label
     */
    public void flipImage(JLabel carteLabel) {
        this.player.getDeck().getCard(this.index).setHidden(false);
        carteLabel.setIcon(new ImageIcon(
                this.window.getImageResized(this.player.getDeck().getCard(this.index).getImagePath(), this.window.getCardWeight(), this.window.getCardHeight())));
    }

    /**
     * Shows the selected card image (draw and discard only).
     *
     * @param carteLabel the card label
     */
    public void selectImage(JLabel carteLabel) {
        if (this.pileCategory == 1) {
            carteLabel.setIcon(new ImageIcon(
                this.window.getImageResized(this.game.getDraw().getCard(0).getSelectedImagePath(),
                this.window.getCardWeight(), this.window.getCardHeight())));
        } else {
            carteLabel.setIcon(new ImageIcon(
                this.window.getImageResized(this.game.getDiscard().getCard(this.game.getDiscard().sizeList()-1).getSelectedImagePath(),
                this.window.getCardWeight(), this.window.getCardHeight())));
        }
    }

    /**
     * Changes the card image when a card is swapped
     * with the draw or the discard.
     *
     * @param carteLabel the card label
     */
    public void changeImage(JLabel carteLabel) {
        carteLabel.setIcon(new ImageIcon(
                window.getImageResized(player.getDeck().getCard(index).getImagePath(), window.getCardWeight(), window.getCardHeight())));
    }
}