import javax.swing.*;

public class CardChooserPanel extends JPanel {

    private JButton jButton;
    private JPanel cardImagePanel;

    public CardChooserPanel() {
        super(true);
        cardImagePanel = new CardImagePanel();
        jButton = new CardChooserButton("Choose Card", this, cardImagePanel);
        addComponentToPanel(jButton, cardImagePanel);
    }

    public void addComponentToPanel(JComponent... components) {
        for(JComponent jComponent : components) {
            this.add(jComponent);
        }
    }

    public static void renderCardChooserPanel() {
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(new CardChooserPanel());
        jFrame.setSize(900, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
