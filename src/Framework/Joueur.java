package Framework;

import java.util.ArrayList;
import java.util.Collection;

public class Joueur implements Comparable {

    private  int id;
    private String name;
    private int score;
    private ArrayList<Integer> result = new ArrayList<Integer>();

    public Joueur() {


    }

    public ArrayList<Integer> getResult() {
        return result;
    }

    public void setResult(int val) {
        this.result.add(val);
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
