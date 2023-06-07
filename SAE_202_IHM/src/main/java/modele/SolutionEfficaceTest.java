package modele;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionEfficaceTest {
    @Test
    void trouverQuetePlusProche(){
        //instanciation des champs :
        Joueur joueur = new Joueur(); // la position du joueur est à 0,0 par défaut
        Scenario scenario = new Scenario();
        SolutionEfficace solutionEfficace = new SolutionEfficace(scenario,joueur);

        // création de la liste de quete disponibles et ajout des trois quetes (la deuxieme est la plus proche du joueur) :
        ArrayList<Quete> liste_quete_disponible = new ArrayList<>();

        Quete quete1 = new Quete("10|(19, 3)|()|1|100|dialoguer avec Osiris le dieu des morts-vivants");
        liste_quete_disponible.add(quete1);
        Quete quete2 = new Quete("1|(2, 4)|()|4|200|explorer cimetière de Thilal Taesi");
        liste_quete_disponible.add(quete2);
        Quete quete3 = new Quete("5|(20, 16)|()|8|250|explorer porte de Mythalian");
        liste_quete_disponible.add(quete3);

        //application de la méthode :
        Quete quetePlusProche = solutionEfficace.trouverQuetePlusProche(liste_quete_disponible);

        //Test :
        assertEquals(quete2,quetePlusProche); // les deux quetes sont les memes
        assertNotEquals(quete3,quetePlusProche); // les deux quetes ne sont pas les memes car la quete 3 n'est pas la plus proche du joueur qui se situe en [0,0]

        /// j'ai changer la méthode et je l'ai mise en public au lieu de private à voir si ça change quelquechose mais sinon je pouvais pas faire le test

    }
}
