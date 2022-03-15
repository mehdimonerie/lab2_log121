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
        int des_pareils=0;
        int actual_face_first = joueur.getListe_des().get(0).getActual_face();
        for (Iterator<De> j = joueur.getListe_des().getDes_collection().iterator(); j.hasNext();) {
            De de = j.next();

            if(de.getActual_face()==actual_tour){
                score+=1;
                des_gagnants+=1;
                score_changed+=1;
            }
            if(de.getActual_face()==actual_face_first){
                des_pareils+=1;
            }
            if(des_gagnants==super.getNbDes() && de.getActual_face()==actual_tour){
                score+=21;
                score_changed+=21;
            }
            if(des_gagnants==super.getNbDes() && de.getActual_face()!=actual_tour){
                score+=5;
                score_changed+=5;
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
