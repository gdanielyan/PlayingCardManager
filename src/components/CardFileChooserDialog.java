package components;

import javax.swing.*;
import java.io.File;

public class CardFileChooserDialog extends JFileChooser {

    public CardFileChooserDialog() {
        setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        setCurrentDirectory(new File(System.getProperty("user.dir") + "/resources/cards/"));
    }
}
