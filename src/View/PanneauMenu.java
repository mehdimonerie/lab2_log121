package View;

import Framework.Jeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PanneauMenu extends JPanel {
    JButton buttonJeu1;
    JButton buttonJeu2;

    public PanneauMenu(){
        buttonJeu1 = new JButton("Bunco +");
        buttonJeu2 = new JButton("Jeu à déterminer");
        add(buttonJeu1);
        add(buttonJeu2);
    }

}
