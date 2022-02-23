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

        for (Iterator i = collectionJoueurs.getJoueur_collection().iterator(); i.hasNext();i.next()) {
            for (Iterator j = collectionDes.getDes_collection().iterator(); j.hasNext();j.next()) {
                collectionJoueurs.getJoueur_collection().iterator().next().setResult(collectionDes.getDes_collection().iterator().next().throwingDie());
            }
            System.out.println(collectionJoueurs.getJoueur_collection().iterator().next().getResult());
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
