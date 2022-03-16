package Test_package;

import org.junit.*;

import Framework.De;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeTest {

    private De de1;
    private De de2;

    @Before
    public void faireAvant(){
        de1 = new De(6);
        de2 = new De(6);
    }

    @Test
    public void deSuperieurTest(){
        de1.setActual_face(4);
        de2.setActual_face(5);
        assertTrue(de1.compareTo(de2)==1);
    }

    @Test
    public void deInferieurTest(){
        de1.setActual_face(4);
        de2.setActual_face(5);
        assertTrue(de2.compareTo(de1)==-1);
    }

    @Test
    public void memeDeTest(){
        de1.setActual_face(4);
        assertTrue(de1.compareTo(de1)==0);
    }
}