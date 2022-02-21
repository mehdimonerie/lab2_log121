package Framework;

import java.util.Collection;
import java.util.Iterator;

public class CollectionDes {
    Collection<De> des_collection;

    public void ajouterDe(De de){

    }

    public Iterator<De> creeIterateur(){
        return new Iterator<De>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public De next() {
                return null;
            }
        };
    }
}
