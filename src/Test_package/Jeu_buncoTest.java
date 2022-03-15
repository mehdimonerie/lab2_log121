package Test_package;

import Bunco_plus.Jeu_bunco;
import Bunco_plus.Joueur_bunco;
import Framework.CollectionJoueur;
import Framework.Joueur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Jeu_buncoTest {

    @Test
    public void calculerLeVainqueurTest(){
        Joueur j1 = new Joueur_bunco("j1", 1);
        j1.setScore(1);
        Joueur j2 = new Joueur_bunco("j2",2);
        j2.setScore(5);
        Joueur j3 = new Joueur_bunco("j3", 3);
        j3.setScore(2);
        Joueur j4 = new Joueur_bunco("j4",4);
        j4.setScore(3);

        CollectionJoueur collecJoueur = new CollectionJoueur();
        collecJoueur.ajouterJoueur(j1);
        collecJoueur.ajouterJoueur(j2);
        collecJoueur.ajouterJoueur(j3);
        collecJoueur.ajouterJoueur(j4);

        Jeu_bunco jeu = new Jeu_bunco();
        jeu.setCollection_joueur(collecJoueur);

        System.out.println(jeu.calculerLeVainqueur());

        //assertEquals(1, jeu.calculerLeVainqueur().get(0).getId());
        //assertEquals(3, jeu.calculerLeVainqueur().get(1).getId());
        //assertEquals(4, jeu.calculerLeVainqueur().get(2).getId());
        //assertEquals(2, jeu.calculerLeVainqueur().get(3).getId());
    }

}