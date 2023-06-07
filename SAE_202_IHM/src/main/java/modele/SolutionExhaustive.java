package modele;

import java.util.ArrayList;

public class SolutionExhaustive {

    private Scenario scenario;
    private Joueur joueur;

    public SolutionExhaustive(Scenario scenario, Joueur joueur) {
        this.scenario = scenario;
        this.joueur = joueur;
    }

    public void solutionExhaustive() {
        parcourirQuetes();
    }

    private void parcourirQuetes() {
        ArrayList<Quete> quetesDisponibles = joueur.getQuetesDisponiblesExhaustive(scenario);
        if (quetesDisponibles.isEmpty()) {
            System.out.println("Solution exhaustive complète atteinte!");
            System.out.println("Expérience totale: " + joueur.getExperience());
            System.out.println("Temps total: " + joueur.getTemps());
            System.out.println("Distance total: " + joueur.getChDistance());
            System.out.println("Nombre de quetes total: " + joueur.getChNbQuetes());
            joueur.afficherCheminQuetesExhaustive(); // Afficher le chemin des quêtes réalisées
            return;
        }

        // Rechercher la quête la plus proche parmi les quêtes disponibles
        Quete queteProche = trouverQuetePlusProche(quetesDisponibles);

        if (queteProche == null) {
            // Aucune quête disponible à réaliser, revenir en arrière
            return;
        }
        if (queteProche.getNumero()==0 && joueur.getExperience() >= queteProche.getExperience()){
            // Vérifier si le joueur est déjà sur la position de la quête
            if (joueur.getPositionX() == queteProche.getPos()[0] && joueur.getPositionY() == queteProche.getPos()[1]) {
                // Réaliser la quête directement
                joueur.completerQueteExhaustive(queteProche);
                quetesDisponibles.remove(queteProche);
            } else {
                // Se déplacer vers la quête la plus proche
                joueur.seDeplacerVers(queteProche.getPos()[0], queteProche.getPos()[1]);

                // Réaliser la quête
                joueur.completerQueteExhaustive(queteProche);
                quetesDisponibles.remove(queteProche);
            }
        }else {
            // Vérifier si le joueur est déjà sur la position de la quête
            if (joueur.getPositionX() == queteProche.getPos()[0] && joueur.getPositionY() == queteProche.getPos()[1]) {
                // Réaliser la quête directement
                joueur.completerQueteExhaustive(queteProche);
                quetesDisponibles.remove(queteProche);
            } else {
                // Se déplacer vers la quête la plus proche
                joueur.seDeplacerVers(queteProche.getPos()[0], queteProche.getPos()[1]);

                // Réaliser la quête
                joueur.completerQueteExhaustive(queteProche);
                quetesDisponibles.remove(queteProche);
            }
        }


        // Parcours exhaustif sans réaliser la quête
        ArrayList<Quete> quetesRestantes = new ArrayList<>(quetesDisponibles);
        quetesRestantes.remove(queteProche);
        parcourirQuetes();
    }



    private Quete trouverQuetePlusProche(ArrayList<Quete> quetesDisponibles) {
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

        return quetePlusProche;
    }
}
