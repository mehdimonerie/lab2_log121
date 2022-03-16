package Bunco_plus;

import Framework.*;

import javax.imageio.stream.ImageInputStream;
import java.util.Iterator;
import java.util.Scanner;

public class Jeu_bunco extends Jeu implements IStrategie {
    int actual_tour=1;
    public int index_joueur=0;
    public int actual_lancer=1;
    public int score_changed=0;
    public Joueur actual_joueur;
    public CollectionJoueur collectionJoueurs;
    private CollectionJoueur collection_joueur;


    @Override
    public void creation_joueur() {
        System.out.println("Combien de joueur pour cette partie : ");
        Scanner scanner = new Scanner(System.in);
        int nbJoueur = scanner.nextInt();

        collectionJoueurs = new CollectionJoueur();
        for (int i=0; i< nbJoueur; i++){
            CollectionDes des = new CollectionDes(3,6);
            Joueur j = new Joueur("Joueur"+ 1,i,des);
            j.setId(i);
            collectionJoueurs.ajouterJoueur(j);
        }
        actual_joueur = collectionJoueurs.get(index_joueur);
    }

    @Override
    public void creation_des() {

    }

    public boolean calculerScoreTour(){
        /*TODO --> cumule le score du joueur de ce tour avec celui du tour precedent
            et decide s'il faut passer la main au prochain joueur ou non
        */
        int score=actual_joueur.getScore();
        Joueur joueur = actual_joueur;
        int des_gagnants=0;
        score_changed =0;
        int des_pareils=0;
        int actual_face_first = joueur.getCollection_des().get(0).getActual_face();
        boolean lancer = false;
        for(Iterator<De> j = joueur.getCollection_des().getDes_collection().iterator(); j.hasNext();) {
            De de = j.next();

            if(de.getActual_face()==actual_lancer){
                score+=1;
                des_gagnants+=1;
                score_changed+=1;
                lancer=true;
            }
            if(de.getActual_face()==actual_face_first){
                des_pareils+=1;
            }
            if(des_gagnants==joueur.getCollection_des().getDes_collection().size() && de.getActual_face()==actual_lancer){
                score+=21;
                score_changed+=21;
                lancer=true;
            }
            if(des_gagnants==joueur.getCollection_des().getDes_collection().size() && de.getActual_face()!=actual_lancer){
                score+=5;
                score_changed+=5;
                lancer=true;
            }

            actual_joueur.setScore(score);
        }
        return lancer;
    }

    public void jouerTour(){

        while(actual_tour<=6) {
            while(index_joueur<3) {
                actual_joueur = collectionJoueurs.get(index_joueur);
                actual_lancer = 1;
                System.out.println("++++++++++++ Tour " + actual_tour+1 + ", Joueur "+index_joueur+1 + ", Lancer "+actual_lancer+" ++++++++++++++");
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

    public CollectionJoueur calculerLeVainqueur(){
        //TODO --> retourne les joueurs tries selon l'ordre croissant des scores
        for (int i = 0; i < collectionJoueurs.size()-1; i++){
            int min = i;
            for (int j = i+1; j < collectionJoueurs.size(); j++){
                if (collectionJoueurs.get(j).compareTo(collectionJoueurs.get(min)) == -1){
                    min = j;
                }
            }
            if (i != min){
                Joueur temp = new Joueur();
                    temp.setName(collectionJoueurs.get(i).getName());
                    temp.setScore(collectionJoueurs.get(i).getScore());
                    temp.setId(collectionJoueurs.get(i).getId());


                collectionJoueurs.get(i).setName(collectionJoueurs.get(min).getName());
                collectionJoueurs.get(i).setScore(collectionJoueurs.get(min).getScore());
                collectionJoueurs.get(i).setId(collectionJoueurs.get(min).getId());

                collectionJoueurs.get(min).setName(temp.getName());
                collectionJoueurs.get(min).setScore(temp.getScore());
                collectionJoueurs.get(min).setId(temp.getId());
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


    public void setCollection_joueur(CollectionJoueur collection_joueur) {
        this.collection_joueur = collection_joueur;
    }

}
