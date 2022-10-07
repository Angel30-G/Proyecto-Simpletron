package tec.poo.simpletron;
/**
 *William Gerardo Alfaro Quiros – 2022437996
 *
 * Angel Gabriel Vargas Varela - 2021080292
 */
public class Terminal {
    public Terminal() {
    }

    //Clase principal del simpletron
    public static void main(String[] args) {
        Simpletron LMS = new Simpletron();
        System.out.println("Simplretron [version 1.0.0]\n");
        LMS.execute();
    }
}
