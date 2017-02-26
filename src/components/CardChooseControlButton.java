package components;

import cards.SuitFaceMap;
import components.panels.CardChooserControlPanel;
import components.panels.CardImagePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 *
 */
public class CardChooseControlButton extends JButton{

    private CardChooserControlPanel cardChooserControlPanel;
    private CardImagePanel cardImagePanel;
    private SuitFaceMap map;

    public CardChooseControlButton(String label, CardChooserControlPanel cardChooserControlPanel, CardImagePanel cardImagePanel, SuitFaceMap map) {
        super(label);
        this.cardChooserControlPanel = cardChooserControlPanel;
        this.cardImagePanel = cardImagePanel;
        this.map = map;
        this.addActionListener(new CardChooseControlButton.ButtonListener());
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            cardImagePanel.setBufferedImage(map.getValue(cardChooserControlPanel.getDisplayedCard()));
            cardImagePanel.revalidate();
            cardImagePanel.repaint();
        }
    }
}
