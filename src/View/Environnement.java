package View;
import Framework.Jeu;
import javax.swing.SwingWorker;

public class Environnement extends SwingWorker<Object, String> {
	private Jeu jeu = null;
	private boolean actif = true;
	private static final int DELAI = 100; //mms

	//Tour de clock pour l'animation
	@Override
	protected Object doInBackground() throws Exception {
		while(actif) {
			Thread.sleep(DELAI);
			/**
			 * C'est ici que vous aurez � faire la gestion de la notion de tour.
			 */
			//firePropertyChange("TEST", null, "Ceci est un test");
			jeu.loop();
			firePropertyChange("model", null, jeu);

		}
		return null;
	}

	public void setJeu(Jeu jeu_) {
		jeu = jeu_;
	}
}