package Framework;

import java.util.ArrayList;

public class De implements Comparable {
    private int id;
    private int actual_face;
    private ArrayList<Integer> list_face = new ArrayList<>();
    private int nbFaces;

    public De(int nbFaces){
        this.nbFaces = nbFaces;
        this.actual_face = 1;
        for (int i=1; i< nbFaces+1; i++){
            list_face.add(i);
        }
    }

    public void throwingDie(){
        int result = (int)(Math.random( )*nbFaces + 1);
        this.actual_face = result;
    }

    public int getId() {
        return id;
    }

    public int getActual_face() {
        return actual_face;
    }

    public void setActual_face(int actual_face) {
        this.actual_face = actual_face;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null){

        }
        De de = (De) o;
        int retour = 0;
        if (this.getActual_face() > ((De) o).getActual_face()){
            retour = -1;
        } else if (this.getActual_face() < ((De) o).getActual_face()) {
            retour = 1;
        }
        return retour;
    }
}
