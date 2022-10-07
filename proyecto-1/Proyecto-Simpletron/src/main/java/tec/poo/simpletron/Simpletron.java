package tec.poo.simpletron;
import java.util.Scanner;

/**
 *William Gerardo Alfaro Quiros – 2022437996
 *
 * Angel Gabriel Vargas Varela - 2021080292
 */
public class Simpletron extends CodigosOperaciones {
    private final int[] memoryArray = new int[1000];
    private int numEntry;
    private int acumulador;
    private int secuenciaInstruccion;
    private int codigoOperacion;
    private boolean finish = true;
    public Simpletron() {
    }

    public void execute() {
        Scanner codeInputter = new Scanner(System.in);
        int entradaInstruccion = 0;
        int indiceMemoria = 0;


        while (entradaInstruccion != -99999) {
            System.out.printf("%03d> ", indiceMemoria);
            entradaInstruccion = codeInputter.nextInt();
            this.memoryArray[indiceMemoria] = entradaInstruccion;
            indiceMemoria += 1;
        }
        System.out.print("Carga completada, ejecutando\n"); //"\n%s\n%s\n\n",

        while(this.finish) {

            this.terminarInstruccion();
            this.funciones(this.codigoOperacion, this.numEntry);

        }

        System.exit(0);
    }

    private void terminarInstruccion() {
        int registroInstruccion;
        registroInstruccion = this.memoryArray[this.secuenciaInstruccion];
        codigoOperacion = registroInstruccion / 1000;
        numEntry = registroInstruccion % 1000;
    }

    private void rangeOperationNum(int operationCode){
        if(operationCode < 10 || operationCode > 52){
            System.out.println("\nSimple> Codigo invalido\n");
            System.exit(-1);
        }
    }

    private void funciones(int operationCode, int numEntry) {
        boolean bifurcador = false;
            switch (operationCode) {

                case 10:
                    Scanner read = new Scanner(System.in);
                    System.out.print("Simple> Digita un numero: ");

                    int number = read.nextInt();

                    this.memoryArray[numEntry] = number;
                    //rangeOperationNum(number);
                    break;
                case 11:
                    System.out.print("Simple> ");
                    System.out.println(this.memoryArray[numEntry]);

                    break;
                case 20:
                    acumulador = this.memoryArray[numEntry];
                    break;
                case 21:
                    memoryArray[numEntry] = this.acumulador;
                    break;
                case 30:
                    acumulador += this.memoryArray[numEntry];
                    break;
                case 31:
                    acumulador -= this.memoryArray[numEntry];
                    break;
                case 33:
                    if (memoryArray[numEntry] != 0) {
                        acumulador /= this.memoryArray[numEntry];
                        break;
                    } else {
                        System.out.printf("Division entre 0");
                        System.exit(-1);
                    }
                case 32:
                    acumulador *= this.memoryArray[numEntry];
                    break;
                case 34:
                    acumulador %= this.memoryArray[numEntry];
                    break;
                case 35:
                    acumulador = (int) Math.pow((double) this.memoryArray[numEntry], (double) this.memoryArray[numEntry]);
                    break;
                case 40:
                    secuenciaInstruccion = numEntry;
                    bifurcador = true;
                    break;
                case 41:
                    if (acumulador < 0) {
                        secuenciaInstruccion = numEntry;
                        bifurcador = true;
                    }
                    break;
                case 42:
                    if (acumulador == 0) {
                        secuenciaInstruccion = numEntry;
                        bifurcador = true;
                    }
                    break;
                case 43:
                    if (acumulador > 0) {
                        secuenciaInstruccion = numEntry;
                        bifurcador = true;
                    }
                    break;
                case 44:
                    finish = false;
                default:
                    break;
            }

            if (!bifurcador) {
                secuenciaInstruccion += 1;

        }

    }

}

