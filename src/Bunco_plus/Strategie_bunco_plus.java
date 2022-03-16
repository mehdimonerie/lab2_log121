package Bunco_plus;

import Framework.CollectionJoueur;
import Framework.IStrategie;
import Framework.Joueur;

public class Strategie_bunco_plus implements IStrategie {

    @Override
    public boolean calculerScoreTour() {
        return false;
    }

    @Override
    public CollectionJoueur calculerLeVainqueur() {
        return null;
    }
}
