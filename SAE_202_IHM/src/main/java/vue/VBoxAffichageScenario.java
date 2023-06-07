package vue;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import modele.Quete;

import java.util.ArrayList;
import java.util.TreeMap;

import static modele.ConstantesFichierScenario.NOM_SCENARIO;

/**
 * La classe VBoxAffichageScenario est une sous-classe de VBox qui représente l'affichage des scénarios dans l'interface graphique.
 * Elle utilise un TableView pour afficher les quêtes associées à chaque scénario.
 */
public class VBoxAffichageScenario extends VBox {

    private Label chLabScenario = new Label(NOM_SCENARIO[0]);
    private TableView<Quete> chTab = new TableView<>();
    private TreeMap<Integer, ArrayList<Quete>> scenarios;

    /**
     * Constructeur de la classe VBoxAffichageScenario.
     * Initialise l'affichage des scénarios avec le premier scénario et ses quêtes associées.
     *
     * @param parQuete une TreeMap contenant les quêtes associées à chaque scénario
     */
    public VBoxAffichageScenario(TreeMap<Integer, ArrayList<Quete>> parQuete) {
        chLabScenario.setAlignment(Pos.CENTER);
        // Créer les colonnes du TableView
        chTab.setPrefSize(650,500);
        TableColumn<Quete, Integer> numeroCol = new TableColumn<>("Numero");
        numeroCol.setCellValueFactory(new PropertyValueFactory<>("Numero"));

        TableColumn<Quete, String> positionCol = new TableColumn<>("Position");
        positionCol.setCellValueFactory(new PropertyValueFactory<>("PosAsString"));

        TableColumn<Quete, String> preconditionCol = new TableColumn<>("Precondition");
        preconditionCol.setCellValueFactory(new PropertyValueFactory<>("PrecondAsString"));

        TableColumn<Quete, Integer> dureeCol = new TableColumn<>("Duree");
        dureeCol.setCellValueFactory(new PropertyValueFactory<>("Duree"));

        TableColumn<Quete, Integer> experienceCol = new TableColumn<>("Experience");
        experienceCol.setCellValueFactory(new PropertyValueFactory<>("Experience"));

        TableColumn<Quete, String> intituleCol = new TableColumn<>("Intitule");
        intituleCol.setResizable(true);
        intituleCol.setCellValueFactory(new PropertyValueFactory<>("Intitule"));
        intituleCol.setMinWidth(300);


        chTab.getColumns().addAll(numeroCol, positionCol, preconditionCol, dureeCol, experienceCol, intituleCol);
        getChildren().addAll(chLabScenario, chTab);
        update(0,parQuete.get(0));
    }

    /**
     * Met à jour l'affichage des quêtes pour un scénario spécifique.
     *
     * @param numScenario l'indice du scénario
     * @param parQuetes   la liste des quêtes associées au scénario
     */
    public void update(int numScenario, ArrayList<Quete> parQuetes) {
        chLabScenario.setText(NOM_SCENARIO[numScenario]);
        chTab.getItems().clear();
        for (Quete quete : parQuetes) {
            chTab.getItems().add(quete);
        }
    }
}
