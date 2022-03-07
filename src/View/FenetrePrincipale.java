package View;

import Framework.Jeu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FenetrePrincipale extends JFrame implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private static final String TITRE_FENETRE = "Laboratoire 2 : LOG121 - Brunco+";
	private static final Dimension DIMENSION = new Dimension(700, 700);
	private Jeu jeu = null;
	private String jeu_choisi =null;

	PanneauPrincipal panneauPrincipal;
	PanneauMenu panneauMenu;
	public FenetrePrincipale() {
		panneauPrincipal = new PanneauPrincipal();
		panneauMenu = new PanneauMenu();

		MenuFenetre menuFenetre = new MenuFenetre();
		add(panneauMenu);
		panneauMenu.buttonJeu1.addActionListener((ActionEvent e) -> {
			this.jeu_choisi = panneauMenu.buttonJeu1.getText();
			System.out.println(this.jeu_choisi);
			panneauMenu.setVisible(false);
			add(panneauPrincipal);
		});
		add(menuFenetre, BorderLayout.NORTH);
		// Faire en sorte que le X de la fen�tre ferme la fen�tre
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(TITRE_FENETRE);
		setSize(DIMENSION);
		// Rendre la fen�tre visible
		setVisible(true);
		// Mettre la fen�tre au centre de l'�cran
		setLocationRelativeTo(null);
		// Emp�cher la redimension de la fen�tre
		setResizable(false);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		if (evt.getPropertyName().equals("model")) {
			repaint();
			jeu = (Jeu) evt.getNewValue();
			panneauPrincipal.setJeu(jeu);
		}
	}

}
