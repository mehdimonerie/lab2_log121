package Framework;

import java.util.Collection;

public abstract class Joueur implements Comparable<Joueur>{
    private String name;
    private int score;
    private Collection<De> liste_des;

    public Joueur(){}

    public void setListe_des(Collection<De> liste_des) {
        this.liste_des = liste_des;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Collection<De> getListe_des() {
        return liste_des;
    }

    public abstract int compareTo(Joueur o);
}
