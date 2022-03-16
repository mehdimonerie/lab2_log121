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

    /**
     * fait rouler le de
     */
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


    /**
     *
     * @param o Object cast into De
     * @return 1 si l'arg est plus grand que this
     *        -1 si c'est l'inverse
     *         0 en cas d'egalite
     */
    @Override
    public int compareTo(Object o){

        De de = (De) o;

        int retour = 0;
        if (this.getActual_face() > ((De) o).getActual_face()){
            retour = -1;
        } else if (this.getActual_face() < ((De) o).getActual_face()) {
            retour = 1;
        }
        return retour;
    }

    @Override
    public String toString() {
        return "De{" +
                "actual_face=" + actual_face +
                '}';
    }
}
