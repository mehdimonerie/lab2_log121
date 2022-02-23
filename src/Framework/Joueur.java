package Framework;

import java.util.Collection;

public class Joueur implements Comparable {

    private  int id;
    private String name;
    private int score;

    public Joueur() {


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

}
