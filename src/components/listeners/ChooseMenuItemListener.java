package components.listeners;

import cards.SuitFaceMap;
import components.dialogs.CardChooserDialog;
import components.panels.CardChooserPanel;
import components.panels.CardImagePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class ChooseMenuItemListener implements ActionListener {

    private CardImagePanel[] cardImagePanels;
    private CardChooserPanel cardChooserPanel;
    private SuitFaceMap map;

    public ChooseMenuItemListener(CardChooserPanel cardChooserPanel, SuitFaceMap suitFaceMap, CardImagePanel[] cardImagePanels) {
        this.cardImagePanels = cardImagePanels;
        this.cardChooserPanel = cardChooserPanel;
        this.map = suitFaceMap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardChooserDialog cardChooserDialog = new CardChooserDialog(cardChooserPanel, map, cardImagePanels);
        cardChooserDialog.setVisible(true);
    }
}
