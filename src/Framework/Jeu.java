package Framework;

import java.util.*;

public class Jeu {
    int nb_tours;
    int tour = 1;

    int nbJoueurs;
    int nbDes;
    int nbFaceDe;
    String joueurs = "Veuillez rentrer le nombre de joueurs";
    String tours = "Veuillez rentrer le nombre de tours";
    String de = "Veuillez rentrer le nombre de De";
    String faceDe = "Veuillez rentrer le nombre de De";

    CollectionJoueur collectionJoueurs;
    CollectionDes collectionDes;

    public Jeu(){
        nbJoueurs = getInput(joueurs);
        nb_tours = getInput(tours);
        nbDes = getInput(de);
        nbFaceDe = getInput(faceDe);

        collectionJoueurs = new CollectionJoueur();
        initParamJeu();
        do {
            for (Iterator<Joueur> i = collectionJoueurs.getJoueur_collection().iterator(); i.hasNext(); ) {
                Joueur a = i.next();
                for (Iterator<De> j = a.getListe_des().getDes_collection().iterator(); j.hasNext(); ) {
                    a.setlistResult(j.next().throwingDie());
                }
                a.addResult();
            }
            for (Iterator<Joueur> i = collectionJoueurs.getJoueur_collection().iterator(); i.hasNext(); ) {
                Joueur a = i.next();
            }
            tour++;
        }while(tour < nb_tours);
        getWinner(collectionJoueurs);
    }

    public void getWinner (CollectionJoueur collectionJoueurs){

        int a = collectionJoueurs.getJoueur_collection().stream().mapToInt(Joueur::getResult).max().orElse(-1);
        Joueur gagnant;
        for (Iterator<Joueur> i = collectionJoueurs.getJoueur_collection().iterator(); i.hasNext();) {
            gagnant = i.next();
            if (gagnant.getResult() == a){
                System.out.println("Les gagnant est Joueur " + gagnant.getId() + " avec le score de " + gagnant.getResult() + " points.");
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

    public int getInput(String question){
        int entry;
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        System.out.println(question); // User decide le nombre de joueurs
        do {
            System.out.print("Please enter a positive number: ");
            while (!input.hasNextInt()) {
                String scan = input.next();
                System.out.printf("\"%s\" is not a valid number.%n", scan);
            }
            entry = input.nextInt();
        } while (entry < 0);
        return entry;
    }

    public void loop(){

    }

    public void calculerScoreTour(){
    }
    public void calculerLeVainqueur(){
    }

}
