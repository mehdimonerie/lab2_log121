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
//import View.Environnement;

public class main {

    public static void main(String[] args) {
        Creator creator = new Creator();
        creator.getJeu().jouerTour();
    }
}
