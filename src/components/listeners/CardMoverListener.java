package components.listeners;

import components.panels.CardImagePanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 */
public class CardMoverListener extends MouseAdapter {

    private CardImagePanel cardImagePanel;
    private int startX;
    private int startY;


    public CardMoverListener(CardImagePanel panel){
        this.cardImagePanel = panel;
        this.cardImagePanel.addMouseListener(this);
        this.cardImagePanel.addMouseMotionListener(this);
    }

    public void mousePressed(MouseEvent e) {
        this.startX = e.getX();
        this.startY = e.getY();
    }

    public void mouseDragged(MouseEvent e) {
        this.cardImagePanel.setLocation(cardImagePanel.getX() + (e.getX()-startX), cardImagePanel.getY() + (e.getY()-startY));
    }

}
