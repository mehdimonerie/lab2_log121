package Framework;

import java.util.ArrayList;
import java.util.Collection;

public class Joueur implements Comparable {

    private  int id;
    private String name;
    private int score;
    private ArrayList<Integer> result = new ArrayList<Integer>();

    public Joueur(){
    }

    public Joueur(String name, int id){
        this.name = name;
        this.id = id;
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setResult(ArrayList<Integer> result) {
        this.result = result;
    }

    @Override
    public int compareTo(Object o) {
        Joueur j = (Joueur) o;
        int retour=0;
        if (this.score > j.getScore()){
            retour = 1;
        } else if (this.score < j.getScore()){
            retour = -1;
        }
        return retour;
    }
}
