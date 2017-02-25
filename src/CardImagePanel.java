import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CardImagePanel extends JPanel{

    private BufferedImage bufferedImage;

    public CardImagePanel() {
        super();
    }

    public CardImagePanel(BufferedImage bufferedImage) {
        super(true);
        this.bufferedImage = bufferedImage;
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
            g.drawImage(getBufferedImage(), 0, 0, bufferedImage.getWidth()/2, bufferedImage.getHeight()/2, null);
        }
    }

    public Dimension getPreferredSize() {
        if (bufferedImage!=null)
            return new Dimension(bufferedImage.getWidth(),bufferedImage.getHeight());
        else
            return new Dimension(0,0);

    }
}
