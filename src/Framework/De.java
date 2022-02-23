package Framework;

import java.util.ArrayList;

public class De implements Comparable {
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

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
