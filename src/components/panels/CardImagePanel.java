package components.panels;

import components.listeners.CardMoverListener;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CardImagePanel extends JPanel{

    private BufferedImage bufferedImage;
    private CardMoverListener cardMover;

    public CardImagePanel() {
        super();
        this.cardMover = new CardMoverListener(this);
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(bufferedImage != null){
            g.drawImage(getBufferedImage(), 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);
        }
    }

    public Dimension getPreferredSize() {
        if (bufferedImage!=null)
            return new Dimension(bufferedImage.getWidth(),bufferedImage.getHeight());
        else
            return new Dimension(0,0);

    }
}
