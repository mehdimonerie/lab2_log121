package Framework;

import java.util.Collection;
import java.util.Iterator;

public abstract class  Jeu {
    int nb_tours;
    int nbJoueurs;
    int nbDes;
    int nbFaceDe;
    int actual_tour;
    Joueur actual_joueur;
    Joueur first_joueur;

    CollectionJoueur collectionJoueurs;

    IStrategie typeDeJeu;

    public Jeu(){
        creation_joueur();
        creation_des();
    }

    public Jeu(CollectionJoueur col){
        this.collectionJoueurs =col;
    }

    public void jouerTour(){
        while (actual_tour != nb_tours) {
            System.out.printf("++++++++++++ Tour "+actual_tour+ " ++++++++++++++");
            actual_joueur.lancer_des();
            calculerScoreTour();
            while (actual_joueur.getId() != first_joueur.getId()){

            }

        }
        calculerLeVainqueur();
    }

    public abstract void creation_joueur();

    public abstract void creation_des();


    public abstract void calculerScoreTour();

    public abstract CollectionJoueur calculerLeVainqueur();

}
