package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

/**
 * La classe ApplicationRpg est une application JavaFX qui lance l'analyseur RPG.
 * Elle crée une fenêtre avec une scène contenant une racine VBoxRoot pour afficher l'interface graphique.
 */
public class ApplicationRpg extends Application {

    /**
     * La méthode start est appelée lors du démarrage de l'application.
     * Elle crée une instance de VBoxRoot, crée une scène avec cette racine et l'affiche sur la fenêtre du stage.
     *
     * @param stage le stage de l'application JavaFX
     */
    public void start (Stage stage){
        VBoxRoot root = new VBoxRoot();
        Scene scene = new Scene(root, 1350, 630);
        File[] fichiersCss = new File("css").listFiles();
        for (File fichier : fichiersCss){
            scene.getStylesheets().add(fichier.toURI().toString());
        }
        stage.setScene(scene);
        stage.setTitle("Analyse RPG");
        stage.show();
    }

    /**
     * La méthode main est le point d'entrée de l'application.
     * Elle lance l'application en appelant la méthode launch avec les arguments spécifiés.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
