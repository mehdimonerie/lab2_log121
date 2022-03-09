package Bunco_plus;

import Framework.CollectionDes;
import Framework.CollectionJoueur;
import Framework.Jeu;
import Framework.Joueur;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class Jeu_bunco extends Jeu {

    private final int nb_tours = 6;
    private final int score_gagnant = 21;
    private int actual_tour= 0;
    private int nb_joueurs = 3;
    private CollectionJoueur collection_joueur;
    private CollectionDes collectionDes;

    public Jeu_bunco(){
        super();
    }



    public int getActual_tour() {
        return actual_tour;
    }

    public void setActual_tour(int actual_tour) {
        this.actual_tour = actual_tour;
    }

    public int getNb_joueurs() {
        return nb_joueurs;
    }

    public void setNb_joueurs(int nb_joueurs) {
        this.nb_joueurs = nb_joueurs;
    }



    public void calculerScoreTour(){
        /*TODO --> cumule le score du joueur de ce tour avec celui du tour precedent
            et decide s'il faut passer la main au prochain joueur ou non
        */


    }
    public void calculerLeVainqueur(){
        //TODO --> retourne les joueurs tries selon l'ordre croissant des scores

        for (int i = 0; i < this.collection_joueur.size() - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < this.collection_joueur.size(); j++)
            {
                if (this.collection_joueur.get(j).compareTo(this.collection_joueur.get(index)) == -1){
                    index = j;
                }
            }

            Joueur min = this.collection_joueur.get(index);
            //this.collection_joueur.get(index) = this.collection_joueur.get(i);
            //this.collection_joueur.get(i) = min;
        }
        /*for (int i=0; i < this.collection_joueur.size()-1; i++){
            this.collection_joueur.get(i).compareTo(this.collection_joueur.get(i+1));
        }

         */
    }




}
