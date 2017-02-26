package cards;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class SuitFaceMap {

    private HashMap<SuitFace, BufferedImage> map;
    private String cardDirectoryName = System.getProperty("user.dir") + "/resources/cards/";
    private double imageScaleFactor = 0.5;

    public SuitFaceMap() {
        map = new HashMap<SuitFace, BufferedImage>();
        loadCardImages();
    }

    private void loadCardImages() {
        File dir = new File(cardDirectoryName);
        File[] files = dir.listFiles();

        for(File file : files) {
            try {
                BufferedImage img = ImageIO.read(file);
                SuitFace suitFace = parseSuitFace(file.getName());
                if(suitFace != null) {
                    map.put(suitFace, scale(img, imageScaleFactor));
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    private SuitFace parseSuitFace(String str) {
        String[] split = str.split("_|\\.");
        if(!split[2].equals("Store")) {
            return new SuitFace(Suit.valueOf(split[2].toUpperCase()), Face.valueOf(split[0].toUpperCase()));
        }
        return null;
    }

    public BufferedImage scale(BufferedImage img, double imageScaleFactor) {
        int width = (int) (img.getWidth() * imageScaleFactor);
        int height = (int) (img.getHeight() * imageScaleFactor);
        int type = 0;

        type = img.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : img.getType();
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(img, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }

    public BufferedImage getValue(SuitFace suitface) {
        return map.get(suitface);
    }

}
