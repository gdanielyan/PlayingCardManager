package components.listeners;

import cards.SuitFaceMap;
import components.dialogs.CardChooserDialog;
import components.panels.CardChooserPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class ChooseMenuItemListener implements ActionListener {

    private CardChooserPanel cardChooserPanel;
    private SuitFaceMap map;

    public ChooseMenuItemListener(CardChooserPanel cardChooserPanel, SuitFaceMap suitFaceMap) {
        this.cardChooserPanel = cardChooserPanel;
        this.map = suitFaceMap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardChooserDialog cardChooserDialog = new CardChooserDialog(cardChooserPanel, map);
        cardChooserDialog.setVisible(true);
    }
}
