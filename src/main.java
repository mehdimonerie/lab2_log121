/**
 * Class Simulation
 * @author pierre leveille
 * @since Hiver 2022
 * @version 1.0
 * Point d'entrée du programme, crée le jeu et part la vue
 */

import Bunco_plus.Jeu_bunco;
import Framework.Creator;
import Framework.Jeu;
import View.Environnement;
import View.FenetrePrincipale;

public class main {

    public static void main(String[] args) {

        //Model
        Creator creator = new Creator();
        Jeu jeu1 = creator.getJeu();
        //View
        Environnement environnement = new Environnement();
        FenetrePrincipale fenetre = new FenetrePrincipale();
        environnement.setJeu(jeu1);
        environnement.addPropertyChangeListener(fenetre);
        environnement.execute();

    }
}
