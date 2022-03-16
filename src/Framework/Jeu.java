package Framework;

import java.util.Collection;
import java.util.Iterator;

public abstract class  Jeu {
    int nb_tours;
    int nbJoueurs;
    int nbDes;
    int nbFaceDe;
    int actual_tour;

    CollectionJoueur collectionJoueurs;

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
            for (Iterator<Joueur> i = collectionJoueurs.getJoueur_collection().iterator(); i.hasNext(); ) {
                while (calculerScoreTour()){
                    i.next().lancer_des();
                }
            }

        }
        calculerLeVainqueur();
    }

    public abstract void creation_joueur();

    public abstract void creation_des();


    public abstract boolean calculerScoreTour();

    public abstract CollectionJoueur calculerLeVainqueur();

}
