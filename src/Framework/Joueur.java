package Framework;

import java.util.ArrayList;
import java.util.Collection;


public class Joueur implements Comparable<Joueur>{
    private  int id;
    private String name;
    private int score;
    private int result;
    private ArrayList<Integer> listResult = new ArrayList<Integer>();
    private CollectionDes liste_des;

    public Joueur(CollectionDes collection_des_){
        liste_des = collection_des_;
    }
    public Joueur(){
    }

    public Joueur(String name, int id){
        this.name = name;
        this.id = id;
    }


    public ArrayList<Integer> getResult() {
        return listResult;
    }
    public int addResult(){
        for(int i = 0; i < listResult.size();i++) {
            this.result += listResult.get(i);
        }
        return result;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListe_des(CollectionDes liste_des) {
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

    public CollectionDes getListe_des() {
        return liste_des;
    }
    public void setlistResult(int val) {
        this.listResult.add(val);
    }
    public ArrayList<Integer> getlisteResult(){
        return listResult;
    }
    public int compareTo(Joueur joueur) {
        Joueur j = joueur;
        int retour=0;
        if (this.score > j.getScore()){
            retour = 1;
        } else if (this.score < j.getScore()){
            retour = -1;
        }
        return retour;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", result=" + result +
                ", liste_des=" + liste_des.toString() +
                '}';
    }

    public int getId() {
        return id;
    }


}
