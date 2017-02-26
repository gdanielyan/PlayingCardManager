package components.panels;

import cards.Face;
import cards.Suit;
import cards.SuitFace;

import javax.swing.*;

public class CardChooserControlPanel extends JPanel{

    private JComboBox<Suit> suitList;
    private JComboBox<Face> faceList;
    private SuitFace savedValue;

    public CardChooserControlPanel() {
        suitList = new JComboBox<>(Suit.values());
        faceList = new JComboBox<>(Face.values());
        add(faceList);
        add(new JLabel("of"));
        add(suitList);
    }

    public SuitFace getDisplayedCard() {
        return new SuitFace((Suit)suitList.getSelectedItem(), (Face)faceList.getSelectedItem());
    }

    public SuitFace getSavedCard() {
        return savedValue;
    }

    public void saveDisplayedCard() {
        savedValue = getDisplayedCard();
    }

    public void restoreDisplayedCard() {
        suitList.setSelectedItem(savedValue.getSuit());
        faceList.setSelectedItem(savedValue.getFace());
    }
}
