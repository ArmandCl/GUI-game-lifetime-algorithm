package vue;

import controleur.Controleur;
import javafx.scene.layout.VBox;

/**
 * La classe VBoxRoot est une sous-classe de VBox qui représente la racine de l'interface graphique de l'application RPG.
 * Elle contient une instance de HBoxRoot et de MenuDeroulant, ainsi qu'un objet Controleur pour la gestion des événements.
 */
public class VBoxRoot extends VBox {


    /**
     * Constructeur de la classe VBoxRoot.
     * Crée une instance de Controleur, HBoxRoot et MenuDeroulant.
     * Ajoute le MenuBar de MenuDeroulant et HBoxRoot à la VBoxRoot.
     */
    public VBoxRoot() {

       }

    /**
     * Obtient l'objet Controleur utilisé dans l'application.
     *
     * @return l'objet Controleur
     */
    public static Controleur getChControleur() {

    }

    /**
     * Obtient l'objet MenuDeroulant utilisé dans l'application.
     *
     * @return l'objet MenuDeroulant
     */
    public static MenuDeroulant getChMenuDeroulant() {

    }
}
