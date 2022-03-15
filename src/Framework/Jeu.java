package Framework;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Jeu {
    int nb_tours;
    int actual_tour = 0;
    int nbJoueurs = 3;
    int nbDes = 3;
    int nbFaceDe = 6;
    int actual_joueur = 0;

    CollectionJoueur collectionJoueurs;

    public Jeu() {
        collectionJoueurs = new CollectionJoueur();
        initParamJeu();
        log_jeu();

    }

    public void rollDices() {
        for (Iterator<Joueur> i = collectionJoueurs.getJoueur_collection().iterator(); i.hasNext(); ) {
            Joueur joueur = i.next();
            for (Iterator<De> j = joueur.getListe_des().getDes_collection().iterator(); j.hasNext(); ) {
                De de = j.next();
                de.throwingDie();
            }
        }
    }


    public void initParamJeu() {
        for (int i = 0; i < nbJoueurs; i++) {
            CollectionDes collectionDes = new CollectionDes();
            for (int j = 0; j < nbDes; j++) {
                De de = new De(nbFaceDe);
                de.setId(j + 1);
                collectionDes.ajouterDe(de);
            }
            Joueur joueur = new Joueur(collectionDes);
            joueur.setId(i);
            collectionJoueurs.ajouterJoueur(joueur);
        }
        rollDices();
    }

    public int getNbDes() {
        return nbDes;
    }

    public void loop() {
    }

    public String calculerLeVainqueur() {
        String return_gagnant = "";
        int count=0;
        int score=0;
        ArrayList<Integer> gagnants = new ArrayList<Integer>();
        int a = collectionJoueurs.getJoueur_collection().stream().mapToInt(Joueur::getScore).max().orElse(-1);
        Joueur gagnant;
        for (Iterator<Joueur> i = collectionJoueurs.getJoueur_collection().iterator(); i.hasNext(); ) {
            gagnant = i.next();
            if (gagnant.getScore() == a) {
                return_gagnant = "Le gagnant est Joueur " + gagnant.getId() + " avec le score de " + gagnant.getScore() + " points.";
                System.out.println(return_gagnant);
                count+=1;
                gagnants.add(gagnant.getId());
                score = gagnant.getScore();
            }
        }

        if(count>=2){
            return_gagnant = "Égalité des joueurs ";
            for(int i=0;i<gagnants.size();i++){
                return_gagnant = return_gagnant + gagnants.get(i).toString()+" ";
            }
            return_gagnant = return_gagnant+" avec"+score+" points";
        }
        else if(score==0){
            return_gagnant = "Partie nulle";
        }
        return return_gagnant;

    }



    public abstract int calculerScoreTour();

    //public CollectionJoueur calculerLeVainqueur(){
    //    return null;
    //}

    public CollectionJoueur getCollectionJoueurs() {
        return collectionJoueurs;
    }

    public abstract void log_jeu();

    public int getActual_joueur() {
        return actual_joueur;
    }
    public abstract boolean prochainJoueur();

    public abstract void nouveauTour() ;



    public abstract int getActual_tour();

    protected void setActual_joueur(int i) {
        actual_joueur=i;
    }
}
