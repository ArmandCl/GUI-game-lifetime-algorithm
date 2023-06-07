package vue;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import modele.Joueur;
import modele.Quete;

import java.util.ArrayList;

/**
 * Cette vue sera utilisée pour afficher le résultat de la solution choisie.
 * La solution sera affichée sous forme de texte à droite de la page.
 */
public class GridPaneAffichageSolution extends GridPane {

    private String chResultatDuree;
    private String chResultatExp ;
    private String chResultatDist;
    private String chResultatNbQuetes;
    private Label chLabResultatDuree;
    private Label chLabResultatExp;
    private Label chLabResultatDist;
    private Label chLabResultatNbQuetes;
    private TableView<Quete> chTab = new TableView<>();
    ArrayList<Quete> chQuetesCompleteesExhaustive;

    /**
     * Constructeur de la classe GridPaneAffichageSolution.
     * Initialise les éléments pour afficher le résultat de la solution choisie.
     *
     * @param joueur le joueur contenant les résultats de la solution
     */
    public GridPaneAffichageSolution(Joueur joueur) {
        setHgap(5);
        setVgap(10);
        setPadding(new Insets(0, 0, 0, 0));
        int ligne = 0;

        Label titre = new Label("Module du résultat de la solution");
        GridPane.setHalignment(titre, HPos.CENTER);
        this.add(titre,0,ligne++,6,1);

        Separator sepateurDate = new Separator();
        sepateurDate.setPadding(new Insets(10,0,5,0));
        this.add(sepateurDate,0,ligne++,6,1);

        // Création des labels pour les intitulés

        Label labDureeIntitule = new Label("Durée");
        chResultatDuree = Integer.toString(joueur.getTemps());
        chLabResultatDuree = new Label(chResultatDuree);
        Separator separatorDuree = new Separator();
        separatorDuree.setOrientation(Orientation.VERTICAL);
        this.add(labDureeIntitule,0,ligne);
        this.add(separatorDuree,2,ligne);
        this.add(chLabResultatDuree,3,ligne++);

        Label labExperienceIntitule = new Label("Expérience gagnée");
        chResultatExp = Integer.toString(joueur.getExperience());
        chLabResultatExp = new Label(chResultatExp);
        Separator separatorExp = new Separator();
        separatorExp.setOrientation(Orientation.VERTICAL);
        this.add(labExperienceIntitule,0,ligne);
        this.add(separatorExp,2,ligne);
        this.add(chLabResultatExp,3,ligne++);

        Label labDistanceIntitule = new Label("Distance parcourue");
        chResultatDist = Integer.toString(joueur.getChDistance());
        chLabResultatDist = new Label(chResultatDist);
        Separator separatorDist = new Separator();
        separatorDist.setOrientation(Orientation.VERTICAL);
        this.add(labDistanceIntitule,0,ligne);
        this.add(separatorDist,2,ligne);
        this.add(chLabResultatDist,3,ligne++);

        Label labNbQuetesIntitule = new Label("Nombre de quêtes");
        chResultatNbQuetes = Integer.toString(joueur.getChNbQuetes());
        chLabResultatNbQuetes = new Label(chResultatNbQuetes);
        Separator separatorNbQuetes = new Separator();
        separatorNbQuetes.setOrientation(Orientation.VERTICAL);
        this.add(labNbQuetesIntitule,0,ligne);
        this.add(separatorNbQuetes,2,ligne);
        this.add(chLabResultatNbQuetes,3,ligne++);

        Label labCheminQuete = new Label("Chemin du Joueur:");
        this.add(labCheminQuete,0,ligne++);

        chTab.setPrefSize(110,150);
        TableColumn<Quete, Integer> numeroCol = new TableColumn<>("Numero Quete");
        numeroCol.setCellValueFactory(new PropertyValueFactory<>("Numero"));
        numeroCol.setMinWidth(105);
        numeroCol.setMaxWidth(105);
        chTab.getColumns().add(numeroCol);
        this.add(chTab,0,ligne);

        chQuetesCompleteesExhaustive = new ArrayList<>();
        update(joueur, chQuetesCompleteesExhaustive);      

    }

    /**
     * Met à jour les éléments de la vue avec les nouvelles valeurs.
     *
     * @param joueur le joueur contenant les résultats de la solution
     * @param parQuetesRealise la liste des quêtes réalisées
     */
    public void update(Joueur joueur, ArrayList<Quete> parQuetesRealise) {
        chLabResultatDuree.setText(Integer.toString(joueur.getTemps()));
        chLabResultatExp.setText(Integer.toString(joueur.getExperience()));
        chLabResultatDist.setText(Integer.toString(joueur.getChDistance()));
        chLabResultatNbQuetes.setText(Integer.toString(joueur.getChNbQuetes()));
        System.out.println(parQuetesRealise);
        chTab.getItems().clear();
        for (Quete quete : parQuetesRealise) {
            chTab.getItems().add(quete);
        }
    }
}
