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

    public CardChooserDialog(CardChooserPanel cardChooserPanel, SuitFaceMap map, CardImagePanel[] cardImagePanels) {
        super();
        this.map = map;
        this.cardChooserPanel = cardChooserPanel;
        setSize(500,500);
        setLocationRelativeTo(null);
        this.add(new DialogContentPane(this, cardImagePanels));
    }

    private class ControlPanel extends JPanel {
        public ControlPanel() {
            super(true);
            GridBagLayout layout = new GridBagLayout();
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            controls = new CardChooserControlPanel[numCards];
            this.setLayout(layout);
            CardChooserControlPanel cardChooserControlPanel;
            for(int i = 0; i < controls.length; i++) {
                cardChooserControlPanel = new CardChooserControlPanel();
                controls[i] = cardChooserControlPanel;
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = i;
                this.add(controls[i], gridBagConstraints);
            }
        }
    }

    private class ButtonPane extends JPanel {
        CardChooserDialog dialog;
        CardImagePanel[] cardImagePanels;
        public ButtonPane(CardChooserDialog dialog, CardImagePanel[] cardImagePanels) {
            super(true);
            setBorder(BorderFactory.createEtchedBorder());
            this.dialog = dialog;
            this.cardImagePanels = cardImagePanels;
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
                    for(int i = 0; i < numCards; i++) {
                        controls[i].saveDisplayedCard();
                        cardImagePanels[i].setBufferedImage(map.getValue(controls[i].getDisplayedCard()));
                        cardImagePanels[i].revalidate();
                        cardImagePanels[i].repaint();
                        cardChooserPanel.setComponentZOrder(cardImagePanels[i], 0);
                        cardChooserPanel.revalidate();
                        cardChooserPanel.repaint();
                    }
                    dialog.setVisible(false);
                }

            });
            btnCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(int i = 0; i < numCards; i++) {
                        if(controls[i].getSavedCard() != null) {
                            controls[i].restoreDisplayedCard();
                        }
                    }
                    dispose();
                }
            });
        }

    }

    private class DialogContentPane extends JPanel {
        public DialogContentPane(CardChooserDialog dialog, CardImagePanel[] cardImagePanels) {
            super(true);
            setLayout(new BorderLayout());
            add(new ControlPanel(), BorderLayout.CENTER);
            add(new ButtonPane(dialog, cardImagePanels), BorderLayout.SOUTH);
        }
    }

    public CardChooserControlPanel[] getControls() {
        return controls;
    }
}
