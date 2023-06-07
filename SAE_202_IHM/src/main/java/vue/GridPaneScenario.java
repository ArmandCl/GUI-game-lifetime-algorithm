package vue;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

/**
 * La classe GridPaneScenario est une sous-classe de GridPane qui représente la grille de sélection du scénario et
 * de la solution dans l'interface graphique.
 */
public class GridPaneScenario extends GridPane {

    /**
     * Constructeur de la classe GridPaneScenario.
     * Initialise les éléments de la grille de sélection du scénario et de la solution.
     */
    public GridPaneScenario() {

    }

    /**
     * Peuple une ComboBox avec les éléments d'un tableau d'entiers.
     *
     * @param nbre un tableau d'entiers
     * @return la ComboBox peuplée avec les éléments du tableau
     */
    private ComboBox<Integer> peupleComboBox(Integer[] nbre) {

    }

    /**
     * Réinitialise les valeurs de sélection du scénario et de la solution.
     */
    public void reset() {

    }

    /**
     * Récupère le numéro du scénario sélectionné.
     *
     * @return le numéro du scénario sélectionné
     */
    public int getNumScenario() {

    }

    /**
     * Récupère la solution sélectionnée.
     *
     * @return la solution sélectionnée ("Efficace" ou "Exhaustive")
     */
    public String getSolution() {

    }
}
