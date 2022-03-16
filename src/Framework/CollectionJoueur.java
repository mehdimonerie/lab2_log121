package Framework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionJoueur {
    Collection<Joueur> joueur_collection = new ArrayList<>();

    public void ajouterJoueur(Joueur joueur){
        joueur_collection.add(joueur);
    }

    public int size(){
        return joueur_collection.size();
    }

    public Joueur get(int index){
        return (Joueur) this.joueur_collection.toArray()[index];
    }

    /*public void set(int index, Joueur newJoueur){
        this.joueur_collection.toArray()[index].setName(newJoueur.getName());
        this.joueur_collection.toArray()[index].setScore(newJoueur.getScore());
        this.joueur_collection.toArray()[index].setListe_des(newJoueur.getListe_des());
    }*/

    /**
     * Patron Iterateur pour pouvoir naviguer entre les element de la colection
      */

    public Iterator<Joueur> creeIterateur(){
        return new Iterator<Joueur>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Joueur next() {
                return null;
            }
        };
    }


    public Collection<Joueur> getJoueur_collection() { return joueur_collection;
    }
}
