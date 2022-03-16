package Test_package;

import Framework.Joueur;
import org.junit.*;

import Framework.De;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JoueurTest {

    private Joueur j1;
    private Joueur j2;

    @Before
    public void faireAvant(){
        j1 = new Joueur();
        j2 = new Joueur();
    }

    @Test
    public void scoreSuperieurTest(){
        j1.setScore(4);
        j2.setScore(5);
        assertTrue(j1.compareTo(j2)==1);
    }

    @Test
    public void scoreInferieurTest(){
        j1.setScore(4);
        j2.setScore(5);
        assertTrue(j2.compareTo(j1)==-1);
    }

    @Test
    public void memeScoreTest(){
        j1.setScore(4);
        assertTrue(j1.compareTo(j1)==0);
    }
}