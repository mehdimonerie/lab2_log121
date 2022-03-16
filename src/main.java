/**
 * Class main
 * @since Hiver 2022
 * @version 1.0
 * Point d'entrée du programme, crée le creator qui crée le jeu
 */

import Framework.Creator;

public class main {

    public static void main(String[] args) {
        Creator creator = new Creator();
        creator.getJeu().jouerTour();
    }
}
