package View;

import Framework.Jeu;
import Framework.Joueur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PanneauPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	private Jeu jeu;

	// Variables temporaires de la demonstration:
	private int x_debut=10;
	private int y_debut=30;
	private String path;
	private Point position = new Point(0,0);
	private Point vitesse = new Point(1,1);
	private int taille = 75;
	JLabel heading;
	JLabel tour;
	JPanel labelsPanel;
	JButton tour_button;
	ArrayList<JLabel> score_panel = new ArrayList<JLabel>();


	public PanneauPrincipal(){

		this.setLayout(null);
		this.setAlignmentX(Component.RIGHT_ALIGNMENT);

		labelsPanel = new JPanel();
		labelsPanel.setBackground(Color.CYAN);
		GridLayout grid_layout = new GridLayout(0,1);
		labelsPanel.setLayout(grid_layout);

		labelsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		labelsPanel.setBounds(600,0,100,200);

		add(labelsPanel);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		jeu.log_jeu();
		infoPanel();
		drawDiceLine(g);
		infoLoop();

	}

	public void infoPanel(){
		heading  = new JLabel("Score",SwingConstants.RIGHT);
		heading.setBorder(new EmptyBorder(10, 10, 10, 10));
		tour = new JLabel("Tour "+jeu.get_tour(),SwingConstants.RIGHT);
		tour.setBorder(new EmptyBorder(10, 10, 10, 10));
		tour_button  = new JButton("Prochain tour");

		tour_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				jeu.nouveauTour();
			}
		});

		labelsPanel.add(tour);
		labelsPanel.add(tour_button);
		labelsPanel.add(heading);

		labelsPanel.validate();

	}

	public void infoLoop(){
		if(score_panel.size() == 0 && labelsPanel != null) {
			for (int i = 0; i < jeu.getCollectionJoueurs().size(); i++) {
				int score = jeu.getCollectionJoueurs().get(i).getScore();
				JLabel score_joueur = new JLabel("Joueur "+i+" : "+score, SwingConstants.RIGHT);
				score_joueur.setBorder(new EmptyBorder(10, 10, 10, 10));
				score_panel.add(score_joueur);
			}
			for (int i =0; i <score_panel.size(); i++) {
				labelsPanel.add(score_panel.get(i));
				labelsPanel.validate();
			}
		}
		else if(labelsPanel != null){
			labelsPanel.removeAll();
			labelsPanel.validate();
			infoPanel();
			for (int i =0; i <score_panel.size(); i++) {
				labelsPanel.add(score_panel.get(i));
				labelsPanel.validate();
			}
		}

	}

	public Graphics drawDiceLine(Graphics g){
		int x = this.x_debut;
		int y = this.y_debut;
		for(int i=0;i<jeu.getCollectionJoueurs().size();i++){
			int size=jeu.getCollectionJoueurs().get(i).getListe_des().getDes_collection().size();
			for(int j=0;j<size;j++){
				Image image = null;
				try {
					path = switchPath(jeu.getCollectionJoueurs().get(i).getListe_des().get(j).getActual_face());
					image = ImageIO.read(new File(path));
				} catch (IOException e) {
					e.printStackTrace();
				}
				g.drawImage(image,x, y, taille,taille, this);
				x=x+this.taille+20;
			}
			y=y+taille+20;
			x= this.x_debut;
		}
		return g;
	}

	public String switchPath(int actual_face){

		String path = null;
		switch (actual_face) {
			case 1:
				path = "src/ressources/1.png";
				break;
			case 2:
				path = "src/ressources/2.png";
				break;
			case 3:
				path = "src/ressources/3.png";
				break;
			case 4:
				path = "src/ressources/4.png";
				break;
			case 5:
				path = "src/ressources/5.png";
				break;
			case 6:
				path = "src/ressources/6.png";
				break;
		}
		return path;
	}


	public void setJeu(Jeu jeu_) {
		jeu=jeu_;
	}

}