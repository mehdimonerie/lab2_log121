package Framework;

import java.util.*;

public class Jeu {
    int nb_tours;
    private ArrayList<Integer> listScores = new ArrayList<Integer>();

    int nbJoueurs;
    int nbDes;
    int nbFaceDe;

    CollectionJoueur collectionJoueurs;
    CollectionDes collectionDes;

    public Jeu(){
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Veuillez entrer the number of playoueur");
        do {
            System.out.print("Please enter a positive number: ");
            while (!input.hasNextInt()) {
                String scan = input.next();
                System.out.printf("\"%s\" is not a valid number.%n", scan);
            }
            nbJoueurs = input.nextInt();
        } while (nbJoueurs < 0);

        System.out.println("Veuillez rentrer le nombre de De");
        do {
            System.out.print("Please enter a positive number: ");
            while (!input.hasNextInt()) {
                String scan = input.next();
                System.out.printf("\"%s\" is not a valid number.%n", scan);
            }
            nbDes = input.nextInt();
        } while (nbDes < 0);

        System.out.println("Veuillez rentrer le nombre de face par De");
        do {
            System.out.print("Please enter a positive number: ");
            while (!input.hasNextInt()) {
                String scan = input.next();
                System.out.printf("\"%s\" is not a valid number.%n", scan);
            }
            nbFaceDe = input.nextInt();
        } while (nbFaceDe < 0);


        collectionJoueurs = new CollectionJoueur();
        initParamJeu();

        for (Iterator<Joueur> i = collectionJoueurs.getJoueur_collection().iterator(); i.hasNext();) {
            Joueur a = i.next();
            for (Iterator<De> j = a.getListe_des().getDes_collection().iterator(); j.hasNext();) {
                a.setlistResult(j.next().throwingDie());
            }
            a.addResult();
        }

        for (Iterator<Joueur> i = collectionJoueurs.getJoueur_collection().iterator(); i.hasNext();) {
            Joueur a = i.next();
            System.out.println("Joueur " + a.getId() + " : " + a.getlisteResult());
        }
        getWinner(collectionJoueurs);
    }

    public void getWinner (CollectionJoueur collectionJoueurs){
        for (Iterator<Joueur> i = collectionJoueurs.getJoueur_collection().iterator(); i.hasNext();) {
            Joueur a = i.next();
            listScores.add(a.getResult());
        }
        int a = collectionJoueurs.getJoueur_collection().stream().mapToInt(Joueur::getResult).max().orElse(-1);

        Joueur gagnant;
        for (Iterator<Joueur> i = collectionJoueurs.getJoueur_collection().iterator(); i.hasNext();) {
            gagnant = i.next();
            if (gagnant.getResult() == a){
                System.out.println("Les gagnant du tour est Joueur " + gagnant.getId() + " avec le score de " + gagnant.getResult() + " points.");
            }
        }


    }
    public void initParamJeu(){

        for(int i = 0; i < nbJoueurs; i++){
            collectionDes = new CollectionDes();
            for(int j = 0; j < nbDes; j++){
                De de = new De(nbFaceDe);
                de.setId(j+1);
                collectionDes.ajouterDe(de);
            }
            Joueur joueur = new Joueur(collectionDes);
            joueur.setId(i+1);
            collectionJoueurs.ajouterJoueur(joueur);
        }

    }

    public void loop(){
    }

    public void calculerScoreTour(){
    }
    public void calculerLeVainqueur(){
    }

}
