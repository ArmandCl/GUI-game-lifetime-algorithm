package outil;

import modele.ConstantesFichierScenario;
import modele.Quete;
import modele.Scenario;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;


public class LectureFichierTexte {
    private static Scenario scenario;
    private static TreeMap<Integer, ArrayList<Quete>> scenarios;
    private static Integer numeroScenario;

    public LectureFichierTexte(){
        scenarios = new TreeMap<>();
        numeroScenario = 0;
        lectureFichiersScenarios();
    }

    public static void lectureFichiersScenarios() {


        for (String nomFichier : ConstantesFichierScenario.NOM_FICHIER) {
            //System.out.println(nomFichier);
            File file = new File("scenario"+ File.separator+nomFichier);
            lecture(file);
        }
        //System.out.println(scenarios);
    }

    /**
     * Permet de lire un fichier voulu en utilisant un scanner.
     * Crée un scénario (du type Scénario) où il stocke ce qu'il a lu du fichier
     *
     * @param fichier File Le fichier que nous voulons lire
     */
    public static void lecture(File fichier){
        scenario = new Scenario();
        try {
            Scanner scanner = new Scanner(fichier);
            while (scanner.hasNext()){
                Quete quete = (new Quete(scanner.nextLine()));
                scenario.ajout(quete);
            }
            scenarios.put(numeroScenario,scenario.getChQuetes());
            numeroScenario += 1;

        }
        catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
    }



    /**
     * Permet de recuperer le scénario qui a été créer grâce à la méthode au-dessus
     *
     * @return scenario Scenario
     */
    public Scenario getScenario(int key) {
        Scenario scenario = new Scenario();
        for (Quete quete: getKey(key))
            scenario.ajout(quete);
        return scenario;
    }

    /**
     * Permet de récupérer tous les scénarios stockés dans le TreeMap.
     *
     * @return TreeMap<Integer, Scenario> Le TreeMap contenant les scénarios
     */
    public static TreeMap<Integer, ArrayList<Quete>> getScenarios() {
        return scenarios;
    }

    public static ArrayList<Quete> getKey(int key){
        return scenarios.get(key);
    }


}
