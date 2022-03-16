package Bunco_plus;

import Framework.*;

import javax.imageio.stream.ImageInputStream;
import java.util.Iterator;
import java.util.Scanner;

public class Jeu_bunco extends Jeu implements IStrategie {

    private final int nb_tours = 6;
    private int actual_tour;
    private CollectionJoueur collection_joueur;
    //private CollectionDes collectionDes;
    int score_changed = 0;

    @Override
    public void creation_joueur() {
        System.out.println("Combien de joueur pour cette partie : ");
        Scanner scanner = new Scanner(System.in);
        int nbJoueur = scanner.nextInt();

        super.collectionJoueurs = new CollectionJoueur();
        for (int i=0; i< nbJoueur; i++){
            CollectionDes des = new CollectionDes(3,6);
            Joueur j = new Joueur(des);
            j.setId(i);
            super.collectionJoueurs.ajouterJoueur(j);
        }
        super.actual_joueur = super.collectionJoueurs.get(super.index_joueur);
    }

    @Override
    public void creation_des() {

    }

    public boolean calculerScoreTour(){
        int score=super.actual_joueur.getScore();
        Joueur joueur = super.actual_joueur;
        int des_gagnants=0;
        super.score_changed =0;
        int des_pareils=0;
        int actual_face_first = joueur.getCollection_des().get(0).getActual_face();
        boolean lancer = false;
        for(Iterator<De> j = joueur.getCollection_des().getDes_collection().iterator(); j.hasNext();) {
            De de = j.next();

            if(de.getActual_face()==super.actual_lancer){
                score+=1;
                des_gagnants+=1;
                super.score_changed+=1;
                lancer=true;
            }
            if(de.getActual_face()==actual_face_first){
                des_pareils+=1;
            }
            if(des_gagnants==joueur.getCollection_des().getDes_collection().size() && de.getActual_face()==super.actual_lancer){
                score+=21;
                super.score_changed+=21;
                lancer=false;
            }
            if(des_gagnants==joueur.getCollection_des().getDes_collection().size() && de.getActual_face()!=super.actual_lancer){
                score+=5;
                super.score_changed+=5;
                lancer=true;
            }

            super.actual_joueur.setScore(score);
        }
        return lancer;
    }

    public CollectionJoueur calculerLeVainqueur(){
        //TODO --> retourne les joueurs tries selon l'ordre croissant des scores
        for (int i = 0; i < super.collectionJoueurs.size()-1; i++){
            int min = i;
            for (int j = i+1; j < super.collectionJoueurs.size(); j++){
                if (super.collectionJoueurs.get(j).compareTo(super.collectionJoueurs.get(min)) == -1){
                    min = j;
                }
            }
            if (i != min){
                Joueur temp = new Joueur();
                    temp.setName(super.collectionJoueurs.get(i).getName());
                    temp.setScore(super.collectionJoueurs.get(i).getScore());
                    temp.setId(super.collectionJoueurs.get(i).getId());


                super.collectionJoueurs.get(i).setName(super.collectionJoueurs.get(min).getName());
                super.collectionJoueurs.get(i).setScore(super.collectionJoueurs.get(min).getScore());
                super.collectionJoueurs.get(i).setId(super.collectionJoueurs.get(min).getId());

                super.collectionJoueurs.get(min).setName(temp.getName());
                super.collectionJoueurs.get(min).setScore(temp.getScore());
                super.collectionJoueurs.get(min).setId(temp.getId());
            }
        }
        //pour afficher le resultat dans la console

        for (int k = 0; k< super.collectionJoueurs.size(); k++){
            System.out.println("Joueur " +super.collectionJoueurs.get(k).getId() + " avec " + super.collectionJoueurs.get(k).getScore() + " points");
        }
        System.out.println("Le gagnant est le joueur " +super.collectionJoueurs.get(0).getId()  + " avec " + super.collectionJoueurs.get(0).getScore() + " points");

        return collection_joueur;
    }

    public CollectionJoueur getCollection_joueur() {
        return collection_joueur;
    }

    public void setCollection_joueur(CollectionJoueur collection_joueur) {
        this.collection_joueur = collection_joueur;
    }

}
