package vue;

import javafx.scene.control.Alert;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;



/**
 * La classe MenuDeroulant représente un menu déroulant personnalisé pour les scénarios dans l'application RPG.
 * Elle crée un MenuButton contenant des MenuItem pour chaque scénario, et permet de sélectionner un scénario.
 */
public class MenuDeroulant {

    private int chNumScenario;
    private MenuButton menuBar;
    public MenuButton scenarioMenu;
    public MenuItem scenario0;
    public MenuItem scenario1;
    public MenuItem scenario2;
    public MenuItem scenario3;
    public MenuItem scenario4;
    public MenuItem scenario5;
    public MenuItem scenario6;
    public MenuItem scenario7;
    public MenuItem scenario8;
    public MenuItem scenario9;
    public MenuItem scenario10;

    /**
     * Crée un MenuButton personnalisé contenant les MenuItem pour chaque scénario.
     *
     * @return le MenuButton créé
     */
    private MenuButton createMenuButton() {
// Créer un menu déroulant pour les scénarios
        scenarioMenu = new MenuButton("Scénarios");

        // Ajouter des éléments de menu pour chaque scénario
        scenario0 = new MenuItem("Scénario 0");
        scenario1 = new MenuItem("Scénario 1");
        scenario2 = new MenuItem("Scénario 2");
        scenario3 = new MenuItem("Scénario 3");
        scenario4 = new MenuItem("Scénario 4");
        scenario5 = new MenuItem("Scénario 5");
        scenario6 = new MenuItem("Scénario 6");
        scenario7 = new MenuItem("Scénario 7");
        scenario8 = new MenuItem("Scénario 8");
        scenario9 = new MenuItem("Scénario 9");
        scenario10 = new MenuItem("Scénario 10");

        // Ajouter les éléments de menu au menu déroulant
        scenarioMenu.getItems().addAll(scenario0, scenario1, scenario2, scenario3, scenario4, scenario5,
                scenario6, scenario7, scenario8, scenario9, scenario10);


        scenarioMenu.setOnAction(VBoxRoot.getChControleur());

        scenario0.setOnAction(event -> {
            //alert();
            chNumScenarioSelect(0);
            scenario0.setOnAction(VBoxRoot.getChControleur());
        });
        scenario1.setOnAction(event -> {
            //alert();
            chNumScenarioSelect(1);
            scenario1.setOnAction(VBoxRoot.getChControleur());
        });

        scenario2.setOnAction(event -> {
            //alert();
            chNumScenarioSelect(2);
            scenario2.setOnAction(VBoxRoot.getChControleur());
        });
        scenario3.setOnAction(event -> {
            //alert();
            chNumScenarioSelect(3);
            scenario3.setOnAction(VBoxRoot.getChControleur());
        });
        scenario4.setOnAction(event -> {
            //alert();
            chNumScenarioSelect(4);
            scenario4.setOnAction(VBoxRoot.getChControleur());
        });
        scenario5.setOnAction(event -> {
            //alert();
            chNumScenarioSelect(5);
            scenario5.setOnAction(VBoxRoot.getChControleur());
        });
        scenario6.setOnAction(event -> {
            //alert();
            chNumScenarioSelect(6);
            scenario6.setOnAction(VBoxRoot.getChControleur());
        });
        scenario7.setOnAction(event -> {
            //alert();
            chNumScenarioSelect(7);
            scenario7.setOnAction(VBoxRoot.getChControleur());
        });
        scenario8.setOnAction(event -> {
            //alert();
            chNumScenarioSelect(8);
            scenario8.setOnAction(VBoxRoot.getChControleur());
        });
        scenario9.setOnAction(event -> {
            //alert();
            chNumScenarioSelect(9);
            scenario9.setOnAction(VBoxRoot.getChControleur());
        });
        scenario10.setOnAction(event -> {
            // alert();
            chNumScenarioSelect(10);
            scenario10.setOnAction(VBoxRoot.getChControleur());
        });

        return scenarioMenu;
    }

    /**
     * Sélectionne un scénario en attribuant le numéro du scénario passé en paramètre à chNumScenario.
     *
     * @param parNumScenario le numéro du scénario sélectionné
     * @return le numéro du scénario sélectionné
     */

    public int chNumScenarioSelect(int parNumScenario){
        chNumScenario = parNumScenario;
        return chNumScenario;
    }

    /**
     * Obtient le numéro du scénario sélectionné.
     *
     * @return le numéro du scénario sélectionné
     */
    public int getChNumScenario(){
        return chNumScenario;
    }

    /**
     * Constructeur de la classe MenuDeroulant.
     * Crée la barre de menu en appelant la méthode createMenuBar.
     */
    public MenuDeroulant() {
        menuBar = createMenuButton();
    }

    /**
     * Obtient la barre de menu créée.
     *
     * @return la barre de menu
     */
    public MenuButton getMenuBar() {
        return menuBar;
    }

    /**
     * Affiche une fenêtre d'alerte.
     * Utile pour debug quand on clique sur un menuItem
     */
    private void alert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("JavaFX MenuBar");
        alert.setHeaderText("Menu Item");
        alert.setContentText("Clicked");
        alert.show();
    }
}


