package Framework;

import java.util.Collection;
import java.util.Iterator;

public class Jeu {
    int nb_tours;
    int actual_tour=1;
    int nbJoueurs = 3 ;
    int nbDes = 3;
    int nbFaceDe = 6;

    CollectionJoueur collectionJoueurs;

    public Jeu(){
        collectionJoueurs = new CollectionJoueur();
        initParamJeu();
        log_jeu();

    }

    public void rollDices(){
        for (Iterator<Joueur> i = collectionJoueurs.getJoueur_collection().iterator(); i.hasNext();) {
            Joueur joueur = i.next();
            for (Iterator<De> j = joueur.getListe_des().getDes_collection().iterator(); j.hasNext();) {
                De de = j.next();
                de.throwingDie();
            }
        }
    }

    public void initParamJeu(){
        for(int i = 0; i < nbJoueurs; i++){
            CollectionDes collectionDes = new CollectionDes();
            for(int j = 0; j < nbDes; j++){
                De de = new De(nbFaceDe);
                de.setId(j+1);
                collectionDes.ajouterDe(de);
            }
            Joueur joueur = new Joueur(collectionDes);
            joueur.setId(i+1);
            collectionJoueurs.ajouterJoueur(joueur);
        }
        rollDices();
    }

    public void loop(){
    }

    public void calculerScoreTour(){
    }
    public void calculerLeVainqueur(){
    }

    public CollectionJoueur getCollectionJoueurs() {
        return collectionJoueurs;
    }

    public void log_jeu(){
        for(int i=0;i<this.collectionJoueurs.getJoueur_collection().size();i++){
            String log = collectionJoueurs.get(i).toString();
            System.out.println(log);
        }
    }

    public void nouveauTour() {
        actual_tour=actual_tour+1;
        System.out.println("actual_tour : "+actual_tour);
        rollDices();
    }

    public int get_tour() {
        System.out.println("special : "+actual_tour);
        return this.actual_tour;
    }

    public int getActual_tour() {
        System.out.println("special : "+actual_tour);
        return actual_tour;
    }
}
