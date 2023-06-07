package vue;

import javafx.scene.layout.VBox;
import modele.Quete;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * La classe VBoxAffichageScenario est une sous-classe de VBox qui représente l'affichage des scénarios dans l'interface graphique.
 * Elle utilise un TableView pour afficher les quêtes associées à chaque scénario.
 */
public class VBoxAffichageScenario extends VBox {

    /**
     * Constructeur de la classe VBoxAffichageScenario.
     * Initialise l'affichage des scénarios avec le premier scénario et ses quêtes associées.
     *
     * @param parQuete une TreeMap contenant les quêtes associées à chaque scénario
     */
    public VBoxAffichageScenario(TreeMap<Integer, ArrayList<Quete>> parQuete) {

    }

    /**
     * Met à jour l'affichage des quêtes pour un scénario spécifique.
     *
     * @param numScenario l'indice du scénario
     * @param parQuetes   la liste des quêtes associées au scénario
     */
    public void update(int numScenario, ArrayList<Quete> parQuetes) {

    }

}
