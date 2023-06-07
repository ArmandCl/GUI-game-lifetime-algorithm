package vue;

import javafx.scene.layout.GridPane;
import modele.Joueur;
import modele.Quete;

import java.util.ArrayList;

/**
 * Cette vue sera utilisée pour afficher le résultat de la solution choisie.
 * La solution sera affichée sous forme de texte à droite de la page.
 */
public class GridPaneAffichageSolution extends GridPane {

    /**
     * Constructeur de la classe GridPaneAffichageSolution.
     * Initialise les éléments pour afficher le résultat de la solution choisie.
     *
     * @param joueur le joueur contenant les résultats de la solution
     */
    public GridPaneAffichageSolution(Joueur joueur) {

    }

    /**
     * Met à jour les éléments de la vue avec les nouvelles valeurs.
     *
     * @param joueur le joueur contenant les résultats de la solution
     * @param parQuetesRealise la liste des quêtes réalisées
     */
    public void update(Joueur joueur, ArrayList<Quete> parQuetesRealise) {

    }
}
