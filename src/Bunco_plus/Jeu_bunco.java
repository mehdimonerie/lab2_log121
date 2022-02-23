package Bunco_plus;

import Framework.CollectionDes;
import Framework.CollectionJoueur;
import Framework.Jeu;
import Framework.Joueur;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class Jeu_bunco extends Jeu {

    private int nb_tours = 6;
    private int actual_tour;
    private CollectionJoueur collection_joueur;
    private CollectionDes collectionDes;

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
