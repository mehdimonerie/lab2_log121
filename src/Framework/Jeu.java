package Framework;

public abstract class  Jeu {

    /**
     * Methode template pour le deroulement d'une partie
     */

    public Jeu(){
        creation_joueur();
        creation_des();
        jouerTour();
    }

    public abstract void jouerTour();
    public abstract void creation_joueur();
    public abstract void creation_des();
    public abstract boolean calculerScoreTour();
    public abstract CollectionJoueur calculerLeVainqueur();

}
