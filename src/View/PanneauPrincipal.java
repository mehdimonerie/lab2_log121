package View;

import Framework.Jeu;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanneauPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	private Jeu jeu;

	// Variables temporaires de la demonstration:
	private int x;
	private int y;
	private String path;
	private Point position = new Point(0,0);
	private Point vitesse = new Point(1,1);
	private int taille = 100;


	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Image image1 = null;
		try {
			image1 = ImageIO.read(new File("src/ressources/1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(image1,10, 10, taille,taille, this);

		Image image2 = null;
		try {
			image2 = ImageIO.read(new File("src/ressources/2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(image2,110, 10, taille,taille, this);

		Image image3 = null;
		try {
			image3 = ImageIO.read(new File("src/ressources/3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(image3,210, 10, taille,taille, this);

	}

	public void setJeu(Jeu jeu_) {
		jeu=jeu_;
	}

}