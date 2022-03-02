package Framework;

import java.util.ArrayList;
import java.util.Collection;

public class Joueur implements Comparable<Joueur>{
    private String name;



    private int result;
    private int id;
    private CollectionDes liste_des;
    private ArrayList<Integer> listResult = new ArrayList<Integer>();

    public Joueur(CollectionDes liste_des){
        this.liste_des = liste_des;
    }
    public int getResult() {
        return result;
    }
    public int addResult(){
        for(int i = 0; i < listResult.size();i++) {
            this.result += listResult.get(i);
        }
        return result;
    }

    public void setListe_des(CollectionDes liste_des) {
        this.liste_des = liste_des;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int compareTo(Joueur o){
        return 0;
    };
}
