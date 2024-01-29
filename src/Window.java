import java.awt.*;
import javax.swing.*;

/**
 * Represents a custom window for the Skyjo Enhanced: UTBM Edition game.
 */
public class Window {
    protected JFrame window; // The JFrame of the window

    /**
     * Creates a new Window object.
     * Initializes the JFrame, sets its properties, and displays it.
     */
    public Window() {
        window = new JFrame("Skyjo Enhanced: UTBM Edition");
        ImageIcon icon = new ImageIcon("src/resources/images/logo.png");
        Image image = icon.getImage();
        window.setIconImage(image);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBackground(Color.RED);
        Dimension monitorSize = Toolkit.getDefaultToolkit().getScreenSize();
        window.setSize(monitorSize.width * 9/10, monitorSize.height * 9/10);
        window.setLocationRelativeTo(null);
        updateWindow();
    }

    /**
     * Makes the window visible.
     */
    public void updateWindow() {
        window.setVisible(true);
    }

}