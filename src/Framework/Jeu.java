package Framework;

import java.util.Collection;
import java.util.Iterator;

public class Jeu {
    int nb_tours;
    int nbJoueurs = 3 ;
    int nbDes = 3;
    int nbFaceDe = 6;

    CollectionJoueur collectionJoueurs;
    CollectionDes collectionDes;

    public Jeu(){
        collectionDes = new CollectionDes();
        collectionJoueurs = new CollectionJoueur();
        initParamJeu();

        for (Iterator<Joueur> i = collectionJoueurs.getJoueur_collection().iterator(); i.hasNext();) {
            Joueur a = i.next();
            for (Iterator<De> j = collectionDes.getDes_collection().iterator(); j.hasNext();) {
                a.setResult(j.next().throwingDie());
            }
        }
    }

    public void initParamJeu(){
        for(int i = 0; i < nbJoueurs; i++){
            Joueur joueur = new Joueur();
            joueur.setId(i+1);
            collectionJoueurs.ajouterJoueur(joueur);
        }
        for(int i = 0; i < nbDes; i++){
            De de = new De(nbFaceDe);
            de.setId(i+1);
            collectionDes.ajouterDe(de);
        }
    }

    public void loop(){
    }

    public void calculerScoreTour(){
    }
    public void calculerLeVainqueur(){
    }

}
