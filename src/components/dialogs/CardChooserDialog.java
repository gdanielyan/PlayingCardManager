package components.dialogs;

import cards.SuitFaceMap;
import components.panels.CardChooserControlPanel;
import components.panels.CardChooserPanel;
import components.panels.CardImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CardChooserDialog extends JDialog {

    private JButton btnOk;
    private JButton btnCancel;
    private CardChooserControlPanel[] controls;
    private CardChooserPanel cardChooserPanel;
    private SuitFaceMap map;
    private int numCards = 5;

    public CardChooserDialog(CardChooserPanel cardChooserPanel, SuitFaceMap map) {
        super();
        setSize(500,500);
        setLocationRelativeTo(null);
        this.add(new DialogContentPane());
        this.cardChooserPanel = cardChooserPanel;
        this.map = map;
    }

    private class ControlPanel extends JPanel {
        public ControlPanel() {
            super(true);
            GridBagLayout layout = new GridBagLayout();
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            controls = new CardChooserControlPanel[numCards];
            this.setLayout(layout);
            for(int i = 0; i < controls.length; i++) {
                CardChooserControlPanel cardChooserControlPanel = new CardChooserControlPanel();
                controls[i] = cardChooserControlPanel;
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = i;
                this.add(controls[i], gridBagConstraints);
            }
        }
    }

    private class ButtonPane extends JPanel {
        public ButtonPane() {
            super(true);
            setBorder(BorderFactory.createEtchedBorder());
            btnOk = new JButton("Ok");
            btnCancel = new JButton("Cancel");
            bindButtons();
            this.add(btnOk);
            this.add(btnCancel);
        }

        private void bindButtons() {
            btnOk.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(CardChooserControlPanel panel : controls){
                        CardImagePanel cardImagePanel = new CardImagePanel();
                        cardChooserPanel.addComponentToPanel(cardImagePanel);
                        cardImagePanel.setBufferedImage(map.getValue(panel.getDisplayedCard()));
                        cardImagePanel.revalidate();
                        cardImagePanel.repaint();
                        dispose();
                        // need to save the card as well..
                    }
                }

            });
            btnCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
        }

    }

    private class DialogContentPane extends JPanel {
        public DialogContentPane() {
            super(true);
            setLayout(new BorderLayout());
            add(new ControlPanel(), BorderLayout.CENTER);
            add(new ButtonPane(), BorderLayout.SOUTH);
        }
    }

    public CardChooserControlPanel[] getControls() {
        return controls;
    }
}
