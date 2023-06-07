package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import modele.*;
import outil.LectureFichierTexte;
import vue.*;

import java.util.ArrayList;

public class Controleur implements EventHandler {


    /**
     * Gère les événements déclenchés par les interactions avec les éléments graphiques.
     *
     * @param event l'événement à traiter
     */
    @Override
    public void handle(Event event) {
        VBoxAffichageScenario affichageScenario = HBoxRoot.getChAfficheScenario();
        GridPaneAffichageSolution affichageSolution = HBoxRoot.getChAffichageSolution();
        LectureFichierTexte fichierScenario = HBoxRoot.getLectureFichierTexte();
        GridPaneScenario scenarioPane = HBoxRoot.getChGridPaneScenario();
        SolutionEfficace solutionEfficace;
        SolutionExhaustive solutionExhaustive;
        Joueur joueur = HBoxRoot.getChJoueur();
        MenuDeroulant menuDeroulant = VBoxRoot.getChMenuDeroulant();

        if (event.getSource() instanceof Button){
            int numScenario = scenarioPane.getNumScenario();
            Scenario scenario = fichierScenario.getScenario(numScenario);
            ArrayList<Quete> quetes = fichierScenario.getKey(numScenario);
            affichageScenario.update(numScenario,quetes);
            if (scenarioPane.getSolution()=="Efficace") {
                joueur.reset();
                solutionEfficace = new SolutionEfficace(scenario, joueur);
                solutionEfficace.solutionGloutonne();
                affichageSolution.update(joueur, joueur.getChQuetesCompleteesGloutonne2());
            }else {
                joueur.reset();
                solutionExhaustive = new SolutionExhaustive(scenario, joueur);
                solutionExhaustive.solutionExhaustive();
                affichageSolution.update(joueur, joueur.getChQuetesCompleteesExhaustive2());
            }

        }

        if (event.getSource() instanceof ComboBox<?>){
            int numScenario = scenarioPane.getNumScenario();
            ArrayList<Quete> quetes = fichierScenario.getKey(numScenario);
            affichageScenario.update(numScenario,quetes);
        }

        if (event.getSource() instanceof MenuItem){
            int numScenarioMenu = menuDeroulant.getChNumScenario();
            ArrayList<Quete> quetes = fichierScenario.getKey(numScenarioMenu);
            affichageScenario.update(numScenarioMenu,quetes);
        }
    }
}
