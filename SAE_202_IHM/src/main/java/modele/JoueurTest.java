package modele;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class JoueurTest {

    @Test
    void completerQueteGloutonne(){
        //Test 1 :
        Joueur joueur1 = new Joueur();
        Quete quete1 = new Quete("18|(16, 6)|((2, 16),)|1|100|vaincre Géant du feu");

        //on regarde si le joueur n'est pas déja sur la quete, si il n'est pas à la meme position, on le fait se déplacer (ça va augmenter le temps)
        while (joueur1.getPositionX() != quete1.getPos()[0] && joueur1.getPositionY() != quete1.getPos()[1]){
            joueur1.seDeplacerVers(quete1.getPos()[0],quete1.getPos()[1]);
        }

        //je j1 est sur la quete, il la complete donc
        joueur1.completerQueteGloutonne(quete1);

        assertEquals(100, joueur1.getExperience());
        assertEquals(16, joueur1.getPositionX());
        assertEquals(6, joueur1.getPositionY());
        assertEquals(23, joueur1.getTemps()); // le temps est de 23 car : (16-0)+(6-0)+1 = 23
        assertTrue(joueur1.queteCompleteeGloutonne(18));

        //Test 2 :
        Joueur joueur2 = new Joueur();
        Quete quete2 = new Quete("0|(5, 1)|((4,),)|8|650|explorer cascade de Irma Lenora");

        //on regarde si le joueur n'est pas déja sur la quete, si il n'est pas à la meme position, on le fait se déplacer (ça va augmenter le temps)
        while (joueur2.getPositionX() != quete2.getPos()[0] && joueur2.getPositionY() != quete2.getPos()[1]){
            joueur2.seDeplacerVers(quete2.getPos()[0],quete2.getPos()[1]);
        }

        //je j1 est sur la quete, il la complete donc
        joueur2.completerQueteGloutonne(quete2);

        assertEquals(0, joueur2.getExperience()); // comme c'est la quete 0, ca ne donne pas d'experience
        assertEquals(5, joueur2.getPositionX());
        assertEquals(1, joueur2.getPositionY());
        assertEquals(14, joueur2.getTemps());
        assertTrue(joueur2.queteCompleteeGloutonne(0));
    }

    @Test
    void queteCompleteeGloutonne(){
        Joueur joueur = new Joueur();
        Quete quete = new Quete("18|(16, 6)|((2, 16),)|1|100|vaincre Géant du feu");

        //le joueur complete la quete numéro 18, ça va ajouté le numéro 18 dans la liste des quetes completées par le joueur
        joueur.completerQueteGloutonne(quete);

        //on regarde si la liste des quêtes complétée contient bien le bon numéro de quête
        assertTrue(joueur.queteCompleteeGloutonne(quete.getNumero())); // vrai car le joueur à fait la quete
        assertFalse(joueur.queteCompleteeGloutonne(19)); //faux par ce que le joueur n'a pas fait la quete
    }

    @Test
    void toutesQuetesCompletees() {
        Joueur joueur = new Joueur();
        Scenario scenario = new Scenario();

        // Créer des quêtes non complétées et les ajouter au scénario
        Quete quete1 = new Quete("18|(16, 6)|((2, 16),)|1|100|vaincre Géant du feu");
        Quete quete2 = new Quete("19|(8, 12)|((15, 5),(13, 9))|2|150|retrouver artefact perdu");
        scenario.getChQuetes().add(quete1);
        scenario.getChQuetes().add(quete2);

        assertFalse(joueur.toutesQuetesCompletees(scenario)); // faux car le joueur n'a pas réaliser les quetes 18 et 19 du scénario
        assertTrue(joueur.toutesQuetesCompletees(new Scenario())); // vrai car on lui donne un scénario qui est vide donc il a forcement completer toutes le scénario
    }

    @Test
    void calculerDistance() {
        Joueur joueur = new Joueur();

        joueur.getPositionX();  // la position du joueur est à zéro en X
        joueur.getPositionY();  // la position du joueur est à zéro en Y
        int[] positionQueteA = {3, 4};

        int res_attendu = 7; //le resultat attendu est 7 car en X on fait 3-0 et en Y on fait 4-0 puis on additionne X+Y donc 3+4=7

        assertEquals(res_attendu,joueur.calculerDistance(positionQueteA));
        assertNotEquals(10,joueur.calculerDistance(positionQueteA));
    }

    @Test
    void getQuetesDisponiblesGloutonne(){

        //instancie les champs
        Joueur joueur = new Joueur();
        Scenario scenario_complet = new Scenario(); // scénario qui contiendra les trois quetes
        ArrayList<Quete> liste_quete_un = new ArrayList<>(); // liste qui va contenir seulement la quete 1

        Quete quete1 = new Quete("1|(4, 3)|()|2|100|explorer pic de Bhanborim");
        Quete quete2 = new Quete("2|(3, 1)|((1,),)|1|150|dialoguer avec Kaela la chaman des esprits");
        Quete quete3 = new Quete("4|(3, 2)|((2,),)|6|100|vaincre Loup Géant");

        scenario_complet.ajout(quete1);
        scenario_complet.ajout(quete2);
        scenario_complet.ajout(quete3);

        //scenario_complet.getChQuetes();


        liste_quete_un.add(quete1);

        // on stock ce que retourne la méthode dans une variable liste_quete_dispo
        ArrayList <Quete> liste_quete_dispo = joueur.getQuetesDisponiblesGloutonne(scenario_complet);

        assertEquals(liste_quete_un,liste_quete_dispo); // la liste avec seulement la quete 1 doit etre la meme que la liste renvoyée par la méthode getQuetesDisponiblesGloutonne
        assertTrue(liste_quete_dispo.contains(quete1)); // la liste renvoyée par getQuetesDisponiblesGloutonne doit contenir la quete 1
        assertFalse(liste_quete_dispo.contains(quete3)); // la liste renvoyée par getQuetesDisponiblesGloutonne ne doit contenir la quete 3, car les préconditions ne sont pas respectées, elle n'est donc pas disponible
        assertNotEquals(scenario_complet,liste_quete_dispo);

    }

    @Test
    void preconditionsSatisfaitesGloutonne(){
        Joueur joueur = new Joueur();

        Quete quete1 = new Quete("1|(4, 3)|()|2|100|explorer pic de Bhanborim");
        Quete quete2 = new Quete("2|(3, 1)|((1,),)|1|150|dialoguer avec Kaela la chaman des esprits");
        Quete quete3 = new Quete("4|(3, 2)|((2,1),(5,))|6|100|vaincre Loup Géant");

        assertTrue(joueur.preconditionsSatisfaitesGloutonne(quete1)); // la précondition est satifaite car elle n'en a pas
        joueur.completerQueteGloutonne(quete1);

        assertTrue(joueur.preconditionsSatisfaitesGloutonne(quete2)); // la précondition de la quete 2 est satisfaite donc on peut faire la quete
        joueur.completerQueteGloutonne(quete2);

        assertFalse(joueur.preconditionsSatisfaitesGloutonne(quete3)); // faux parce que la précondition de la quete 4 n'est pas satisfaite, le joueur n'a pas fait la quete numéro 5

    }


    @Test
    void seDeplacerVers(){
        //voir avec rayan parcce que dans completer quete gloutonne on déplace déja le joueur ducoup jsp trop à quoi elle sert cette méthode
    }







}
