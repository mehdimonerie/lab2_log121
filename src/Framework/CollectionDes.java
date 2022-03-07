package Framework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDes {
    Collection<De> des_collection;


    public CollectionDes() {
        des_collection = new ArrayList<De>();
    }

    public void ajouterDe(De de){
        des_collection.add(de);
    }

    public Collection<De> getDes_collection() {
        return des_collection;
    }

    public De get(int index){
        return (De) this.des_collection.toArray()[index];
    }


    @Override
    public String toString() {
        return "CollectionDes{" +
                "des_collection=" + des_collection.toString() +
                '}';
    }
}
