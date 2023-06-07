package modele;

import java.util.ArrayList;

public class SolutionEfficace {
    private Scenario scenario;
    private Joueur joueur;
    private boolean queteFinal;

    /**
     * Methode constructeur de la classe Solution et permet d'instancier les deux champs
     * @param scenario Scenario
     * @param joueur Joueur
     */
    public SolutionEfficace(Scenario scenario, Joueur joueur) {
        this.scenario = scenario;
        this.joueur = joueur;
        queteFinal = false;
    }

    /**
     * Méthode pour trouver la quête la plus proche en termes de position
     * @param quetesDisponibles ArrayList<Quete> La liste de quete qui sont disponible (on a eu cette liste grâce à la methode getQuetesDisponibles)
     * @return quetePlusProche Quete La quete la plus proche
     */
    public Quete trouverQuetePlusProche(ArrayList<Quete> quetesDisponibles) {
        Quete quetePlusProche = null;
        int distanceMin = Integer.MAX_VALUE;

        for (Quete quete : quetesDisponibles) {
            int distance = joueur.calculerDistance(quete.getPos());
            if(quete.getNumero() == 0 && joueur.getExperience()>= quete.getExperience()){
                if (distance < distanceMin) {
                    distanceMin = distance;
                    quetePlusProche = quete;
                }
            }else if (quete.getNumero() != 0){
                if (distance < distanceMin) {
                    distanceMin = distance;
                    quetePlusProche = quete;
                }
            }

        }
        return quetePlusProche; // Sinon, retourner la quête la plus proche
    }



    /**
     * Methode pour utiliser la solution gloutonne
     */
    public void solutionGloutonne() {
        while (!queteFinal) {
            ArrayList<Quete> quetesDisponibles = joueur.getQuetesDisponiblesGloutonne(scenario);
            Quete quetePlusProche = trouverQuetePlusProche(quetesDisponibles);

            if (quetesDisponibles.isEmpty()) {
                // Toutes les quêtes ont été complétées, vérifier si c'est la solution complète
                if (joueur.toutesQuetesCompletees(scenario)) {
                    System.out.println("Solution Gloutonne complète atteinte!");
                    System.out.println("Expérience totale: " + joueur.getExperience());
                    System.out.println("Temps total: " + joueur.getTemps());
                    System.out.println("Distance total: " + joueur.getChDistance());
                    System.out.println("Nombre de quetes total: " + joueur.getChNbQuetes());
                    joueur.afficherCheminQuetesGloutonne();
                }
                return;
            }

            // Vérifier si la quête la plus proche existe et si c'est la quête finale

            if (quetePlusProche.getNumero() == 0 && joueur.getExperience() >= quetePlusProche.getExperience()) {
                if (joueur.getPositionX() == quetePlusProche.getPos()[0] && joueur.getPositionY() == quetePlusProche.getPos()[1]) {
                    // Réaliser la quête directement
                    joueur.completerQueteGloutonne(quetePlusProche);
                    quetesDisponibles.remove(quetePlusProche);
                } else {
                    // Se déplacer vers la quête la plus proche
                    joueur.seDeplacerVers(quetePlusProche.getPos()[0], quetePlusProche.getPos()[1]);

                    // Réaliser la quête
                    joueur.completerQueteGloutonne(quetePlusProche);
                    quetesDisponibles.remove(quetePlusProche);
                }
                System.out.println("Solution Gloutonne complète atteinte avec la quête finale!");
                System.out.println("Expérience totale: " + joueur.getExperience());
                System.out.println("Temps total: " + joueur.getTemps());
                System.out.println("Distance total: " + joueur.getChDistance());
                System.out.println("Nombre de quetes total: " + joueur.getChNbQuetes());
                joueur.afficherCheminQuetesGloutonne();
                queteFinal = true;
            }else {
                // Vérifier si le joueur est déjà sur la position de la quête
                if (joueur.getPositionX() == quetePlusProche.getPos()[0] && joueur.getPositionY() == quetePlusProche.getPos()[1]) {
                    // Réaliser la quête directement
                    joueur.completerQueteGloutonne(quetePlusProche);
                    quetesDisponibles.remove(quetePlusProche);
                } else {
                    // Se déplacer vers la quête la plus proche
                    joueur.seDeplacerVers(quetePlusProche.getPos()[0], quetePlusProche.getPos()[1]);

                    // Réaliser la quête
                    joueur.completerQueteGloutonne(quetePlusProche);
                    quetesDisponibles.remove(quetePlusProche);
                }
            }

        }
    }


}
