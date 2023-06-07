package vue;

import controleur.Controleur;
import javafx.scene.layout.HBox;
import modele.Joueur;
import outil.LectureFichierTexte;

/**
 * La classe HBoxRoot est une sous-classe de HBox qui représente la racine de l'interface graphique de l'application RPG.
 * Elle contient plusieurs éléments graphiques, tels que VBoxAffichageScenario, GridPaneScenario et GridPaneAffichageSolution.
 */
public class HBoxRoot extends HBox {

    private static VBoxAffichageScenario chAfficheScenario;
    private static GridPaneScenario chGridPaneScenario;
    private static GridPaneAffichageSolution chAffichageSolution;
    private static LectureFichierTexte lectureFichierTexte;
    private static Controleur chControleur;
    private static Joueur chJoueur;
    /**
     * Constructeur de la classe HBoxRoot.
     * Initialise les différents éléments graphiques utilisés dans l'interface et les ajoute à la HBoxRoot.
     */
    public HBoxRoot() {
        super(30);
        chControleur = new Controleur();
        lectureFichierTexte = new LectureFichierTexte();
        chAfficheScenario = new VBoxAffichageScenario(lectureFichierTexte.getScenarios());
        chGridPaneScenario = new GridPaneScenario();
        chJoueur = new Joueur();
        chAffichageSolution = new GridPaneAffichageSolution(chJoueur);
        getChildren().addAll(chAfficheScenario, chGridPaneScenario, chAffichageSolution);


    }

    /**
     * Obtient l'objet Controleur utilisé dans l'application.
     *
     * @return l'objet Controleur
     */
    public static Controleur getChControleur() {
        return chControleur;
    }

    /**
     * Obtient l'objet VBoxAffichageScenario utilisé dans l'application.
     *
     * @return l'objet VBoxAffichageScenario
     */
    public static VBoxAffichageScenario getChAfficheScenario() {
        return chAfficheScenario;
    }

    /**
     * Obtient l'objet GridPaneAffichageSolution utilisé dans l'application.
     *
     * @return l'objet GridPaneAffichageSolution
     */
    public static GridPaneAffichageSolution getChAffichageSolution() {
        return chAffichageSolution;
    }

    /**
     * Obtient l'objet GridPaneScenario utilisé dans l'application.
     *
     * @return l'objet GridPaneScenario
     */
    public static GridPaneScenario getChGridPaneScenario() {
        return chGridPaneScenario;
    }

    /**
     * Obtient l'objet LectureFichierTexte utilisé dans l'application.
     *
     * @return l'objet LectureFichierTexte
     */
    public static LectureFichierTexte getLectureFichierTexte() {
        return lectureFichierTexte = new LectureFichierTexte();
    }

    /**
     * Obtient l'objet Joueur utilisé dans l'application.
     *
     * @return l'objet Joueur
     */
    public static Joueur getChJoueur() {
        return chJoueur;
    }
}
