/**
 * Class creator
 * @since Hiver 2022
 * @version 1.0
 * Classe Fabrique qui crée l'objet Jeu
 */


package Framework;
import Bunco_plus.Jeu_bunco;

public class Creator{
    Jeu jeu = null;

    public Creator(){
        /* TODO : Choisis le jeu selon le choix */
        jeu = new Jeu_bunco();
    }

    public Jeu getJeu() {
        return jeu;
    }
}
