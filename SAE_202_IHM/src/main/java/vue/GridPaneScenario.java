package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import static modele.ConstantesScenario.NUM_SCENARIO;

/**
 * La classe GridPaneScenario est une sous-classe de GridPane qui représente la grille de sélection du scénario et
 * de la solution dans l'interface graphique.
 */
public class GridPaneScenario extends GridPane {

    private ComboBox chNumScenario;
    private ToggleGroup chRadioGroup;

    /**
     * Constructeur de la classe GridPaneScenario.
     * Initialise les éléments de la grille de sélection du scénario et de la solution.
     */
    public GridPaneScenario() {
        setHgap(20);
        setVgap(10);
        setPadding(new Insets(0, 0, 0, 0));
        int ligne = 0;

        Label titre = new Label("Module de selection");
        GridPane.setHalignment(titre, HPos.CENTER);
        this.add(titre,0,ligne++,6,1);

        Separator sepateurDate = new Separator();
        sepateurDate.setPadding(new Insets(10,0,5,0));
        this.add(sepateurDate,0,ligne++,6,1);

        Label labNiv = new Label("Choisir un scenario:");
        this.add(labNiv,0,ligne,1,1);
        chNumScenario =peupleComboBox(NUM_SCENARIO);
        this.add(chNumScenario,2,ligne++);

        Label labSol = new Label("Choisir une solution:");
        this.add(labSol,0,ligne,1,1);
        chRadioGroup = new ToggleGroup();

        RadioButton radioButtonDebutant = new RadioButton("Efficace");
        radioButtonDebutant.setUserData("Efficace");
        radioButtonDebutant.setToggleGroup(chRadioGroup);
        this.add(radioButtonDebutant,1,ligne,2,1);

        RadioButton radioButtonMoyen = new RadioButton("Exhaustive");
        radioButtonMoyen.setUserData("Exhaustive");
        radioButtonMoyen.setToggleGroup(chRadioGroup);
        radioButtonMoyen.setMnemonicParsing(true);
        this.add(radioButtonMoyen,3,ligne++,4,1);

        Separator sepateurBouton = new Separator();
        sepateurBouton.setPadding(new Insets(10,0,5,0));
        this.add(sepateurBouton,0,ligne++,6,1);

        Button buttonAnnuler = new Button("Annuler");
        this.add(buttonAnnuler,2,ligne,2,1);
        Button buttonValider = new Button("Valider");
        this.add(buttonValider,4,ligne);

        buttonValider.setOnAction(HBoxRoot.getChControleur());
        chNumScenario.setOnAction(HBoxRoot.getChControleur());
        buttonAnnuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                reset();
            }
        });
        reset();
    }

    /**
     * Peuple une ComboBox avec les éléments d'un tableau d'entiers.
     *
     * @param nbre un tableau d'entiers
     * @return la ComboBox peuplée avec les éléments du tableau
     */
    private ComboBox<Integer> peupleComboBox(Integer[] nbre) {
        ComboBox <Integer> comboBox = new ComboBox<>();
        for (Integer nbre_scen:nbre){
            comboBox.getItems().add(nbre_scen);
        }
        return comboBox;
    }

    /**
     * Réinitialise les valeurs de sélection du scénario et de la solution.
     */
    public void reset() {
        chNumScenario.setValue(NUM_SCENARIO[0]);
        chRadioGroup.getToggles().get(0).setSelected(true);
    }

    /**
     * Récupère le numéro du scénario sélectionné.
     *
     * @return le numéro du scénario sélectionné
     */
    public int getNumScenario() {
        return (int) chNumScenario.getValue();
    }

    /**
     * Récupère la solution sélectionnée.
     *
     * @return la solution sélectionnée ("Efficace" ou "Exhaustive")
     */
    public String getSolution() {
        RadioButton selectedRadioButton = (RadioButton) chRadioGroup.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();
        return toogleGroupValue;
    }
}
