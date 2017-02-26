package components.panels;

import cards.SuitFaceMap;
import components.CardChooseControlButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardChooserPanel extends JPanel {

    private JButton jButton;
    private static JFrame jFrame;
    private CardImagePanel cardImagePanel;

    private SuitFaceMap map;
    private CardChooserControlPanel cardChooserControlPanel;

    public CardChooserPanel() {
        super(true);
        cardChooserControlPanel = new CardChooserControlPanel();
        cardImagePanel = new CardImagePanel();
        map = new SuitFaceMap();
        jButton = new CardChooseControlButton("Choose", cardChooserControlPanel, cardImagePanel, map);
        addComponentToPanel(cardChooserControlPanel, jButton, cardImagePanel);
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
        jFrame.setSize(400, 500);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
