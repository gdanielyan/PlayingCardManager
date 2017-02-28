package components.panels;

import cards.SuitFaceMap;
import components.dialogs.CardChooserDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardChooserPanel extends JPanel {

    private static JFrame jFrame;
    private static JMenuBar jMenuBar;
    private CardImagePanel[] cardImagePanels;

    private SuitFaceMap map;
    private CardChooserControlPanel cardChooserControlPanel;

    public CardChooserPanel() {
        super(true);

        this.setLayout(null);
        this.setLocation(50,100);
        this.setPreferredSize(this.getPreferredSize());
        map = new SuitFaceMap();

        cardChooserControlPanel = new CardChooserControlPanel();
        cardChooserControlPanel.setBounds(10,10, cardChooserControlPanel.getPreferredSize().width, cardChooserControlPanel.getPreferredSize().height);

        cardImagePanels = new CardImagePanel[5];
        for(int i = 0; i < cardImagePanels.length; i++){
            cardImagePanels[i] = new CardImagePanel(this);
            cardImagePanels[i].setBounds(i * 25, i * 25, 250, 365);
            addComponentToPanel(cardImagePanels[i]);
        }

        createMenu(jFrame);
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
        jFrame.setSize(800, 800);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public void createMenu(JFrame jFrame) {
        jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Cards");
        JMenuItem jMenuItem = new JMenuItem("Choose");
        CardChooserDialog cardChooserDialog = new CardChooserDialog(this, map, cardImagePanels);
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardChooserDialog.setVisible(true);
            }
        });
        jMenu.add(jMenuItem);
        jMenuBar.add(jMenu);
        jFrame.setJMenuBar(jMenuBar);
    }
}
