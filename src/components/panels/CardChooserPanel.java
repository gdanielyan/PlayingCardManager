package components.panels;

import cards.SuitFaceMap;
import components.buttons.CardChooseControlButton;
import components.listeners.ChooseMenuItemListener;

import javax.swing.*;

public class CardChooserPanel extends JPanel {

    private JButton jButton;
    private static JFrame jFrame;
    private static JMenuBar jMenuBar;
    private CardImagePanel cardImagePanel;

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

        cardImagePanel = new CardImagePanel();
        cardImagePanel.setBounds(10, 50, 300, 700);

        jButton = new CardChooseControlButton("Choose", cardChooserControlPanel, cardImagePanel, map);
        jButton.setBounds(cardChooserControlPanel.getPreferredSize().width + 15, 15, jButton.getPreferredSize().width, jButton.getPreferredSize().height);

        createMenu(jFrame);

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
        jFrame.setSize(800, 800);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public void createMenu(JFrame jFrame) {
        jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Cards");
        JMenuItem jMenuItem = new JMenuItem("Choose");
        jMenuItem.addActionListener(new ChooseMenuItemListener(this, map));
        jMenu.add(jMenuItem);
        jMenuBar.add(jMenu);
        jFrame.setJMenuBar(jMenuBar);
    }
}
