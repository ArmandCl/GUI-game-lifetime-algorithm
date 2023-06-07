package modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Cette classe nous permettra de tester les différentes méthodes de la classe Quete et de nous assurer qu'elles fonctionnent comme voulu
 */
class QueteTest {

    @Test
    void extraitPrecond() {
        int[] attendu = new int[4];
        attendu[0] = 2;
        attendu[1] = 16;
        attendu[2] = 0;
        attendu[3] = 0;

        Quete quete = new Quete("18|(16, 6)|((2, 16),)|1|100|vaincre Géant du feu");

        int[] precond = quete.extraitPrecond("((2, 16),))");
        assertArrayEquals(attendu,precond);

        int[] tab_vide = new int[4];

        assertNotEquals(tab_vide,precond);
    }

    @Test
    void extraitPos(){
        int[] tab_attendu = new int[2];
        tab_attendu[0]=16;
        tab_attendu[1]=6;

        Quete quete = new Quete("18|(16, 6)|((2, 16),)|1|100|vaincre Géant du feu");

        int[] extrait_position = quete.extraitPos("(16 ,6)");

        assertArrayEquals(tab_attendu,extrait_position);

        int[] tab_vide = new int[2];
        assertNotEquals(tab_vide,extrait_position);
    }
}