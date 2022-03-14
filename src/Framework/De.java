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
        int actual_face_ = (int)(Math.random( )*nbFaces + 1);
        this.actual_face=actual_face_;
        return actual_face;
    }

    public int getActual_face() {
        return actual_face;
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

    @Override
    public String toString() {
        return "De{" +
                "actual_face=" + actual_face +
                '}';
    }
}
