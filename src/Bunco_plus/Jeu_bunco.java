package Bunco_plus;

import Framework.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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

    @Override
    public int calculerScoreTour() {
        int score=super.getCollectionJoueurs().get(super.getActual_joueur()).getScore();
        Joueur joueur = super.getCollectionJoueurs().get(super.getActual_joueur());
        int des_gagnants=0;
        int score_changed = 0;

        for (Iterator<De> j = joueur.getListe_des().getDes_collection().iterator(); j.hasNext();) {
            De de = j.next();

            if(de.getActual_face()==actual_tour){
                score+=1;
                des_gagnants+=1;
                score_changed+=1;
            }
            if(des_gagnants==super.getNbDes()){
                score+=21;
                score_changed+=1;
            }
            super.getCollectionJoueurs().get(super.getActual_joueur()).setScore(score);
        }
        System.out.println("super.getCollectionJoueurs().get(super.getActual_joueur()).toString() : "+super.getCollectionJoueurs().get(super.getActual_joueur()).toString());


        if(score_changed==0 && actual_tour !=1){
            System.out.println("zéro");
            //prochainJoueur();
            return score_changed;
        }
        else{
            return score_changed;
        }

    }

    public boolean prochainJoueur(){
        actual_tour=0;
        super.setActual_joueur(super.getActual_joueur()+1);
        int actual_joueur = super.getActual_joueur();
        if(actual_joueur==super.getCollectionJoueurs().size()){
            return false;
        }
        else{
            return true;
        }

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

    public void calculerScoreTour(Joueur actual_joueur) {
        /*TODO --> cumule le score du joueur de ce tour avec celui du tour precedent
            et decide s'il faut passer la main au prochain joueur ou non
        */


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
        return collection_joueur;
    }

    @Override
    public void nouveauTour() {
        actual_tour=actual_tour+1;
        if(actual_tour==7 ){
            actual_tour=1;
        }

        rollDices();
    }

    public CollectionJoueur getCollection_joueur() {
        return collection_joueur;
    }

    public void setCollection_joueur(CollectionJoueur collection_joueur) {
        this.collection_joueur = collection_joueur;
    }

    public CollectionDes getCollectionDes() {
        return collectionDes;
    }

    public void setCollectionDes(CollectionDes collectionDes) {
        this.collectionDes = collectionDes;
    }

    public int getActual_tour(){
        return actual_tour;
    }

    public void log_jeu(){
        for(int i=0;i<super.getCollectionJoueurs().size();i++){
            String log = super.getCollectionJoueurs().get(i).toString();
            //System.out.println(log);
        }
        System.out.println("Tour : "+getActual_tour());
    }
}
