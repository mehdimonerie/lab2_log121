package Framework;

import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public abstract class  Jeu {
    int nb_tours;
    int nbJoueurs;
    int nbDes;
    int nbFaceDe;
    int actual_tour=1;
    public int index_joueur=0;
    public int actual_lancer=1;
    public int score_changed=0;
    public Joueur actual_joueur;
    public CollectionJoueur collectionJoueurs;

    public Jeu(){
        creation_joueur();
        creation_des();
    }

    public Jeu(CollectionJoueur col){
        this.collectionJoueurs =col;
    }

    public void jouerTour(){

        while(actual_tour<=6) {
            while(index_joueur<3) {
                actual_joueur = collectionJoueurs.get(index_joueur);
                actual_lancer = 1;
                System.out.println("++++++++++++ Tour " + actual_tour + ", Joueur "+index_joueur+", Lancer "+actual_lancer+" ++++++++++++++");
                while (actual_lancer < 7) {
                    actual_joueur.lancer_des();
                    boolean tour_gagne = calculerScoreTour();
                    System.out.println(actual_joueur.toString());
                    if (tour_gagne == true) {
                        System.out.println("Score du lancer : " + score_changed);
                        System.out.println("Lancer les dés en pesant sur enter : ");
                        Scanner scanner = new Scanner(System.in);
                        scanner.nextLine();
                        actual_lancer += 1;
                    } else {
                        System.out.println("Score du lancer : " + score_changed);
                        System.out.println("C'est le tour du prochain joueur, presser enter");
                        Scanner scanner = new Scanner(System.in);
                        scanner.nextLine();
                        actual_lancer = 7;
                    }
                }
                index_joueur+=1;
            }
            index_joueur=0;
            actual_tour+=1;
        }
        calculerLeVainqueur();
    }

    public abstract void creation_joueur();

    public abstract void creation_des();

    public abstract boolean calculerScoreTour();

    public abstract CollectionJoueur calculerLeVainqueur();


}
