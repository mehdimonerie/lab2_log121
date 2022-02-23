package Bunco_plus;

import Framework.Joueur;

public class Joueur_bunco extends Joueur {

    private int score = 0;
    private String name;


    @Override
    public int compareTo(Joueur o) {
        int retour=0;
        if (this.score > o.getScore()){
            retour = 1;
        } else if (this.score < o.getScore()){
            retour = -1;
        }
        return retour;
    }
}
