/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpletron;

/**
 *
 * @author gabri
 */

public class main {

    public static void main(String[] args) {
        if (args.length > 0) {
            for (String s : args) {
                if ("-h".equals(s) || "--help".equals(s)) {
                    helpMessage();
                    System.exit(0);
                }
            }
            System.out.println("Invalid options. Use \"-h\" or \"--help\" for help");
            System.exit(0);
        }
        else {
            run();
        }
    }

    public static void run() {
        LMS s = new LMS();

        s.run();
    }

    public static void helpMessage() {
        System.out.println("Test help message");
    }
}
