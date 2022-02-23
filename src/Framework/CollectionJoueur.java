package Framework;

import java.util.Collection;
import java.util.Iterator;

public class CollectionJoueur {
    Collection<Joueur> joueur_collection;

    public void ajouterJoueur(Joueur joueur){
        joueur_collection.add(joueur);
    }

    public Collection<Joueur> getJoueur_collection() {
        return joueur_collection;
    }
}
