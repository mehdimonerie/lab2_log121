package Framework;

import java.util.Collection;
import java.util.Iterator;

public class CollectionDes {
    Collection<De> des_collection;

    public void ajouterDe(De de){
        des_collection.add(de);
    }

    public Collection<De> getDes_collection() {
        return des_collection;
    }


}
