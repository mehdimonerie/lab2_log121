package Bunco_plus;

import Framework.*;

import javax.imageio.stream.ImageInputStream;
import java.util.Iterator;
import java.util.Scanner;

public class Jeu_bunco extends Jeu implements IStrategie {

    private final int nb_tours = 6;
    private int actual_tour;
    private CollectionJoueur collection_joueur;
    private Joueur actual_joueur;
    //private CollectionDes collectionDes;

    @Override
    public void creation_joueur() {
        /*System.out.println("combien de joueur pour cette partie : ");
        Scanner scanner = new Scanner(System.in);
        int nbJoueur = scanner.nextInt();*/
        int nbJoueur = 3;

        collection_joueur = new CollectionJoueur();
        for (int i=0; i< nbJoueur; i++){
            CollectionDes des = new CollectionDes(3,6);
            Joueur j = new Joueur(des);
            this.collection_joueur.ajouterJoueur(j);
        }

        this.actual_joueur = collection_joueur.get(0);

    }

    @Override
    public void creation_des() {

    }

    public boolean calculerScoreTour(){
        /*TODO --> cumule le score du joueur de ce tour avec celui du tour precedent
            et decide s'il faut passer la main au prochain joueur ou non
        */
        return true;
    }

    public CollectionJoueur calculerLeVainqueur(){
        //TODO --> retourne les joueurs tries selon l'ordre croissant des scores
        for (int i = 0; i < collection_joueur.size()-1; i++){
            int min = i;
            for (int j = i+1; j < collection_joueur.size(); j++){
                if (collection_joueur.get(j).compareTo(collection_joueur.get(min)) == -1){
                    min = j;
                }
            }
            if (i != min){
                Joueur temp = new Joueur();
                    temp.setName(collection_joueur.get(i).getName());
                    temp.setScore(collection_joueur.get(i).getScore());
                    temp.setId(collection_joueur.get(i).getId());


                collection_joueur.get(i).setName(collection_joueur.get(min).getName());
                collection_joueur.get(i).setScore(collection_joueur.get(min).getScore());
                collection_joueur.get(i).setId(collection_joueur.get(min).getId());

                collection_joueur.get(min).setName(temp.getName());
                collection_joueur.get(min).setScore(temp.getScore());
                collection_joueur.get(min).setId(temp.getId());
            }
        }
        /* pour afficher le resultat dans la console


        for (int k = 0; k< collection_joueur.size(); k++){
            System.out.println("n° " + k + " : " +collection_joueur.get(k).getName()
                    + " avec " + collection_joueur.get(k).getScore() + " points");
        }

        */

        return collection_joueur;
    }

    public CollectionJoueur getCollection_joueur() {
        return collection_joueur;
    }

    public void setCollection_joueur(CollectionJoueur collection_joueur) {
        this.collection_joueur = collection_joueur;
    }

}
