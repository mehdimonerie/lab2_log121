package Test_package;

import Bunco_plus.Joueur_bunco;
import Framework.Joueur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Joueur_buncoTest {

    @Test
    public void compareToTest(){
        Joueur_bunco j1 = new Joueur_bunco();
        j1.setName("j1");
        j1.setScore(1);
        Joueur_bunco j2 = new Joueur_bunco();
        j2.setName("j2");
        j2.setScore(2);
        Joueur_bunco j3 = new Joueur_bunco();
        j3.setName("j3");
        j3.setScore(3);
        Joueur_bunco j4 = new Joueur_bunco();
        j4.setName("j4");
        j4.setScore(1);

        assertEquals(-1, j1.compareTo(j4));
        assertEquals(0,j1.compareTo(j4));
        //assertEquals(j3.compareTo(j2), 1);
    }

}