package Framework;

import java.util.ArrayList;

public class De implements Comparable {
    private int id;
    private int actual_face;
    private ArrayList<Integer> list_face;
    private int nbFaces;

    public De(int nbFaces){
        this.nbFaces = nbFaces;
    }

    public int throwingDie(){
        int result = (int)(Math.random( )*nbFaces + 1);

        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
