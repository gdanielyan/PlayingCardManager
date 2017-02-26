package components;

import components.panels.CardImagePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class CardChooserButton extends JButton {

    private JFileChooser cardChooserDialog;
    private CardImagePanel cardImagePanel;
    private JFrame jFrame;

    public CardChooserButton(String label, JPanel parentPanel, JPanel cardImagePanel, JFrame jFrame) {
        super(label);
        this.jFrame = jFrame;
        this.cardImagePanel = (CardImagePanel) cardImagePanel;
        this.addActionListener(new ButtonListener(parentPanel));
    }

    private class ButtonListener implements ActionListener {

        private File file;
        private JPanel jParentPanel;

        public ButtonListener(JPanel parentPanel) {
            this.jParentPanel = parentPanel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            cardChooserDialog = new CardFileChooserDialog();
            int success = cardChooserDialog.showOpenDialog(jParentPanel);
            try {
                if(success == 0) {
                    file = cardChooserDialog.getSelectedFile();
                    cardImagePanel.setBufferedImage(ImageIO.read(file));
                    cardImagePanel.revalidate();
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
