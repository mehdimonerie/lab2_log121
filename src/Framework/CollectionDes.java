/**
 * Class CollectionDe
 * @since Hiver 2022
 * @version 1.0
 * Classe possédant la collection de dés
 */
package Framework;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDes {
    Collection<De> des_collection = new ArrayList<>();


    // constructeur si tous les des de la collection ont le meme nb de face
    public CollectionDes(int nbDes, int nbFace){
        for (int i=0; i<nbDes; i++){
            De de = new De(nbFace);
            ajouterDe(de);
        }
    }

    public De get(int index){
        return (De) this.des_collection.toArray()[index];
    }

    //constructeur de collection vide
    public CollectionDes(){}

    public void ajouterDe(De de){
        des_collection.add(de);
    }

    public Collection<De> getDes_collection() {
        return des_collection;
    }

    @Override
    public String toString() {
        return "CollectionDes{" +
                "des_collection=" + des_collection.toString() +
                '}';
    }


}
