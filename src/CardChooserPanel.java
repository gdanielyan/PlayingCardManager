import javax.swing.*;
import java.awt.*;

public class CardChooserPanel extends JPanel {

    private JButton jButton;
    private static JFrame jFrame;
    private JPanel cardImagePanel;

    public CardChooserPanel() {
        super(true);
        cardImagePanel = new CardImagePanel();
        jButton = new CardChooserButton("Choose Card", this, cardImagePanel, jFrame);
        addComponentToPanel(jButton, cardImagePanel);
    }

    public void addComponentToPanel(JComponent... components) {
        for(JComponent jComponent : components) {
            this.add(jComponent);
        }
    }

    public static void renderCardChooserPanel() {
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setContentPane(new CardChooserPanel());
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        jFrame.setSize(400, 500);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
