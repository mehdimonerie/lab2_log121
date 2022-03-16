package Framework;

import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public abstract class  Jeu {



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
