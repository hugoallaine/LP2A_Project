import javax.swing.*;
import java.awt.*;

/**
 * A custom JButton class with a customized appearance.
 */
public class MyButton extends JButton {

    /**
     * Constructs a MyButton with the specified title.
     *
     * @param title The title of the button.
     */
    public MyButton(String title) {
        super(title); // Call the constructor of the parent class (JButton) with the title of the button as a parameter

        // Set custom appearance of the button
        setForeground(Color.WHITE); // Text color
        setBackground(new Color(0x1E90FF)); // Background color
        setFont(new Font("Arial", Font.PLAIN, 27)); // Font
        setFocusPainted(false); // Disable the border that appears around the button when it is clicked
    }
    
}