package components.listeners;

import components.panels.CardChooserPanel;
import components.panels.CardImagePanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 */
public class CardMoverListener extends MouseAdapter {

    private CardChooserPanel cardChooserPanel;
    private CardImagePanel cardImagePanel;
    private int startX;
    private int startY;


    public CardMoverListener(CardImagePanel panel, CardChooserPanel cardChooserPanel){
        this.cardImagePanel = panel;
        this.cardChooserPanel = cardChooserPanel;
        this.cardImagePanel.addMouseListener(this);
        this.cardImagePanel.addMouseMotionListener(this);
    }

    public void mousePressed(MouseEvent e) {
        this.startX = e.getX();
        this.startY = e.getY();
        this.cardChooserPanel.setComponentZOrder(this.cardImagePanel, 0);
    }

    public void mouseDragged(MouseEvent e) {
        this.cardImagePanel.setLocation(cardImagePanel.getX() + (e.getX()-startX), cardImagePanel.getY() + (e.getY()-startY));
    }

}
