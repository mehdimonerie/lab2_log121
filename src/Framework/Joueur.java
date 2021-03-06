/**
 * Class Joueur
 * @since Hiver 2022
 * @version 1.0
 * Classe objet joueur
 */


package Framework;
import java.util.Iterator;

public class Joueur implements Comparable {

    private  int id;
    private String name;
    private int score;
    private CollectionDes collection_des;

    public Joueur(){
    }

    public Joueur(String name, int id,CollectionDes collection_des){
        this.name = name;
        this.id = id;
        this.collection_des = collection_des;
    }

    public Joueur(String name, int id){
        this.name = name;
        this.id = id;
    }

    /**
     * Le joueur fait rouler tous les des de sa collection
     */
    public void lancer_des(){
        for (Iterator<De> j = collection_des.getDes_collection().iterator(); j.hasNext(); ) {
            j.next().throwingDie();
        }
    }

    public int getId() {
        return id;
    }

    public CollectionDes getCollection_des() {
        return collection_des;
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


    /**
     *
     * @param o Object cast into Joueur
     * @return 1 si l'arg est plus grand que this
     *        -1 si c'est l'inverse
     *         0 en cas d'egalite
     */
    @Override
    public int compareTo(Object o) {
        Joueur j = (Joueur) o;
        int retour=0;
        if (this.score > j.getScore()){
            retour = -1;
        } else if (this.score < j.getScore()){
            retour = 1;
        }
        return retour;
    }


    @Override
    public String toString() {
        return "Joueur{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", liste_des=" + collection_des.toString() +
                '}';
    }
}
