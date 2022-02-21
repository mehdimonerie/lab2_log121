package Framework;

import java.util.Collection;
import java.util.Iterator;

public class CollectionJoueur {
    Collection<Joueur> joueur_collection;

    public void ajouterJoueur(Joueur joueur){

    }

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
}
