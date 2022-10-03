package edu.KurtP.Simpletron;

import java.util.Scanner;

/**
 * @author William Alfaro y Angel Vargas
 * @version 1.0.0.01082013
 */
public class Simpletron extends SimpletronOperationCodes {

    private int[] memory = new int[100];
    private int accumulator;
    private int instructionCounter;
    private int instructionRegister;
    private int operationCode;
    private int operand;
    private boolean run = true;

    /**
     * The
     * <code>run</code> method will start Simpletron, display the welcome
     * message and then go strait into SML execution.
     *
     * @return void
     */
    public void run() {
        welcomeMessage();
        execute();
    }

    /**
     * The welcome message when Simpletron is first started.
     *
     * @return void
     */
    private void welcomeMessage() {
        System.out.println("***            Bienvenido a Simpletron!           ***");
        System.out.println("***            Ingrese una instruccion            ***");
        System.out.println("***      Para ejecutar use la instruccion +44000     ***");
    }

    private void execute() {
        Scanner codeInputter = new Scanner(System.in);
        int instructionInput = 0;
        int memoryPointer = 0;

        do {
            //Output the code input prompt
            System.out.printf("%02d ? ", memoryPointer);
            //Take the user input and assign it to the input var.
            instructionInput = codeInputter.nextInt();
            //place the input into the correct memory location
            memory[memoryPointer] = instructionInput;
            //Increment the pointer by one
            memoryPointer++;
            System.out.println(instructionInput + "<-");
        }
        while (instructionInput != -99999);

        System.out.printf("\n%s\n%s\n\n", "***  Program loading complete ***",
                "*** Program excution begins ***");

        while (run) {
            loadCode();
            operations(operationCode, operand);
        }

        System.exit(0);
    }

    /**
     * Using the
     * <code>instructionRegister</code> var,
     * <code>loadCode()</code> will determine what operation will be executed
     * and which memory location it will need to access to complete that
     * operation.
     *
     * @return void
     */
    private void loadCode() {
        instructionRegister = memory[instructionCounter];

        operationCode = instructionRegister / 1000;
        operand = instructionRegister % 1000;

        instructionRegister = memory[instructionCounter];

        operationCode = instructionRegister / 1000;
        operand = instructionRegister % 1000;
    }

    /**
     * Once the operation and operand are determined by
     * <code>loadCode()</code> they are executed.
     *
     * @param operationCode
     * @param operand
     * @return void
     */
    private void operations(int operationCode, int operand) {
        boolean branching = false;
        switch (operationCode) { //Start switch

            //Operations for reading input from the user

            case Leer:
                Scanner read = new Scanner(System.in);
                System.out.print("Enter a number: ");
                int number = read.nextInt();
                memory[operand] = number;
                break;

            //Operations for outputting to the user
            case Escribir:
                System.out.println(memory[operand]);
                break;

            //Load the value found in memory into the accumulator
            case Cargar:
                accumulator = memory[operand];
                break;

            //Put the value in the accumlator in to memroy
            case Almacenar:
                memory[operand] = accumulator;
                break;

            //Add the value in the accumulator and a value from memroy
            case Suma:
                System.out.println("Si suma");
                accumulator += memory[operand];
                break;

            //Subtract the value in the accumulator and a value in memory
            case Resta:
                accumulator -= memory[operand];
                break;

            //Divide the value in the accumulator by a value in memory
            case Dividir:
                //Can't divide by zero.
                if (memory[operand] == 0) {
                    System.out.printf("\n%s\n%s\n", "*** CANNOT DIVIDE BY ZERO ***", "*** EXITING NOW ***");
                    System.exit(-1);
                }
                else {
                    accumulator /= memory[operand];
                    break;
                }

            //Mulitply the value in the accumulator by a value in memory
            case Multiplicar:
                accumulator *= memory[operand];
                break;


            //Mulitply the value in the accumulator by a value in memory
            case Modulo:
                accumulator %= memory[operand];
                break;

            //Mulitply the value in the accumulator by a value in memory
            case Exponenciacion:
                accumulator = (int) Math.pow(memory[operand],memory[operand]);
                break;


            //Branc to a specific memory location
            case Bifurca:
                instructionCounter = operand;
                branching = true;
                break;

            //Branch to a memory location if the accumulator is less than zero
            case Bifurca_Negativo:
                if (accumulator < 0) {
                    instructionCounter = operand;
                    branching = true;
                }
                break;

            case Parar:
                System.out.println("Processing complete...");
                run = false;
                memoryDump();
                break;


           case Bifurca_Positivo:
                if (accumulator > 0) {
                    instructionCounter = operand;
                    branching = true;
                }
                break;

            //Branch to a memroy location if the accumulator is zero
            case Bifurca_Zero:
                if (accumulator == 0) {
                    instructionCounter = operand;
                    branching = true;
                }
                break;

            //Finsh processing


        } //End switch

        /*
         * While I was testing, I noticed that if I neede to branch to a lower
         * memory location, the instruction counter would will increment. To
         * solvie this issue I added the boolean 'branch' var. Only when the
         * Simpletron is not branching, will the counter increment.
         */
        if (!branching) {
            instructionCounter++;
        }
    } //End of operations method

    /**
     * Outputs the values found in the
     * <code>memory</code>
     *
     * @return void
     */

    private void memoryDump() {
        int tens, ones;

//        System.out.printf("%s\t%04d\n", "Accumlator", acculator);

        System.out.printf("\t%02d\t%02d\t%02d\t%02d\t%02d\t%02d\t%02d\t%02d\t%02d\t%02d\n", 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        for (tens = 0; tens < 100; tens += 10) {
            System.out.printf("%02d\t", tens);
            for (ones = 0; ones < 10; ones++) {
                System.out.printf("%04d\t", memory[tens + ones]);
            }
            System.out.println();
        }
    }
}