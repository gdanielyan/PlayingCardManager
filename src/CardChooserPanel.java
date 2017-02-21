import javax.swing.*;

public class CardChooserPanel extends JPanel {

    private JButton jButton;
    private CardImagePanel cardImagePanel;

    public CardChooserPanel() {
        super(true);
        jButton = new JButton("Choose Card");
        cardImagePanel = new CardImagePanel();
        this.add(jButton);
        this.add(cardImagePanel);
        bindBtnToFileChooser();
    }

    public static void renderCardChooserPanel() {
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(new CardChooserPanel());
        jFrame.setSize(900, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    private void bindBtnToFileChooser() {
        jButton.addActionListener(
            actionListener -> {
                new CardFileChooserDialog().showOpenDialog(this);
            }
        );
    }
}
