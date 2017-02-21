import javax.swing.*;
import java.awt.image.BufferedImage;

public class CardImagePanel extends JPanel{

    private BufferedImage bufferedImage;

    public CardImagePanel() {
        super();
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
}
