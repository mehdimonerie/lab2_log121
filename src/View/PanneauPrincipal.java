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
	boolean started = false;
	// Variables temporaires de la demonstration:
	private int x_debut=10;
	private int y_debut=30;
	private String path;
	private Point position = new Point(0,0);
	private Point vitesse = new Point(1,1);
	private int taille = 75;
	JLabel heading;
	JLabel tour;
	JLabel joueur_actuel;
	JPanel labelsPanel;
	JButton tour_button;
	ArrayList<JLabel> score_panel = new ArrayList<JLabel>();
	JLabel info_tour;
	String info_tour_string;
	boolean lost=false;

	public PanneauPrincipal(){

		this.setLayout(null);
		this.setAlignmentX(Component.RIGHT_ALIGNMENT);

		labelsPanel = new JPanel();
		labelsPanel.setBackground(Color.CYAN);
		GridLayout grid_layout = new GridLayout(0,1);
		labelsPanel.setLayout(grid_layout);

		labelsPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		labelsPanel.setBounds(300,0,350,200);

		add(labelsPanel);
	}

	@Override
	public void paint(Graphics g) {
		if(started==false){
			startButton(g);
		}
		else if(jeu.getActual_tour()==0) {
			super.paint(g);
			infoPanel();
			infoLoop();

			//Calculer score du joueur, et déterminer si c'est au tour du prochain joueur
			//Dernier tour
			//jeu.calculerLeVainqueur();
		}
		else if(jeu.getActual_tour()!=0){
			super.paint(g);
			infoPanel();
			drawDiceLine(g);

			infoLoop();
		}
	}

	public void startButton(Graphics g){
		labelsPanel.removeAll();
		//infoPanel();
		//infoLoop();
		JButton start_button  = new JButton("Start");

		start_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				started=true;
			}
		});

		labelsPanel.add(start_button);

		labelsPanel.validate();

	}

	public void infoPanel(){
		heading  = new JLabel("Score",SwingConstants.RIGHT);
		heading.setBorder(new EmptyBorder(10, 10, 10, 10));
		joueur_actuel  = new JLabel("Joueur actuel "+jeu.getActual_joueur(),SwingConstants.RIGHT);
		joueur_actuel.setBorder(new EmptyBorder(10, 10, 10, 10));
		tour = new JLabel("Tour "+jeu.getActual_tour(),SwingConstants.RIGHT);
		tour.setBorder(new EmptyBorder(10, 10, 10, 10));
		tour_button  = new JButton("Lancer les dés");
		info_tour = new JLabel("Veuillez lancer les dés");

		tour_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Avant");
                jeu.log_jeu();
				int score = 0;
				System.out.println("lost : "+lost);

				if(lost==false && jeu.getActual_tour()!=0){
					score = jeu.calculerScoreTour();
				}

				System.out.println(score);
				if(jeu.getActual_tour()==0 && score==0) {
					System.out.println("cond. 1");
					jeu.nouveauTour();
					score = jeu.calculerScoreTour();
					if (score == 0) {
						System.out.println("cond. 1.3");
						info_tour_string = "Joueur " + jeu.getActual_joueur() + " a perdu le tour, prochain joueur";
						lost = true;
					} else if (score != 0) {
						System.out.println("cond. 1.4");
						info_tour_string = "Joueur " + jeu.getActual_joueur() + " a gagné " + score + " point(s)";
						lost = false;
					}
				}
				else if(lost==true){
					boolean is_prochain_joueur = jeu.prochainJoueur();
					System.out.println("is_prochain_joueur : "+is_prochain_joueur);
					if(is_prochain_joueur==false){
						jeu.getWinner();
						info_tour_string=(jeu.getWinner());
					}
					else{
						info_tour_string = "Joueur " + jeu.getActual_joueur() + " prêt ";
					}
					lost=false;
				}
				else if(jeu.getActual_tour()==6 && score!=0) {
					System.out.println("cond. 2");
					boolean is_prochain_joueur = jeu.prochainJoueur();
					System.out.println("is_prochain_joueur : "+is_prochain_joueur);
					if(is_prochain_joueur==false){
						jeu.getWinner();
						info_tour_string=(jeu.getWinner());
					}
					else{
						info_tour_string = "Joueur " + jeu.getActual_joueur() + " prêt ";
					}
					lost = false;
				}
				else if(jeu.getActual_tour()!=0 && score==0){
					System.out.println("cond. 3");
					info_tour_string = "Joueur "+jeu.getActual_joueur()+" a perdu le tour, prochain joueur";
					lost=true;
				}
				else if(jeu.getActual_tour()!=0 && score!=0){
					System.out.println("cond. 4");
					info_tour_string = "Joueur "+jeu.getActual_joueur()+" a gagné "+score+" point(s)";
					jeu.nouveauTour();
					lost=false;
				}

				System.out.println("Après");
				jeu.log_jeu();
				System.out.println("######################");


			}

		});

		labelsPanel.add(tour);
		labelsPanel.add(tour_button);
		labelsPanel.add(heading);
		labelsPanel.add(joueur_actuel);
		labelsPanel.add(info_tour);

		labelsPanel.validate();

	}

	public void infoLoop(){
		if(score_panel.size() == 0 && labelsPanel != null) {
			for (int i = 0; i < jeu.getCollectionJoueurs().size(); i++) {
				int score = jeu.getCollectionJoueurs().get(i).getScore();
				JLabel score_joueur = new JLabel("Joueur "+jeu.getCollectionJoueurs().get(i).getId()+" : "+score, SwingConstants.RIGHT);
				score_joueur.setBorder(new EmptyBorder(10, 10, 10, 10));
				score_panel.add(score_joueur);

			}
			for (int i =0; i <score_panel.size(); i++) {
				labelsPanel.add(score_panel.get(i));
			}
			info_tour.setText(info_tour_string);
			labelsPanel.add(info_tour);
			labelsPanel.validate();
		}
		else if(labelsPanel != null){
			labelsPanel.removeAll();
			labelsPanel.validate();
			infoPanel();
			score_panel.clear();
			for (int i = 0; i < jeu.getCollectionJoueurs().size(); i++) {

				int score = jeu.getCollectionJoueurs().get(i).getScore();
				JLabel score_joueur = new JLabel("Joueur "+i+" : "+score, SwingConstants.RIGHT);
				score_joueur.setBorder(new EmptyBorder(10, 10, 10, 10));
				score_panel.add(score_joueur);
			}
			for (int i =0; i <score_panel.size(); i++) {
				labelsPanel.add(score_panel.get(i));
			}
			labelsPanel.add(info_tour);
			info_tour.setText(info_tour_string);
			labelsPanel.add(info_tour);
			labelsPanel.validate();
		}

	}

	public Graphics drawDiceLine(Graphics g){
		int x = this.x_debut;
		int y = this.y_debut;
		int actual_joueur = jeu.getActual_joueur();
		int size=jeu.getCollectionJoueurs().get(actual_joueur).getListe_des().getDes_collection().size();

		for(int j=0;j<size;j++){
			Image image = null;
			try {
				path = switchPath(jeu.getCollectionJoueurs().get(actual_joueur).getListe_des().get(j).getActual_face());
				image = ImageIO.read(new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g.drawImage(image,x, y, taille,taille, this);
			x=x+this.taille+20;
		}
		y=y+taille+20;
		x= this.x_debut;

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